package com.example.tariand;

import java.util.List;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import control.V;

import model.Tarian;
import helper.DeveloperKey;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.Menu;

public class VideoActivity extends Activity {
	private static final int REQ_START_STANDALONE_PLAYER = 1;
	private static final int REQ_RESOLVE_SERVICE_MISSING = 2;

	Tarian bcc;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        
        //bcc = (Tarian) getIntent().getSerializableExtra("tariannya");
        bcc = V.current;
        setTitle("Video "+bcc.getName());
        if(bcc != null){
        Intent intent = YouTubeStandalonePlayer.createVideoIntent(
                this, DeveloperKey.YOUTUBE_DEVELOPER_KEY, bcc.getYoutubeVideoHash(), 0, false, true);
        Log.e("kenapa ini e", bcc.getYoutubeVideoHash());
        if (intent != null) {
            if (canResolveIntent(intent)) {
              startActivityForResult(intent, REQ_START_STANDALONE_PLAYER);
            } else {
              // Could not resolve the intent - must need to install or update the YouTube API service.
              YouTubeInitializationResult.SERVICE_MISSING
                  .getErrorDialog(this, REQ_RESOLVE_SERVICE_MISSING).show();
            }
          }
        } else {
        	
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_video, menu);
        return true;
    }
    
    private boolean canResolveIntent(Intent intent) {
        List<ResolveInfo> resolveInfo = getPackageManager().queryIntentActivities(intent, 0);
        return resolveInfo != null && !resolveInfo.isEmpty();
      }

    
}
