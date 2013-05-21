package com.example.tariand;

import control.RateAndCommentManager;
import model.Comment;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class RateComment extends Activity {

	RatingBar eRate;
	Button eSubmit;
	EditText userName, eMail, comment;
	Tarian bcc;
	RateAndCommentManager rncm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_comment);
        setTitle("Rating dan Komentar");
        eRate = (RatingBar) findViewById(R.id.eRate);
        eRate.setNumStars(5);
        eSubmit = (Button) findViewById(R.id.submit);
        userName = (EditText) findViewById(R.id.username);
        eMail = (EditText) findViewById(R.id.email);
        comment = (EditText) findViewById(R.id.comment);
        bcc = (Tarian) getIntent().getSerializableExtra("tariannya");
        
        rncm = new RateAndCommentManager();
        eSubmit.setOnClickListener(new View.OnClickListener(
        		) {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				process();
				finish();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_rate_comment, menu);
        return true;
    }

    private void process() {
		// TODO Auto-generated method stub
		Comment cmnt = new Comment(bcc.getId(), userName.getText().toString(), eMail.getText().toString(), comment.getText().toString());

        
        
		float irate = eRate.getRating();
		if(irate != 0){
			cmnt.setRate(irate);
			bcc.addRate(irate);			
		}
		bcc.addComment(cmnt);
		Log.d("nRate", ""+bcc.getNRate());
		Log.d("eRate", ""+bcc.getRate());
		rncm.setComment(cmnt);
		rncm.setERate(bcc.getRate());
		rncm.setNRate(bcc.getNRate());
		rncm.post();
	}
    
}
