package ca.bcit.ass2.ham_lin_seltzer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class ChildrenDetailsActivity extends AppCompatActivity {

    private SantasListDbHelper db;
    private Cursor cursor;
    private Child child = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_details);
        db = new SantasListDbHelper(this);

        String chld = getIntent().getExtras().get("child").toString();
        if (chld.equals("0")) {
            TextView name = findViewById(R.id.firstName);
            name.setText("No matching values");
        } else {
            Child child = getChild(chld);

            TextView name = findViewById(R.id.firstName);
            name.setText(getResources().getString(R.string.firstNameLabel, child.get_firstName()));

            TextView desc = findViewById(R.id.lastName);
            desc.setText(getResources().getString(R.string.lastNameLabel, child.get_lastName()));

            TextView birth = findViewById(R.id.birthDate);
            birth.setText(getResources().getString(R.string.birthdateLabel, child.get_birthDate()));

            TextView street = findViewById(R.id.street);
            street.setText(getResources().getString(R.string.streetLabel, child.get_street()));

            TextView city = findViewById(R.id.city);
            city.setText(getResources().getString(R.string.cityLabel, child.get_city()));

            TextView province = findViewById(R.id.province);
            province.setText(getResources().getString(R.string.provinceLabel, child.get_province()));

            TextView postalCode = findViewById(R.id.postalCode);
            postalCode.setText(getResources().getString(R.string.postalCodeLabel ,child.get_postalCode()));

            TextView count = findViewById(R.id.country);
            count.setText(getResources().getString(R.string.countryLabel,child.get_country()));

            TextView lat = findViewById(R.id.latitude);
            Double latitudeNum = child.get_latitude();
            String latString = latitudeNum.toString();
            lat.setText(getResources().getString(R.string.latitudeLabel, latString));

            TextView longitude = findViewById(R.id.longitude);
            Double longNum = child.get_longitude();
            String longString = longNum.toString();
            longitude.setText(getResources().getString(R.string.longitudeLabel, longString));

            TextView isNaughty = findViewById(R.id.isNaughty);
            String string = valueOf(child.is_isNaughty());
            isNaughty.setText(getResources().getString(R.string.naughtyLabel, string));

            TextView dateCreated = findViewById(R.id.dateCreated);
            dateCreated.setText(getResources().getString(R.string.dateCreatedLabel, child.get_dateCreated()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (cursor != null)
            cursor.close();

        if (db != null)
            db.close();
    }

    private Child getChild(String chld) {
        SQLiteOpenHelper helper = new SantasListDbHelper(this);
        try {
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME", "BIRTH_DATE", "STREET", "CITY",
                            "PROVINCE", "POSTAL_CODE", "COUNTRY", "LATITUDE", "LONGITUDE", "ISNAUGHTY",
                            "DATE_CREATED"},
                    "FIRST_NAME = ? OR LAST_NAME = ?",
                    new String[]{chld, chld},
                    null, null, null);

            // move to the first record
            if (cursor.moveToFirst()) {
                // get the child details from the cursor
                child = new Child(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getDouble(8),
                        cursor.getDouble(9),
                        cursor.getInt(10) > 0,
                        cursor.getString(11)
                );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[ChildrenDetailsActivity/getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }

        return child;
    }

    public void deleteChild(View v) {
        if (db.deleteChild(child)) {
            Toast.makeText(this, "Child Deleted", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(ChildrenDetailsActivity.this, MainActivity.class);
            finish();
            ChildrenDetailsActivity.this.startActivity(myIntent);
        } else {
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(ChildrenDetailsActivity.this, MainActivity.class);
            finish();
            ChildrenDetailsActivity.this.startActivity(myIntent);
        }
    }


    public void btnToEditChild(View v) {
        Intent intent = new Intent(ChildrenDetailsActivity.this, EditChildActivity.class);

        intent.putExtra("firstName", child.get_firstName());
        intent.putExtra("lastName", child.get_lastName());
        finish();
        startActivity(intent);
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
                Intent intent = new Intent(ChildrenDetailsActivity.this, EditChildActivity.class);

                intent.putExtra("firstName", child.get_firstName());
                intent.putExtra("lastName", child.get_lastName());
                finish();
                startActivity(intent);
                return true;
            case R.id.menu_delete_child:
                if (db.deleteChild(child)) {
                    Toast.makeText(this, "Child Deleted", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(ChildrenDetailsActivity.this, MainActivity.class);
                    finish();
                    ChildrenDetailsActivity.this.startActivity(myIntent);
                } else {
                    Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(ChildrenDetailsActivity.this, MainActivity.class);
                    finish();
                    ChildrenDetailsActivity.this.startActivity(myIntent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
