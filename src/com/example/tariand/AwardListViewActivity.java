package com.example.tariand;

import java.util.ArrayList;

import model.Award;

import control.AwardManager;
import control.V;
import android.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AwardListViewActivity extends Activity {

	AwardManager awardManage;
	ArrayList<Award> listAward;
	ArrayList<String> namaAward;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.tariand.R.layout.activity_award_list_view);
        awardManage = V.awrdMngr;
        listAward = awardManage.getListAward();
        namaAward = new ArrayList<String>();
        setTitle("Award");
        
        
        for (Award aw : listAward) {
			if (aw.isAchieved()){
				namaAward.add(aw.getName() + " (Sudah Didapatkan) ");
			}
			else{
				namaAward.add(aw.getName() + " (Belum Didapatkan) ");
			}
		}
        
        ListView awardListView = (ListView) findViewById(com.example.tariand.R.id.awardListView);
        awardListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				int position = arg2;
				Award award = listAward.get(position);
				if(listAward.get(position).isAchieved()){
					Intent sendIntent = new Intent();
					sendIntent.setAction(Intent.ACTION_SEND);
					sendIntent.putExtra(Intent.EXTRA_TEXT, award.getName()+" : "+award.getLink());
					sendIntent.setType("text/plain");
					startActivity(Intent.createChooser(sendIntent, "Share With"));
				}
			}
        	
        });
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
