package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RateComment extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_comment);
        setTitle("Rating dan Komentar");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_rate_comment, menu);
        return true;
    }

    
}
