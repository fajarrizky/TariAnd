package com.example.tariand;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CariProvinsi extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_cari_provinsi, container, false);
		
		ArrayList<String> provinsi = new ArrayList<String>();
		provinsi.add("Aceh");
		provinsi.add("Sumut");
		provinsi.add("Sumbar");
		provinsi.add("Sumsel");
		provinsi.add("Jambi");
		provinsi.add("Riau");
		provinsi.add("Kepulauan Riau");
		provinsi.add("Bangka-Belitung");
		provinsi.add("Bengkulu");
		provinsi.add("Lampung");
		provinsi.add("Banten");
		provinsi.add("Jakarta");
		provinsi.add("Jawa Barat");
		provinsi.add("Jawa Tengah");
		provinsi.add("Jawa Timur");
		provinsi.add("Yogyakarta");
		provinsi.add("Bali");
		provinsi.add("Nusa Tenggara Barat");
		provinsi.add("Nusa Tenggara Timur");
		provinsi.add("Maluku");
		provinsi.add("Kalimantan Barat");
		provinsi.add("Kalimantan Timur");
		provinsi.add("Kalimantan Tengah");
		provinsi.add("Kalimantan Selatan");
		provinsi.add("Kalimantan Utara");
		provinsi.add("Sulawesi Barat");
		provinsi.add("Sulawesi Tengah");
		provinsi.add("Sulawesi Selatan");
		provinsi.add("Sulawesi Tenggara");
		provinsi.add("Sulawesi Utara");
		provinsi.add("Gorontalo");
		provinsi.add("Maluku Utara");
		provinsi.add("Papua Barat");
		provinsi.add("Papua");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, provinsi);
		
		
		ListView lv = (ListView) FragView.findViewById(R.id.listViewProvinsi);
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(), ListViewActivity.class);
				i.putExtra("Provinsi", (String)arg0.getItemAtPosition(arg2));
				startActivity(i);
			}
		});
		lv.setAdapter(adapter);
		
		return FragView;
	}
}
