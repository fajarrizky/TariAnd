package com.example.tariand;

import java.util.ArrayList;

import model.Tarian;

import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DeskripsiActivity extends Activity {

	TarianManager tmng;
	ArrayList<Tarian> tarianList;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);
        
        String tarianku = getIntent().getStringExtra("namatarian");
        tarianList = tmng.getListTarian();
        
        for (Tarian tari : tarianList) {
			if (tari.getName().equalsIgnoreCase(tarianku)){
				TextView tv = (TextView) findViewById(R.id.deskripsiTarian);
				tv.setText(tari.getDescription());
			}
		}
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_deskripsi, menu);
        return true;
    }
}
