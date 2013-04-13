package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ShowTarianActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tarian);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_show_tarian, menu);
        return true;
    }
}
