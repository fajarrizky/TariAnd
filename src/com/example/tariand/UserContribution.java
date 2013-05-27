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
				String name = namaTarian.getText().toString();
				String location = provinsi.getText().toString();
				String link = linkSumber.getText().toString();
				String imageUrl = urlgambar.getText().toString();
				String videoUrl = urlvideo.getText().toString();
				String description = deskripsi.getText().toString();
				
				if(name==null || name.equals("")){
					Toast.makeText(getApplicationContext(), "Nama Tarian tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(location==null || location.equals("")){
					Toast.makeText(getApplicationContext(), "Provinsi tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(link==null || link.equals("")){
					Toast.makeText(getApplicationContext(), "Link Sumber tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(imageUrl==null || imageUrl.equals("")){
					Toast.makeText(getApplicationContext(), "Url Gambar tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(videoUrl==null || videoUrl.equals("")){
					Toast.makeText(getApplicationContext(), "Url Video tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(!cekFromYoutube(videoUrl)){
					Toast.makeText(getApplicationContext(), "Video harus dari YouTube", Toast.LENGTH_SHORT).show();
				} else if(description==null || description.equals("")){
					Toast.makeText(getApplicationContext(), "Deskripsi tidak boleh kosong", Toast.LENGTH_SHORT).show();
				}
				else {	

					Tarian a = new Tarian();
					a.setName(name);
					a.setLocation(location);
					a.setLink(link);
					a.setImageURL(imageUrl);
					a.setVideoURL(videoUrl);
					a.setDescription(description);
					//
					V.tariManager.addTarian(a);
					ucmgr = new UserContributionManager(a);
					ucmgr.post();
					Award x = V.awrdMngr.getAward(3);
					if(!x.isAchieved()){
						V.awrdMngr.getAward(3).setAsAchieved();						
					}
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
				linkSumber.setText("");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_user_contribution, menu);
		return true;
	}

	public boolean cekFromYoutube(String video){
		return video.contains("youtube.com");
	}

}
