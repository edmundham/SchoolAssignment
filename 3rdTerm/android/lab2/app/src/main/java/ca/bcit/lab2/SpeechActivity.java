package ca.bcit.lab2;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class SpeechActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
    }

    public void onClickFinish(View view) {
        tts.shutdown();
        finish();
    }

    private void speakHello(final CharSequence speakString) {
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.CANADA);
                }
            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                tts.speak(speakString, TextToSpeech.QUEUE_FLUSH, null, null);
                timer.cancel();
            }
        }, 100);

    }

    public void onClickSpeakButton(View view) {
        EditText edit = (EditText)findViewById(R.id.editText);
        CharSequence speakString = edit.getText().toString();
        this.speakHello(speakString);
    }

}
