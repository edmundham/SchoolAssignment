package ca.bcit.lab6;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ShareActionProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        String msg = "Manufacturer: ";
        msg += Build.MANUFACTURER;
        msg += "\nModel: ";
        msg += Build.MODEL;
        msg += "\nVersion: ";
        msg += Build.VERSION.SDK_INT;
        msg += "\nVersion Release: ";
        msg += Build.VERSION.RELEASE;
        msg += "\nSerial Number: ";
        msg += Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

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
