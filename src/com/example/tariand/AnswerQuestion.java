package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AnswerQuestion extends Activity {
	boolean answer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        
        answer = getIntent().getBooleanExtra("answer", false);
        
        TextView result = (TextView) findViewById(R.id.Hasil);
        if(answer){
        	result.setText("Selamat! Anda menjawab pertanyaan dengan benar!");
        } else {
        	result.setText("Jawaban Anda masih salah! Coba lagi.");
        }
        
        Button cont = (Button) findViewById(R.id.Kontinyu);
        cont.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), QuizLevelActivity.class));
			}
		});
        
        Button end = (Button) findViewById(R.id.Selesai);
        end.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_answer_question, menu);
        return true;
    }

    
}
