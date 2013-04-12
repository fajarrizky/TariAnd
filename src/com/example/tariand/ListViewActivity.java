package com.example.tariand;

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
        
        String[] stringArray = new String[10];
        
        for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "tarian" +i;
		}
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, stringArray);
        
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(adapter);
        return true;
    }
}
