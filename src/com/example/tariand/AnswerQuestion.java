package com.example.tariand;

import model.Award;
import control.V;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerQuestion extends Activity {
	
	int score;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_question);
        
        score = getIntent().getIntExtra("score", 0);
        TextView result = (TextView) findViewById(R.id.Hasil);
        result.setText("Anda telah selesai menjawab 10 pertanyaan. \nScore Anda adalah "+score);
        Award x = V.awrdMngr.getAward(0);
        if(score == 100 && !x.isAchieved()){
        	x.setAsAchieved();
        	Toast.makeText(getApplicationContext(), "Selamat! Anda mendapat Award: "+x.getName(), Toast.LENGTH_SHORT).show();
        }
        
        Button cont = (Button) findViewById(R.id.Kontinyu);
        setTitle("Hasil Quiz");
        cont.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), QuizLevelActivity.class));
				finish();
			}
		});
        
        Button end = (Button) findViewById(R.id.Selesai);
        end.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_answer_question, menu);
        return true;
    }

    
}
