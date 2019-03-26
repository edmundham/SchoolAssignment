package ca.bcit.ass2.ham_lin_seltzer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class EditChildActivity extends AppCompatActivity {

    private SantasListDbHelper db;
    private Child child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_child);
        db = new SantasListDbHelper(this);

        String firstName = getIntent().getExtras().get("firstName").toString();
        String lastName = getIntent().getExtras().get("lastName").toString();
        child = getChild(firstName, lastName);

        final EditText editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextFirstName.setText(child.get_firstName());

        final EditText editTextLastName = findViewById(R.id.editTextLastName);
        editTextLastName.setText(child.get_lastName());

        final EditText editTextBirthDate = findViewById(R.id.editTextBirthDate);
        editTextBirthDate.setText(child.get_birthDate());

        final EditText editTextStreet = findViewById(R.id.editTextStreet);
        editTextStreet.setText(child.get_street());

        final EditText editTextCity = findViewById(R.id.editTextCity);
        editTextCity.setText(child.get_city());

        final EditText editTextProvince = findViewById(R.id.editTextProvince);
        editTextProvince.setText(child.get_province());

        final EditText editTextPostalCode = findViewById(R.id.editTextPostalCode);
        editTextPostalCode.setText(child.get_postalCode());

        final EditText editTextCountry = findViewById(R.id.editTextCountry);
        editTextCountry.setText(child.get_country());

        final EditText editTextLong = findViewById(R.id.editTextLong);
        String longTextString = Double.toString(child.get_longitude());
        editTextLong.setText(longTextString);

        final EditText editTextLat = findViewById(R.id.editTextLat);
        String latTextString = Double.toString(child.get_latitude());
        editTextLat.setText(latTextString);

        final Spinner editSpinnerNaughty = findViewById(R.id.editSpinnerNaughty);
        String isNaughtyString = String.valueOf(child.is_isNaughty());
        editSpinnerNaughty.setSelection(((ArrayAdapter<String>)editSpinnerNaughty.getAdapter()).getPosition(isNaughtyString));

        final TextView labelDateCreated = findViewById(R.id.labelDateCreated);
        labelDateCreated.setText(child.get_dateCreated());

        Button saveChildBtn = findViewById(R.id.saveChildBtn);

        saveChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String birthDate = editTextBirthDate.getText().toString().trim();
                String street = editTextStreet.getText().toString().trim();
                String city = editTextCity.getText().toString().trim();
                String province = editTextProvince.getText().toString().trim();
                String postalCode = editTextPostalCode.getText().toString().trim();
                String country = editTextCountry.getText().toString().trim();
                String longitude = editTextLong.getText().toString().trim();
                String latitude = editTextLat.getText().toString().trim();
                String isNaughty = editSpinnerNaughty.getSelectedItem().toString().trim();
                String dateCreated = child.get_dateCreated();

                if (TextUtils.isEmpty(firstName)) {
                    editTextFirstName.setError("First Name is required");
                    return;
                } else if (TextUtils.isEmpty(lastName)) {
                    editTextLastName.setError("Last Name is required");
                    return;
                } else if (TextUtils.isEmpty(birthDate)) {
                    editTextBirthDate.setError("Birth date is required");
                } else if (TextUtils.isEmpty(street)) {
                    editTextStreet.setError("Street is required");
                } else if (TextUtils.isEmpty(city)) {
                    editTextCity.setError("City is required");
                } else if (TextUtils.isEmpty(province)) {
                    editTextProvince.setError("Province is required");
                } else if (TextUtils.isEmpty(postalCode)) {
                    editTextPostalCode.setError("Postal Code is required");
                } else if (TextUtils.isEmpty(country)) {
                    editTextCountry.setError("Country is required");
                } else if (TextUtils.isEmpty(longitude)) {
                    editTextLong.setError("Longitude is required and must be a number");
                } else if (TextUtils.isEmpty(latitude)) {
                    editTextLat.setError("Latitude is required and must be a number");
                }

                boolean editIsNaughty;
                if (isNaughty.equals("true")) {
                    editIsNaughty = true;
                } else {
                    editIsNaughty = false;
                }
                double editLong = Double.parseDouble(longitude);
                double editLat = Double.parseDouble(latitude);

                Child c = new Child(firstName, lastName, birthDate, street, city, province,
                        postalCode, country, editLong, editLat, editIsNaughty, dateCreated);

                if (db.editChild(c)) {
                    success();
                } else {
                    fail();
                }
            }
        });

    }

    private void success() {
        Toast.makeText(this, "Child edited", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(EditChildActivity.this, MainActivity.class);
        finish();
        EditChildActivity.this.startActivity(myIntent);
    }

    private void fail() {
        Toast.makeText(this, "Could not add child", Toast.LENGTH_SHORT).show();
    }

    private Child getChild(String firstName, String lastName) {
        SQLiteOpenHelper helper = new SantasListDbHelper(this);
        try {
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = db.query("LIST",
                    new String[]{"FIRST_NAME", "LAST_NAME", "BIRTH_DATE", "STREET", "CITY",
                            "PROVINCE", "POSTAL_CODE", "COUNTRY", "LATITUDE", "LONGITUDE", "ISNAUGHTY",
                            "DATE_CREATED"},
                    "first_name = ? and last_name = ?",
                    new String[]{firstName, lastName},
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
                        cursor.getInt(8),
                        cursor.getInt(9),
                        cursor.getInt(10) > 0,
                        cursor.getString(11)
                );
            }
        } catch (SQLiteException sqlex) {
            String msg = "[EditChildActiivty/getChild] DB unavailable";
            msg += "\n\n" + sqlex.toString();

            Toast t = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            t.show();
        }

        return child;
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
                Toast.makeText(this, "You are on the editing page already", Toast.LENGTH_LONG).show();
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
