package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PlayQuizActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_quiz);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_play_quiz, menu);
        return true;
    }
}
