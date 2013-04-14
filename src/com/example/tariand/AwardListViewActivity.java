package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AwardListViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_list_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_award_list_view, menu);
        return true;
    }
}
