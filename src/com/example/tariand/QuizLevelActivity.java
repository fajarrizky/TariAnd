package com.example.tariand;

import model.Question;
import control.QuestionManager;
import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizLevelActivity extends Activity {

	int levelQuiz, score;
	Bundle bun;
	QuestionManager qmj = new QuestionManager();
	Question q1;
	boolean answer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);
     
        q1 = qmj.getOne();
        TextView tv = (TextView) findViewById(R.id.isi);
        tv.setText(q1.getQuestion());
        
        Button trueButton = (Button) findViewById(R.id.True);
        Button falseButton = (Button) findViewById(R.id.False);
        trueButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				answer = q1.isCorrectAnswer();
				pindah();
			}
		});
        
        falseButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				answer = !q1.isCorrectAnswer();
				pindah();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz_level, menu);
        return true;
    }
    
    private void pindah(){
    	Intent i = new Intent(getApplicationContext(), AnswerQuestion.class);
    	i.putExtra("answer", answer);
    	startActivity(i);
    }
}
