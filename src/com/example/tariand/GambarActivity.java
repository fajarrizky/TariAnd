package com.example.tariand;

import java.util.ArrayList;

import model.Tarian;

import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class GambarActivity extends Activity {

	TarianManager tmng;
	ArrayList<Tarian> tariArray;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        
        tmng = new TarianManager();
        tmng.testCode();
        
        String tarianku = getIntent().getStringExtra("namatarian");
        
        tariArray = tmng.getListTarian();
        
        for (Tarian tari : tariArray) {
        	if (tari.getName().equalsIgnoreCase(tarianku)){
				ImageView img = (ImageView) findViewById(R.id.Img1);
				img.setImageResource(Integer.parseInt(tari.getImageURL()));			
			}
		}
        
       // ImageView asd = (ImageView) findViewById(R.id.Img1);
        //asd.setImageResource(R.drawable.gambyong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gambar, menu);
        return true;
    }
}
