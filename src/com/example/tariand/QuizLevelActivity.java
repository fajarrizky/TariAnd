package com.example.tariand;

import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class QuizLevelActivity extends Activity {

	int levelQuiz, score;
	Bundle bun;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz_level, menu);
        return true;
    }
}
