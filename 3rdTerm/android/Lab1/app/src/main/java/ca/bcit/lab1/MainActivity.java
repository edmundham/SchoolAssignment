package ca.bcit.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import ca.bcit.lab1.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickReverse(final View view) {
        TextView tv = findViewById(R.id.editText);
        String userInput = tv.getText().toString();

        TextView reversedTextView = findViewById(R.id.reversedText);
        reversedTextView.setText(Utils.reverseString(userInput));
    }
}
