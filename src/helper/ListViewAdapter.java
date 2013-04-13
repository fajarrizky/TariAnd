package helper;

import model.Tarian;


import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tariand.*;

public class ListViewAdapter extends BaseAdapter {

	private Tarian[] tarianArray;
	private LayoutInflater mInflater;
	
	public void setVisibleFalse(ImageButton i){
		i.setVisibility(View.GONE);
	}
	
	public void setVisibleTrue(ImageButton i){
		i.setVisibility(View.VISIBLE);
	}

	public ListViewAdapter(Context context, Tarian[] results) {
		tarianArray = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return tarianArray.length;
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return tarianArray[arg0];
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int thisposition = position;
		if (convertView == null) {
			convertView = mInflater.inflate(com.example.tariand.R.layout.list_view, null);
			TextView tv = (TextView) convertView.findViewById(com.example.tariand.R.id.namaTarian);
			ImageButton bukmark = (ImageButton) convertView.findViewById(com.example.tariand.R.id.bookmark);
			ImageButton anbukmark = (ImageButton) convertView.findViewById(com.example.tariand.R.id.noBookmark);
			tv.setText(tarianArray[position].getName());
			
			if (tarianArray[position].isBookmarked()){
				bukmark.setVisibility(1);
				bukmark.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						tarianArray[thisposition].setBookmark(false);
						v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.GONE);
						
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.VISIBLE);
					}
				});
			}
			else {
				anbukmark.setVisibility(1);
				anbukmark.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.GONE);
						tarianArray[thisposition].setBookmark(true);
						v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.VISIBLE);
						
					}
				});
				
			}
		}

		return convertView;
	}

}
