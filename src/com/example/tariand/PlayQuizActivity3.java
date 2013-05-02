package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayQuizActivity3 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_quiz_activity3);        
        
        TextView tv = (TextView) findViewById(R.id.editText3);
        tv.setTextColor(getResources().getColor(R.color.blue));
        Button b = (Button) findViewById(R.id.StartQuiz3);
        setTitle("Quiz!");
        b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), QuizLevelActivity.class));
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_play_quiz_activity3, menu);
        return true;
    }

    
}
