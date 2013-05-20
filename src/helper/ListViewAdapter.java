package helper;

import java.util.ArrayList;

import model.Tarian;


import android.R;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tariand.*;

public class ListViewAdapter extends BaseAdapter {

	ArrayList<Tarian> tarianArray;
	Tarian tarian;
	LayoutInflater mInflater;
	ImageButton bukmark;

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
		return tarianArray.get(arg0).getName();
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int thisposition = position;
		tarian = tarianArray.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(com.example.tariand.R.layout.list_view, null);
		}
		TextView tv = (TextView) convertView.findViewById(com.example.tariand.R.id.namaTarian);
		bukmark = (ImageButton) convertView.findViewById(com.example.tariand.R.id.bookmark);
		//ImageButton anbukmark = (ImageButton) convertView.findViewById(com.example.tariand.R.id.noBookmark);
		if(tarian.isBookmarked()){
			bukmark.setImageResource(com.example.tariand.R.drawable.star);
		} else {
			bukmark.setImageResource(com.example.tariand.R.drawable.nostar);

		}
		tv.setText(tarian.getName());
		tv.setClickable(true);
		tv.setTextColor(convertView.getResources().getColor(R.color.black));
		tv.setOnClickListener(new View.OnClickListener() {				
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(arg0.getContext(), TampilTarianActivity.class);
				i.putExtra("tarian", (String) getItem(thisposition));
				i.putExtra("tariannya", tarianArray.get(thisposition));
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				arg0.getContext().startActivity(i);
			}
		});

		bukmark.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Tarian aaa = tarianArray.get(thisposition);
				if(aaa.isBookmarked()){
					aaa.setBookmark(false);
					//bukmark.setImageResource(com.example.tariand.R.drawable.nostar);
					ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.bookmark);
					book.setImageResource(com.example.tariand.R.drawable.nostar);
					notifyDataSetChanged();
					Log.d(""+aaa.getName(), "setBookmark dari true ke "+aaa.isBookmarked());
				} else {
					aaa.setBookmark(true);
					//bukmark.setImageResource(com.example.tariand.R.drawable.star);
					ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.bookmark);
					book.setImageResource(com.example.tariand.R.drawable.star);
					notifyDataSetChanged();
					Log.d(""+aaa.getName(), "setBookmark dari false ke "+aaa.isBookmarked());
				}
			}
		});

		/*
			if (tarianArray.get(thisposition).isBookmarked()){
				bukmark.setVisibility(1);
				anbukmark.setVisibility(View.INVISIBLE);
				bukmark.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						Tarian aaa = tarianArray.get(thisposition);
						aaa.setBookmark(false);
						//v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.INVISIBLE);
						ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.bookmark);
						book.setImageResource(com.example.tariand.R.drawable.nostar);
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.VISIBLE);
						notifyDataSetChanged();
						Log.d(""+aaa.getName(), "setBookmark dari true ke "+aaa.isBookmarked());
					}
				});
			}
			else {
				anbukmark.setVisibility(1);
				anbukmark.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// TODO Auto-generated method stub
						Tarian aaa = tarianArray.get(thisposition);
						aaa.setBookmark(true);
						ImageButton book = (ImageButton) v.findViewById(com.example.tariand.R.id.noBookmark);
						book.setImageResource(com.example.tariand.R.drawable.star);						
						notifyDataSetChanged();
						Log.d(""+aaa.getName(), "setBookmark dari false ke "+aaa.isBookmarked());
						//v.findViewById(com.example.tariand.R.id.noBookmark).setVisibility(View.INVISIBLE);
						//v.findViewById(com.example.tariand.R.id.bookmark).setVisibility(View.VISIBLE);
					}
				});
			} 
		 */


		return convertView;
	}

	public void changeImageSrc(ImageButton a, int b){
		a.setImageResource(b);
	}

}
