package com.example.tariand;

import java.util.ArrayList;
import control.TarianManager;
import helper.ListViewAdapter;
import model.Tarian;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

		bun = new Bundle();
		tariManager = new TarianManager();
		tariManager.testCode();
		arrayTari = new ArrayList<Tarian>();
		tariManager.retrieve();

		if ((bun = this.getIntent().getBundleExtra("namatarian")) != null) {
			String nama = bun.getString("tarianName");
			arrayTari = tariManager.searchByName(nama);
			Log.d("size array", arrayTari.size() + " " + nama
					+ " dari search nama");
		}
		if (this.getIntent().getBooleanExtra("bookmark", false)) {
			arrayTari = tariManager.getBookmarkedTarian();
		}
		if ((provinsi = this.getIntent().getStringExtra("Provinsi")) != null) {
			Log.d("Nama Tarian", "Nama Provinsi " + provinsi);
			arrayTari = tariManager.searchByLocation(provinsi);
			Log.d("size array", arrayTari.size() + " dari search lokasi");
		}

		final ListViewAdapter adapter = new ListViewAdapter(
				getApplicationContext(), arrayTari);
		// adapter.notifyDataSetChanged();
		ListView listview = (ListView) findViewById(R.id.TarianListView);
		listview.setAdapter(adapter);
		this.runOnUiThread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				adapter.notifyDataSetChanged();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list_view, menu);
		return true;
	}

}
