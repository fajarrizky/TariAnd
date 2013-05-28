package com.example.tariand;

import java.util.ArrayList;

import control.UserContributionManager;
import control.V;
import model.Award;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserContribution extends Activity {
	EditText namaTarian, provinsi, linkSumber, urlvideo, urlgambar, deskripsi;
	Spinner dropDownProvinsi;
	Button submit, reset;
	UserContributionManager ucmgr;
	String prv = null;
	ArrayList<String> prvs ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_contribution);
		setTitle("Kontribusi Pengguna");
		namaTarian = (EditText) findViewById(R.id.namaTarianUC);
		urlvideo = (EditText) findViewById(R.id.urlvideo);
		urlgambar = (EditText) findViewById(R.id.urlgambar);
		deskripsi = (EditText) findViewById(R.id.deskripsi);
		linkSumber = (EditText) findViewById(R.id.link);
		dropDownProvinsi = (Spinner) findViewById(R.id.dropDownProvinsi);
		//V.awrdMngr.getAward(3).setAchieved(false);
		submit = (Button) findViewById(R.id.submit);
		reset = (Button) findViewById(R.id.reset);
		prvs = listProvinsi();
		ArrayAdapter<String> spinnerAd = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, prvs);
		dropDownProvinsi.setAdapter(spinnerAd);
		dropDownProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                prv = prvs.get(position);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            	dropDownProvinsi.setSelection(0);
            }
        });
		
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		submit.setOnClickListener(new View.OnClickListener(
				) {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = namaTarian.getText().toString();
				//dropDownProvinsi.
				//String location = provinsi.getText().toString();
				String link = linkSumber.getText().toString();
				String imageUrl = urlgambar.getText().toString();
				String videoUrl = urlvideo.getText().toString();
				String description = deskripsi.getText().toString();
				
				if(name==null || name.equals("")){
					Toast.makeText(getApplicationContext(), "Nama Tarian tidak boleh kosong", Toast.LENGTH_SHORT).show();
				} else if(prv==null || prv.equals("")){
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
					a.setLocation(prv);
					a.setLink(link);
					a.setImageURL(imageUrl);
					a.setVideoURL(videoUrl);
					a.setDescription(description);
					Log.e("provinsi", prv);
					//
					V.tariManager.addTarian(a);
					ucmgr = new UserContributionManager(a);
					//ucmgr.post();
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
	
	public ArrayList<String> listProvinsi(){
		ArrayList<String> provinsi = new ArrayList<String>();
		provinsi.add("D.I Aceh");
		provinsi.add("Sumatera Utara");
		provinsi.add("Sumatera Barat");
		provinsi.add("Sumatera Selatan");
		provinsi.add("Jambi");
		provinsi.add("Riau");
		provinsi.add("Kepulauan Riau");
		provinsi.add("Bangka-Belitung");
		provinsi.add("Bengkulu");
		provinsi.add("Lampung");
		provinsi.add("Banten");
		provinsi.add("Jakarta");
		provinsi.add("Jawa Barat");
		provinsi.add("Jawa Tengah");
		provinsi.add("Jawa Timur");
		provinsi.add("Yogyakarta");
		provinsi.add("Bali");
		provinsi.add("Nusa Tenggara Barat");
		provinsi.add("Nusa Tenggara Timur");
		provinsi.add("Maluku");
		provinsi.add("Kalimantan Barat");
		provinsi.add("Kalimantan Timur");
		provinsi.add("Kalimantan Tengah");
		provinsi.add("Kalimantan Selatan");
		provinsi.add("Kalimantan Utara");
		provinsi.add("Sulawesi Barat");
		provinsi.add("Sulawesi Tengah");
		provinsi.add("Sulawesi Selatan");
		provinsi.add("Sulawesi Tenggara");
		provinsi.add("Sulawesi Utara");
		provinsi.add("Gorontalo");
		provinsi.add("Maluku Utara");
		provinsi.add("Papua Barat");
		provinsi.add("Papua");
		
		return provinsi;
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
