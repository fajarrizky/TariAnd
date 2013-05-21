package com.example.tariand;

import model.Tarian;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DeskripsiActivity extends Activity {
	RatingBar rBar;
	ListView listComments;
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
		rBar = (RatingBar) findViewById(R.id.ratingTarian);
		
		Tarian asd =(Tarian) getIntent().getSerializableExtra("tariannya");
        setTitle("Deskripsi "+asd.getName());
        rBar.setIsIndicator(true);
        rBar.setRating(asd.getRate());
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
