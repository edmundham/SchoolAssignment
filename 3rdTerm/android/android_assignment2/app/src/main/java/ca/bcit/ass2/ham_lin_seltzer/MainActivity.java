package ca.bcit.ass2.ham_lin_seltzer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private static FragmentManager fm;
    private Cursor cursor;
    private Child currentChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.student_name);
        textView.setText("Sunguk (Edmund) Ham - A00979841\nFelix Lin - A00959121\nNoah Seltzer - A01012833");

        ListView list_children = (ListView) findViewById(R.id.list_children);

        String[] children = getChildren();
        fm = getSupportFragmentManager();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, children
        );

        list_children.setAdapter(arrayAdapter);

        list_children.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view;
                String child = tv.getText().toString();

                View fragmentContainer = findViewById(R.id.fragment_container);
                if (fragmentContainer != null) {
                    ChildrenDetailsFragment details = new ChildrenDetailsFragment();
                    details.setChildName(child);
                    FragmentTransaction ft = fm.beginTransaction();
                    if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        getSupportFragmentManager().popBackStack();
                    }
                    ft.replace(R.id.fragment_container, details);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                } else{
                    Intent intent = new Intent(MainActivity.this, ChildrenDetailsActivity.class);
                    intent.putExtra("child", child);

                    startActivity(intent);
                }


            }
        });

    }

    protected static void openDetailFragment(String childName) {
        ChildrenDetailsFragment details = new ChildrenDetailsFragment();
        details.setChildName(childName);
        FragmentTransaction ft = fm.beginTransaction();
        if(fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        }
        ft.replace(R.id.fragment_container, details);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private String[] getChildren() {
        SQLiteOpenHelper helper = new SantasListDbHelper(this);
        String[] children = null;
        try {
            db = helper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select DISTINCT FIRST_NAME, LAST_NAME from LIST", null);

            int count = cursor.getCount();
            children = new String[count];

            if (cursor.moveToFirst()) {
                int ndx = 0;
                do {
                    children[ndx++] = cursor.getString(0);
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException sqlex) {
            String msg = "[MainActivity / getChildren] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }
        return children;
    }

    private String getChildFirstName(String firstOrLastName) {
        SQLiteOpenHelper helper = new SantasListDbHelper(this);
        Child child = null;
        String childName = null;
        try {
            db = helper.getReadableDatabase();
            Cursor cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME"},
                    "FIRST_NAME = ? OR LAST_NAME = ?",
                    new String[]{firstOrLastName, firstOrLastName},
                    null,
                    null,
                    null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the country details from the cursor
                child = new Child(
                        cursor.getString(0),
                        cursor.getString(1)
                );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[MainActivity / getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }
        if (child != null) {
            return child.get_firstName();
        }
        Child c = new Child(null, null);
        c.get_firstName();
        return c.get_firstName();
    }

    public void btnSearchChild(View v) {
        EditText childNameTextInput = findViewById(R.id.childName);
        String searchWord = childNameTextInput.getText().toString();
        String childName = getChildFirstName(searchWord);

        Intent intent = new Intent(MainActivity.this, ChildrenDetailsActivity.class);
        intent.putExtra("child", childName);

        startActivity(intent);
    }

    public void btnToAddChild(View v) {
        Intent intent = new Intent(MainActivity.this, AddChildActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.menu, menu);
        return true;
    }


    public void deleteChild(View v) {
        ChildrenDetailsFragment currentDetails = (ChildrenDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        Child current = currentDetails.getChild();
        SantasListDbHelper db = new SantasListDbHelper(this);
        if (db.deleteChild(current)) {
            Toast.makeText(this, "Child Deleted", Toast.LENGTH_SHORT).show();

            if(fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            }
            ListView list_children = (ListView) findViewById(R.id.list_children);

            String[] children = getChildren();
            fm = getSupportFragmentManager();


            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this, android.R.layout.simple_list_item_1, children
            );

            list_children.setAdapter(arrayAdapter);

            //finish();

        }
    }

    public void btnToEditChild(View v) {
        Intent intent = new Intent(MainActivity.this, EditChildActivity.class);
        ChildrenDetailsFragment currentDetails = (ChildrenDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        Child current = currentDetails.getChild();
        intent.putExtra("firstName", current.get_firstName());
        intent.putExtra("lastName", current.get_lastName());
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                View fragmentContainer = findViewById(R.id.fragment_container);
                if (fragmentContainer != null) {
                    SearchFragment details = new SearchFragment();

                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.search_fragment_container, details);
                    ft.addToBackStack(null);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.commit();
                } else {

                    startActivity(new Intent(MainActivity.this, SearchActivity.class));
                }
                return true;

            case R.id.menu_add_child:
                startActivity(new Intent(MainActivity.this, AddChildActivity.class));
                return true;
            case R.id.menu_edit_child:
                Toast.makeText(this, "No child selected, open search page", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            case R.id.menu_delete_child:
                Toast.makeText(this, "No child selected, open search page", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public void btnToggleClick(View v) {
        EditText childNameTextInput = findViewById(R.id.childName);
        String searchWord = childNameTextInput.getText().toString();
        String childName = getChildByFirstOrLastName(searchWord);
        openDetailFragment(childName);
    }

    private String getChildByFirstOrLastName(String firstOrLastName) {
        SQLiteOpenHelper helper = new SantasListDbHelper(this);
        Child child = null;
        String childName = null;
        try {
            db = helper.getReadableDatabase();
            cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME"},
                    "FIRST_NAME = ? OR LAST_NAME = ?",
                    new String[]{firstOrLastName, firstOrLastName},
                    null,
                    null,
                    null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the country details from the cursor
                child = new Child(
                        cursor.getString(0),
                        cursor.getString(1)
                );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[MainActivity / getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }
        if (child != null) {
            return child.get_firstName();
        }
        Child c = new Child(null, null);
        c.get_firstName();
        return c.get_firstName();
    }


}
