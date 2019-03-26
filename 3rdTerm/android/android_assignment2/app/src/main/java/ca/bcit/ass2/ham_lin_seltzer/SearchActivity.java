package ca.bcit.ass2.ham_lin_seltzer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void btnToggleClick(View v) {
        EditText childNameTextInput = findViewById(R.id.childName);
        String searchWord = childNameTextInput.getText().toString();
        String childName = getChildByFirstOrLastName(searchWord);

        Intent intent = new Intent(SearchActivity.this, ChildrenDetailsActivity.class);
        intent.putExtra("child", childName);

        startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                finish();
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            case R.id.menu_add_child:
                finish();
                startActivity(new Intent(this, AddChildActivity.class));
                return true;
            case R.id.menu_edit_child:
                finish();
                Toast.makeText(this, "No child selected, open search page", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            case R.id.menu_delete_child:
                finish();
                Toast.makeText(this, "No child selected, open search page", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
