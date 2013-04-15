package com.example.tariand;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Fragment;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CariNama extends Fragment {

	public String namaTarian;
	public TextView textview;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_cari_nama, container, false);
		ImageButton b = (ImageButton) FragView.findViewById(R.id.searchButton);
		textview = (TextView) FragView.findViewById(R.id.SearchField);
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				namaTarian = textview.getText().toString();
				Intent i = new Intent(getActivity(), ListViewActivity.class);
				Bundle b = new Bundle();
				b.putBoolean("searchByName", true);
				Log.d("size array",namaTarian + "thisthis");
				b.putString("tarianName", namaTarian);
				i.putExtra("namatarian", b);
				startActivity(i);
			}
		});
		return FragView;
		
	}
	
	
}

	
