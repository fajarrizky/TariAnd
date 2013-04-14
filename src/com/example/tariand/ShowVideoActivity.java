package com.example.tariand;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class ShowVideoActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_show_video, container, false);
		
        
		VideoView vid = (VideoView) FragView.findViewById(R.id.videoView1);
		
		
		return FragView;
    }

   
}
