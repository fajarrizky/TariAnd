package com.example.tariand;

import java.util.ArrayList;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_tarian);
        
        ArrayList<String> taritari = new ArrayList<String>();
        taritari.add("Deskripsi");
        taritari.add("Gambar");
        taritari.add("video");
        Log.d("masuk", "hai hai lo lagi di TampilTarian cyn");
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, taritari);
        
        ListView tarian = (ListView) findViewById(R.id.detarian);
        
        
        tarian.setOnItemClickListener(new OnItemClickListener() {

        	String namatarian = getIntent().getStringExtra("tarian");
        	
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Deskripsi") && namatarian!=null){
					
					
					Intent i = new Intent(getApplicationContext(), DeskripsiActivity.class);
					i.putExtra("namatarian", namatarian);
					
					startActivity(i);
				}
				
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Gambar") && namatarian!=null){
					
					
					Intent i = new Intent(getApplicationContext(), GambarActivity.class);
					i.putExtra("namatarian", namatarian);
					startActivity(i);
				}
				
				if (arg0.getItemAtPosition(arg2).toString().equalsIgnoreCase("Video") && namatarian!=null){
					
					
					Intent i = new Intent(getApplicationContext(), DeskripsiActivity.class);
					i.putExtra("namatarian", namatarian);
					startActivity(i);
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
