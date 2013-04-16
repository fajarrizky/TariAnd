package helper;

import java.util.ArrayList;

import model.Tarian;


import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tariand.*;

public class ListViewAdapter extends BaseAdapter {

	private ArrayList<Tarian> tarianArray;
	private LayoutInflater mInflater;
	
	public void setVisibleFalse(ImageButton i){
		i.setVisibility(View.GONE);
	}
	
	public void setVisibleTrue(ImageButton i){
		i.setVisibility(View.VISIBLE);
	}

	public ListViewAdapter(Context context, ArrayList<Tarian> results) {
		tarianArray = results;
		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return tarianArray.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return tarianArray.get(arg0);
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
			tv.setText(tarianArray.get(position).getName());
			tv.setClickable(true);
			tv.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i = new Intent(arg0.getContext(), ShowTarianActivity.class);
					i.putExtra("tarian", tarianArray.get(thisposition));
					i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					arg0.getContext().startActivity(i);
				}
			});
			
			if (tarianArray.get(thisposition).isBookmarked()){
				bukmark.setVisibility(1);
				anbukmark.setVisibility(View.INVISIBLE);
				bukmark.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						tarianArray.get(thisposition).setBookmark(false);
						//v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.INVISIBLE);
						ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.bookmark);
						book.setImageResource(com.example.tariand.R.drawable.nostar);
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.VISIBLE);
						notifyDataSetChanged();
					}
				});
			}
			else {
				anbukmark.setVisibility(1);
				anbukmark.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						tarianArray.get(thisposition).setBookmark(true);
						ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.noBookmark);
						book.setImageResource(com.example.tariand.R.drawable.star);						
						notifyDataSetChanged();
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.INVISIBLE);
						//v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.VISIBLE);
					}
				});
			}
		}

		return convertView;
	}

}
