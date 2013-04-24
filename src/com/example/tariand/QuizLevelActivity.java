package com.example.tariand;

import java.util.ArrayList;

import model.Question;
import control.QuestionManager;
import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizLevelActivity extends Activity {

	int score;
	Bundle bun;
	QuestionManager qmj = new QuestionManager();
	Question q1;
	boolean answer;
	private ArrayList<Question> q2;
	TextView tv;
	TextView qnumb;
	private int jj;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);
        
        score = 0;
        jj = 0;
        q2 = qmj.getForQuiz();
        q1 = q2.get(jj);        
        tv = (TextView) findViewById(R.id.isi);
        tv.setText("	"+q1.getQuestion());
        
        qnumb = (TextView) findViewById(R.id.qNumber);
        //////
        qnumb.setText("Pertanyaan ke "+(jj+1));
        qnumb.setVisibility(View.GONE);
        //////
        Button trueButton = (Button) findViewById(R.id.True);
        Button falseButton = (Button) findViewById(R.id.False);
        trueButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				answer = q1.isCorrectAnswer();
				click(answer);
				//pindah();
			}
		});
        
        falseButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				answer = !q1.isCorrectAnswer();
				click(answer);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz_level, menu);
        return true;
    }
    
    public void click(boolean answer){
    	if(answer){
    		score += 10;
    	}
    	if(jj==q2.size()-1){
    		pindah();
    	} else {
    		jj++;
    		q1 = q2.get(jj);
    		tv.setText("	"+q1.getQuestion());
    		qnumb.setText("Pertanyaan ke "+(jj+1));
    		setTitle("Pertanyaan ke "+(jj+1));
    	}
    }
    private void pindah(){
    	Log.d("score ", ""+score);
    	Intent i = new Intent(getApplicationContext(), AnswerQuestion.class);
    	i.putExtra("score", score);
    	startActivity(i);
    }
}
