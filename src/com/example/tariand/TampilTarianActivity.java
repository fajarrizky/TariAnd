package com.example.tariand;


import java.util.ArrayList;

import model.Tarian;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TampilTarianActivity extends Activity {
	Tarian bcc = null;
	Intent intent = null;
	Activity ffvd = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tampil_tarian);
		ffvd = this;

		ArrayList<String> taritari = new ArrayList<String>();
		taritari.add("Deskripsi");
		taritari.add("Gambar");
		taritari.add("video");
		Log.d("masuk", "hai hai lo lagi di TampilTarian cyn");
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, taritari);

		bcc = (Tarian) getIntent().getSerializableExtra("tariannya");
		if(bcc != null){
			Log.d(""+bcc.getId()+" , "+bcc.getName(), ""+bcc.getVideoURL());
	        setTitle(bcc.getName());
		}
		ListView tarian = (ListView) findViewById(R.id.detarian);
		tarian.setBackgroundColor(getResources().getColor(R.color.blue));

		tarian.setOnItemClickListener(new OnItemClickListener() {

			String namatarian = getIntent().getStringExtra("tarian");

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Deskripsi") && namatarian!=null){


					intent = new Intent(getApplicationContext(), DeskripsiActivity.class);
					//intent.putExtra("namatarian", namatarian);
					intent.putExtra("tariannya", bcc);
					startActivity(intent);
				}

				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Gambar") && namatarian!=null){


					intent = new Intent(getApplicationContext(), GambarActivity.class);
					//intent.putExtra("namatarian", namatarian);
					intent.putExtra("tariannya", bcc);
					startActivity(intent);
				}

				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Video") && namatarian!=null){

					Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
					//intent.putExtra("namatarian", namatarian);
					intent.putExtra("tariannya", bcc);
					startActivity(intent);
				}
				
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Share") && namatarian!=null){

					//Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
					//intent.putExtra("namatarian", namatarian);
					//intent.putExtra("tariannya", bcc);
					//startActivity(intent);
					
					Intent share = new Intent(android.content.Intent.ACTION_SEND);
					share.setType("text/plain");
					share.putExtra(Intent.EXTRA_SUBJECT, "Name of the thing to share");
					share.putExtra(Intent.EXTRA_TEXT, bcc.getDescription());
					startActivity(Intent.createChooser(share, "Title of the dialog that will show up"));
				}
				
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Rating dan Komentar") && namatarian!=null){

					Intent intent = new Intent(getApplicationContext(), RateComment.class);
					//intent.putExtra("namatarian", namatarian);
					intent.putExtra("tariannya", bcc);
					startActivity(intent);
				}
			}
			
		});
		tarian.setAdapter(adapt);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_tampil_tarian, menu);
		return true;
	}
}
