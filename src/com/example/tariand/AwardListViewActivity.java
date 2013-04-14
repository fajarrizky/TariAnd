package com.example.tariand;

import control.AwardManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class AwardListViewActivity extends Activity {

	AwardManager award;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_list_view);
        
        ListView award = (ListView) findViewById(R.id.awardListView);
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_award_list_view, menu);
        return true;
    }
}
