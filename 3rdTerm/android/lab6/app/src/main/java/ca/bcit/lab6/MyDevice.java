package ca.bcit.lab6;

import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyDevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_device);

        TextView textView = findViewById(R.id.textView);

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

        textView.setText(msg);
    }
}
