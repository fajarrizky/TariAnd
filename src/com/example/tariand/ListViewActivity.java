package com.example.tariand;

import helper.ListViewAdapter;
import model.Tarian;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_view, menu);
        
        Tarian[] tarianArray = new Tarian[10];
        
        for (int i = 0; i < tarianArray.length; i++) {
			tarianArray[i].setName("tarian" +i);
			tarianArray[i].setBookmark(false);
		}
        
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), tarianArray);
        
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);
        return true;
    }
}
