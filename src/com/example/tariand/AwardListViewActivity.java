package com.example.tariand;

import java.util.ArrayList;

import model.Award;

import helper.ListViewAdapter;
import control.AwardManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AwardListViewActivity extends Activity {

	AwardManager awardManage;
	ArrayList<Award> listAward;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_list_view);
        awardManage = new AwardManager();
        awardManage.createAward();
        listAward = awardManage.getListAward();
        
        ListView awardListView = (ListView) findViewById(R.id.awardListView);
        ArrayAdapter<Award> adapt = new ArrayAdapter<Award>(getApplicationContext(), android.R.layout.simple_list_item_checked, listAward); 
        awardListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        
        for (Award aw : listAward) {
			if (aw.isAchieved())
				awardListView.setSelection(listAward.indexOf(aw));
		}
        
        awardListView.setAdapter(adapt);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_award_list_view, menu);
        return true;
    }
}
