package com.example.tariand;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;

public class ShowTarianActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_show_tarian);

		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab deskripsi = actionBar.newTab();
		deskripsi.setText("Deskripsi");
		deskripsi.setTabListener(new TabListener<ShowTarianActivity>(this,
				"Deskripsi", ShowTarianActivity.class));
		actionBar.addTab(deskripsi);

		Tab video = actionBar.newTab();
		video.setText("Video");
		video.setTabListener(new TabListener<ShowVideoActivity>(this, "Video",
				ShowVideoActivity.class));
		actionBar.addTab(video);

		Tab gambar = actionBar.newTab();
		gambar.setText("Gambar");
		gambar.setTabListener(new TabListener<ShowGambarActivity>(this,
				"Gambar", ShowGambarActivity.class));
		actionBar.addTab(gambar);

		if (savedInstanceState != null) {
			int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
			getActionBar().setSelectedNavigationItem(savedIndex);
		}

	}

	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("SAVED_INDEX", getActionBar()
				.getSelectedNavigationIndex());
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

		public void onTabUnselected(ActionBar.Tab tab,
				FragmentTransaction fragmentTransaction) {
			android.app.Fragment myFragment = myActivity.getFragmentManager()
					.findFragmentByTag(myTag);

			if (myFragment != null) {
				// Detach the fragment, because another one is being attached
				fragmentTransaction.detach(myFragment);
			}
		}

		public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
			Object myFragment = myActivity.getFragmentManager()
					.findFragmentByTag(myTag);

			// Check if the fragment is already initialized
			if (myFragment == null) {
				// If not, instantiate and add it to the activity
				myFragment = Fragment
						.instantiate(myActivity, myClass.getName());
				ft.add(android.R.id.content, (android.app.Fragment) myFragment,
						myTag);
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
