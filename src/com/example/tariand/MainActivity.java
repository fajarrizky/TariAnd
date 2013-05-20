package com.example.tariand;

import control.TarianManager;
import android.os.Bundle;
import android.provider.Settings;
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
	public static final String target = "http://192.168.91.50/";
	@SuppressWarnings("deprecation")
	String deviceId = Settings.System.getString(getContentResolver(),Settings.System.ANDROID_ID);
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cari = (Button) findViewById(R.id.CariTarianButton);
        Button award = (Button) findViewById(R.id.LihatAwardButton);
        Button bookmark = (Button) findViewById(R.id.LihatBookmarkButton);
        Button play = (Button) findViewById(R.id.MainkanQuizButton);
        Button contribute = (Button) findViewById(R.id.UserContribution);
        
        shpr = getSharedPreferences("TariAnd", MODE_PRIVATE );
        shedtr = shpr.edit();
        setTitle("TariAnd");
        tariManager = new TarianManager();
		//tariManager.testCode();
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
		contribute.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), UserContribution.class));
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
   
    
    
    
}
