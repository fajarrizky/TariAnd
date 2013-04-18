package com.example.tariand;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GambarActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gambar, menu);
        return true;
    }
}
