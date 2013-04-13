package com.example.tariand;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_cari_nama, container, false);
		ImageButton b = (ImageButton) FragView.findViewById(R.id.searchButton);
		textview = (TextView) FragView.findViewById(R.id.SearchField);
		namaTarian = textview.getText().toString();
		b.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "halo", 3).show();
				Intent i = new Intent(getActivity(), ListViewActivity.class);
				i.putExtra("searchByName", true);
				
				i.putExtra("tarianName", namaTarian);
				startActivity(i);
			}
		});
		return FragView;
		
	}
	
	
}

	