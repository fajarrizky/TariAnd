package com.example.tariand;

import control.TarianManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	public static TarianManager tariManager;
	public static SharedPreferences shpr;
	public static SharedPreferences.Editor shedtr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cari = (Button) findViewById(R.id.CariTarianButton);
        Button award = (Button) findViewById(R.id.LihatAwardButton);
        Button bookmark = (Button) findViewById(R.id.LihatBookmarkButton);
        Button play = (Button) findViewById(R.id.MainkanQuizButton);
        
        shpr = getSharedPreferences("TariAnd", MODE_PRIVATE );
        shedtr = shpr.edit();
        
        tariManager = new TarianManager();
		tariManager.testCode();
		tariManager.retrieve();
		
        cari.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), CariTarianActivity.class));
			}
		});
        
        award.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), AwardListViewActivity.class));
			}
		});
        
        bookmark.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
				i.putExtra("bookmark", true);
				startActivity(i);
				}
			});

		play.setOnClickListener(new View.OnClickListener() {
	
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getApplicationContext(), PlayQuizActivity3.class));
					}
			});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
