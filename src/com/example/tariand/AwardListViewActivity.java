package com.example.tariand;

import helper.ListViewAdapter;

import java.util.ArrayList;

import model.Award;

import control.AwardManager;
import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AwardListViewActivity extends Activity {

	AwardManager awardManage;
	ArrayList<Award> listAward;
	ArrayList<String> namaAward;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.tariand.R.layout.activity_award_list_view);
        awardManage = new AwardManager();
        awardManage.createAward();
        listAward = awardManage.getListAward();
        namaAward = new ArrayList<String>();
        
        
        
        for (Award aw : listAward) {
			if (aw.isAchieved()){
				aw.setName(aw.getName() + " (Sudah Dicapai)");
			}
			else{
				aw.setName(aw.getName() + " (Belum Dicapai)");
			}
			namaAward.add(aw.getName());
		}
        
        ListView awardListView = (ListView) findViewById(com.example.tariand.R.id.awardListView);
        
        awardListView.setBackgroundColor(getResources().getColor(R.color.black));
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, namaAward);
        awardListView.setAdapter(adapt);
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.example.tariand.R.menu.activity_award_list_view, menu);
        return true;
    }
}
