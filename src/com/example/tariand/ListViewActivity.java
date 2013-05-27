package com.example.tariand;

import java.util.ArrayList;
import java.util.Collections;

import control.TarianManager;
import control.V;
import helper.ListViewAdapter;
import model.Award;
import model.Tarian;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListViewActivity extends Activity {

	Bundle bun;
	ArrayList<Tarian> arrayTari;
	TarianManager tariManager;
	String provinsi;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		setTitle("Daftar Tarian");
		
		bun = new Bundle();
		tariManager = V.tariManager;
		arrayTari = new ArrayList<Tarian>();
		
		if ((bun = this.getIntent().getBundleExtra("namatarian")) != null) {
			String nama = bun.getString("tarianName");
			arrayTari = tariManager.searchByName(nama);
			Log.d("size array", arrayTari.size() + " " + nama
					+ " dari search nama");
			Collections.sort(arrayTari);
		}
		if (this.getIntent().getBooleanExtra("bookmark", false)) {
			arrayTari = tariManager.getBookmarkedTarian();
			setTitle("Bookmark");
			Collections.sort(arrayTari);
			
		}
		if ((provinsi = this.getIntent().getStringExtra("Provinsi")) != null) {
			Log.d("Nama Tarian", "Nama Provinsi " + provinsi);
			arrayTari = tariManager.searchByLocation(provinsi);
			Log.d("size array", arrayTari.size() + " dari search lokasi");
			setTitle("Provinsi "+provinsi);
			Collections.sort(arrayTari);
			
		}

//		Award x = V.awrdMngr.getAward(6);
//		if(V.shpr.getInt("BOOKMARKING", 0)>= 5 && !x.isAchieved()){
//			x.setAsAchieved();
//			new AlertDialog.Builder(getApplicationContext()).setTitle("Selamat!").setMessage("Anda mendapatkan Award : "+x.getName()).setNeutralButton("Close", null).show();
//		}
		ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(),
				arrayTari);
		// adapter.notifyDataSetChanged();
		ListView listview = (ListView) findViewById(R.id.TarianListView);

		
		
		listview.setAdapter(adapter);
		listview.setClickable(true);
		listview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.d("tampil", "hai hai aku kepangggil");
				Intent i = new Intent(arg0.getContext(), TampilTarianActivity.class);
				i.putExtra("tarian", arg0.getItemAtPosition(arg2).toString());
				startActivity(i);
			}
		});

	}
}
