package com.example.tariand;

import java.util.ArrayList;
import control.TarianManager;
import helper.ListViewAdapter;
import model.Tarian;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
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
		tariManager = MainActivity.tariManager;
		arrayTari = new ArrayList<Tarian>();
		
		if ((bun = this.getIntent().getBundleExtra("namatarian")) != null) {
			String nama = bun.getString("tarianName");
			arrayTari = tariManager.searchByName(nama);
			Log.d("size array", arrayTari.size() + " " + nama
					+ " dari search nama");
		}
		if (this.getIntent().getBooleanExtra("bookmark", false)) {
			arrayTari = tariManager.getBookmarkedTarian();
			setTitle("Bookmark");
		}
		if ((provinsi = this.getIntent().getStringExtra("Provinsi")) != null) {
			Log.d("Nama Tarian", "Nama Provinsi " + provinsi);
			arrayTari = tariManager.searchByLocation(provinsi);
			Log.d("size array", arrayTari.size() + " dari search lokasi");
			setTitle("Provinsi "+provinsi);
			
		}

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
