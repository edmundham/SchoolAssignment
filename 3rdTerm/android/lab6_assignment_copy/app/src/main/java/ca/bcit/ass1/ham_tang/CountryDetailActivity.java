package ca.bcit.ass1.ham_tang;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;

import java.util.List;

import ca.bcit.ass1.ham_tang.http.Country;

public class CountryDetailActivity extends AppCompatActivity {

    private static final String TAG = "CountryDetailActivity";
    private Country country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Bundle bundle = getIntent().getExtras();
        String countryKey = bundle.getString("country");

        country = new Country();
        country.setCountryDetailsByCountryName(countryKey);

        setCountryDetails(findViewById(R.id.country_name), country.getName());
        setCountryDetails(findViewById(R.id.country_captital), country.getCapital());
        setCountryDetails(findViewById(R.id.country_region), country.getRegion());
        setCountryDetails(findViewById(R.id.country_population), String.valueOf(country.getPopulation()));
        setCountryDetails(findViewById(R.id.country_area), String.valueOf(country.getArea()));
        setCountryBorders(findViewById(R.id.country_borders), country.getBorders());
        setCountyFlag(findViewById(R.id.country_flag), country.getFlag());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SvgLoader.pluck().close();
    }

    private void setCountryDetails(View view, String detail) {
        ((TextView) view).setText(((TextView) view).getText() + " " + detail);
    }

    private void setCountryBorders(View view, List<String> borders) {
        if (borders.isEmpty()) {
            ((TextView) view).setText(((TextView) view).getText() + "N/A");
            return;
        }

        String textViewString = new String();
        for (String str : borders) {
            textViewString += str + " ";
        }
        ((TextView) view).setText(((TextView) view).getText() + " " + textViewString);
    }

    private void setCountyFlag(View view, String link) {
        if (link == null) {
            return;
        }

        ImageView flag = (ImageView) view;
        SvgLoader.pluck().with(this).setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher).load(link, flag);
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
        String msg = country.getName() + " ";
        msg += country.getCapital() + " ";
        msg += country.getRegion() + " ";
        msg += country.getPopulation() + " ";
        msg += country.getArea() + " ";
        msg += country.getBorders() + " ";
        msg += country.getFlag() + " ";

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
