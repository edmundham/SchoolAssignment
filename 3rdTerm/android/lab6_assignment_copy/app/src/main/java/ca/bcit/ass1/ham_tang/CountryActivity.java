package ca.bcit.ass1.ham_tang;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import ca.bcit.ass1.ham_tang.http.Country;

public class CountryActivity extends AppCompatActivity {

    private static final String TAG = "CountryActivity";
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Bundle bundle = getIntent().getExtras();
        String continent = bundle.getString("continent");

        Country country = new Country();
        country.setCountriesListByContinent(continent);

        String[] countryNames = country.getCountiesListByContinent();

        list = new ArrayList<String>(Arrays.asList(countryNames));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_share:
                shareInfo();
                return true;
            case R.id.action_settings:
                openMyDevicePage();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void shareInfo() {
        String msg = "";

        for (String content : list) {
            msg += content + " ";
        }

        Intent smsIntent = new Intent(Intent.ACTION_SEND);
        smsIntent.setType("text/plain");
        smsIntent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(smsIntent);
    }

    private void openMyDevicePage() {
        Intent intent = new Intent(this, MyDevice.class);
        startActivity(intent);
    }
}
