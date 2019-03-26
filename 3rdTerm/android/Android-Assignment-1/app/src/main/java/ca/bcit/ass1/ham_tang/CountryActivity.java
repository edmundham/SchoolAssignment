package ca.bcit.ass1.ham_tang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import ca.bcit.ass1.ham_tang.http.Country;

public class CountryActivity extends AppCompatActivity {

    private static final String TAG = "CountryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Bundle bundle = getIntent().getExtras();
        String continent = bundle.getString("continent");

        Country country = new Country();
        country.setCountriesListByContinent(continent);

        String[] countryNames = country.getCountiesListByContinent();

        final ArrayList<String> list = new ArrayList<String>(Arrays.asList(countryNames));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, list);

        ListView view = findViewById(R.id.country_listView);
        view.setAdapter(arrayAdapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CountryActivity.this, CountryDetailActivity.class);
                i.putExtra("country", list.get(position));
                Log.e(TAG, list.get(position));
                startActivity(i);
            }
        });
    }
}
