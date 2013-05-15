package com.example.tariand;

import control.UserContributionManager;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class UserContribution extends Activity {
	EditText namaTarian, provinsi, urlvideo, urlgambar, deskripsi;
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
        
        submit = (Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);
        
        submit.setOnClickListener(new View.OnClickListener(
        		) {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Tarian a = new Tarian();
				a.setName(namaTarian.getText().toString());
				a.setLocation(provinsi.getText().toString());
				a.setImageURL(urlgambar.getText().toString());
				a.setVideoURL(urlvideo.getText().toString());
				a.setDescription(deskripsi.getText().toString());
				
				ucmgr = new UserContributionManager(a);
				ucmgr.post();
				
				
				finish();
				Toast.makeText(UserContribution.this, "Terima kasih atas partisipasi anda!", Toast.LENGTH_SHORT);
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
