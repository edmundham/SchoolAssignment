package ca.bcit.lab2;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ca.bcit.lab2.utils.Utilities;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChangeColor(View view) {
        int color = Utilities.colorGenerator();
        View mainView = this.getWindow().getDecorView();
        mainView.setBackgroundColor(color);
    }

    public void onClickSpeak(View view) {
        Intent myIntent = new Intent(this, SpeechActivity.class);
        this.startActivity(myIntent);
    }

    public void onClickApiVersion(View view) {
        String manufacturer = android.os.Build.MANUFACTURER;
        String model = android.os.Build.MODEL;
        int version = android.os.Build.VERSION.SDK_INT;
        String versionRelease = android.os.Build.VERSION.RELEASE;

        String messageText = "manufacturer " + manufacturer
                + " \n model " + model
                + " \n version " + version
                + " \n versionRelease " + versionRelease;

        Toast.makeText(getApplicationContext(), messageText ,Toast.LENGTH_LONG).show();
    }

    public void onClickSerialNumber(View view) {
        String deviceId = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);
        Intent mailClient = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","test@gmail.com", null));
        mailClient.putExtra(Intent.EXTRA_SUBJECT, "Serial Number");
        mailClient.putExtra(Intent.EXTRA_TEXT, deviceId);
        startActivity(mailClient);
    }
}
