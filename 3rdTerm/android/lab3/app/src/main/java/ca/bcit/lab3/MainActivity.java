package ca.bcit.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onConstraintClick(View v) {
        Intent i = new Intent(this, ConstraintActivity.class);
        startActivity(i);
    }

    protected void onLinearClick(View view) {
        Intent intent = new Intent(this, LinearActivity.class);
        startActivity(intent);
    }

    protected void onRelativeClick(View view) {
        Intent intent = new Intent(this, RelativeActivity.class);
        startActivity(intent);
    }

    protected void onGridClick(View view) {
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }

    protected void onTableClick(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }
}
