package com.example.tariand;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;

public class CariTarianActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab nama = actionBar.newTab();
		nama.setText("Berdasarkan Nama");
		nama.setTabListener(new TabListener<CariNama>(this, "Nama",
				CariNama.class));
		actionBar.addTab(nama);

		Tab prov = actionBar.newTab();
		prov.setText("Berdasarkan Provinsi");
		prov.setTabListener(new TabListener<CariProvinsi>(this,
				"Berdasarkan Provinsi", CariProvinsi.class));
		actionBar.addTab(prov);

		if (savedInstanceState != null) {
			int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
			getActionBar().setSelectedNavigationItem(savedIndex);
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("SAVED_INDEX", getActionBar().getSelectedNavigationIndex());
	}

	public static class TabListener<T> implements ActionBar.TabListener {

		private final Activity myActivity;
		private final String myTag;
		private final Class<T> myClass;

		public TabListener(Activity activity, String tag, Class<T> cls) {
			myActivity = activity;
			myTag = tag;
			myClass = cls;
		}
		
		@Override
		public void onTabUnselected(ActionBar.Tab tab,
				FragmentTransaction fragmentTransaction) {
			android.app.Fragment myFragment = myActivity.getFragmentManager()
					.findFragmentByTag(myTag);

			if (myFragment != null) {
				// Detach the fragment, because another one is being attached
				fragmentTransaction.detach(myFragment);
			}
		}
		
		@Override
		public void onTabSelected(ActionBar.Tab tab,
				FragmentTransaction ft) {
			Object myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);
			   
			   // Check if the fragment is already initialized
			         if (myFragment == null) {
			             // If not, instantiate and add it to the activity
			             myFragment = Fragment.instantiate(myActivity, myClass.getName());
			             ft.add(android.R.id.content, (android.app.Fragment) myFragment, myTag);
			         } else {
			             // If it exists, simply attach it in order to show it
			             ft.attach((android.app.Fragment) myFragment);
			         }
		}

		public void onTabReselected(ActionBar.Tab tab,
				FragmentTransaction fragmentTransaction) {
		}
	}
}
