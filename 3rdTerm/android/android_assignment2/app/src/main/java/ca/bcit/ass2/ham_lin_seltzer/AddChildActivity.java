package ca.bcit.ass2.ham_lin_seltzer;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddChildActivity extends AppCompatActivity {

    SantasListDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        db = new SantasListDbHelper(this);
    }

    public void addChild(View v) {
        EditText childFirstNameTextInput = findViewById(R.id.addTextFirstName);
        String addFirstName = childFirstNameTextInput.getText().toString().trim();

        EditText childLastTextInput = findViewById(R.id.addTextLastName);
        String addLastName = childLastTextInput.getText().toString().trim();

        EditText childBirthDateTextInput = findViewById(R.id.addTextBirthDate);
        String addBirthDate = childBirthDateTextInput.getText().toString().trim();

        EditText childStreetTextInput = findViewById(R.id.addTextStreet);
        String addStreet = childStreetTextInput.getText().toString().trim();

        EditText childCityTextInput = findViewById(R.id.addTextCity);
        String addCity = childCityTextInput.getText().toString().trim();

        EditText childProvinceTextInput = findViewById(R.id.addTextProvince);
        String addProvince = childProvinceTextInput.getText().toString().trim();

        EditText childPostalTextInput = findViewById(R.id.addTextPostalCode);
        String addPostalCode = childPostalTextInput.getText().toString().trim();

        EditText childCountryTextInput = findViewById(R.id.addTextCountry);
        String addCountry = childCountryTextInput.getText().toString().trim();

        EditText childLongTextInput = findViewById(R.id.addTextLong);
        String stringAddLong = childLongTextInput.getText().toString().trim();

        double addLong = Double.parseDouble(stringAddLong);

        EditText childLatTextInput = findViewById(R.id.addTextLat);
        String stringAddLat = childLatTextInput.getText().toString().trim();

        double addLat = Double.parseDouble(stringAddLat);

        Spinner childNameTextInput = findViewById(R.id.spinnerNaughty);
        String addIsNaughtyString = childNameTextInput.getSelectedItem().toString().trim();
        boolean addIsNaughty;
        if (addIsNaughtyString.equals("true")) {
            addIsNaughty = true;
        } else {
            addIsNaughty = false;
        }

        Child newChild = new Child(addFirstName, addLastName, addBirthDate, addStreet,
                addCity, addProvince, addPostalCode, addCountry, addLong, addLat,
                addIsNaughty, new java.util.Date().toString());

        if(db.addKid(newChild)) {
            Toast.makeText(this, "Child added", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(AddChildActivity.this, MainActivity.class);
            finish();
            AddChildActivity.this.startActivity(myIntent);
        } else {
            Toast.makeText(this, "Could not add child", Toast.LENGTH_SHORT).show();
        }

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
}
