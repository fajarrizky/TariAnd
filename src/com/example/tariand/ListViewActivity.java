package com.example.tariand;

import java.util.ArrayList;

import control.TarianManager;

import helper.ListViewAdapter;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

	Bundle bun;
	ArrayList<Tarian> arrayTari;
	TarianManager tariManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        
        tariManager = new TarianManager();
        tariManager.retrieve();
    
        if((bun = this.getIntent().getBundleExtra("namatarian"))!=null){
        	String nama = bun.getString("tarianName");
         	arrayTari = tariManager.searchByName(nama);
        	
			}
        
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), arrayTari);
        
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);
    
        
        }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_view, menu);
        return true;
    }
}
