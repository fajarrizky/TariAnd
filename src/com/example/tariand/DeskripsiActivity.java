package com.example.tariand;

import java.util.ArrayList;

import model.Tarian;

import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class DeskripsiActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deskripsi);

		/*
		tmng = MainActivity.tariManager;
		String tarianku = getIntent().getStringExtra("namatarian");
		tarianList = tmng.getListTarian();

		for (Tarian tari : tarianList) {
			if (tari.getName().equalsIgnoreCase(tarianku)){
				TextView tv = (TextView) findViewById(R.id.deskripsiTarian);
				tv.setText(tari.getDescription());
			}
		}
		*/
		Tarian asd =(Tarian) getIntent().getSerializableExtra("tariannya");
        setTitle("Deskripsi "+asd.getName());
		TextView tv = (TextView) findViewById(R.id.deskripsiTarian);
		tv.setText(asd.getDescription());
		tv.setMovementMethod(new ScrollingMovementMethod());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_deskripsi, menu);
		return true;
	}
}
