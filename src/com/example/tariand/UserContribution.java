package com.example.tariand;

import control.UserContributionManager;
import control.V;
import model.Award;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserContribution extends Activity {
	EditText namaTarian, provinsi, linkSumber, urlvideo, urlgambar, deskripsi;
	Button submit, reset;
	UserContributionManager ucmgr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_contribution);
        setTitle("Kontribusi Pengguna");
        namaTarian = (EditText) findViewById(R.id.namaTarianUC);
        provinsi = (EditText) findViewById(R.id.provinsi);
        urlvideo = (EditText) findViewById(R.id.urlvideo);
        urlgambar = (EditText) findViewById(R.id.urlgambar);
        deskripsi = (EditText) findViewById(R.id.deskripsi);
        linkSumber = (EditText) findViewById(R.id.link);
        //V.awrdMngr.getAward(3).setAchieved(false);
        submit = (Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);

		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        submit.setOnClickListener(new View.OnClickListener(
        		) {

        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Tarian a = new Tarian();
        		a.setName(namaTarian.getText().toString());
        		a.setLocation(provinsi.getText().toString());
        		a.setLink(linkSumber.getText().toString());
        		a.setImageURL(urlgambar.getText().toString());
        		a.setVideoURL(urlvideo.getText().toString());
        		a.setDescription(deskripsi.getText().toString());

        		//ucmgr = new UserContributionManager(a);
        		//ucmgr.post();
        		Award x = V.awrdMngr.getAward(3);
        		if(!x.isAchieved()){
        			V.awrdMngr.getAward(3).setAsAchieved();
        			AlertDialog alertDialog = new AlertDialog.Builder(getApplicationContext()).create();
        			alertDialog.setTitle("Selamat!");
        			alertDialog.setMessage("Anda telat mendapatkan Award: "+x.getName());
        			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new OnClickListener() {

        				public void onClick(DialogInterface dialog, int which) {
        					// TODO Auto-generated method stub
        					finish();
        				}
        			});
        			alertDialog.show();
        		} else {
        			finish();
        		}
        	} 
        });
        
        reset.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				namaTarian.setText("");
				provinsi.setText("");
				urlvideo.setText("");
				urlgambar.setText("");
				deskripsi.setText("");
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_user_contribution, menu);
        return true;
    }

    
}
