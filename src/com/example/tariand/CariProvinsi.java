package com.example.tariand;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CariProvinsi extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_cari_provinsi, container, false);
		TouchImageView map = (TouchImageView) FragView.findViewById(R.id.imap);
		map.setImageResource(R.drawable.imap);
		map.setMaxZoom(4f);
		
		return FragView;
	}
}
