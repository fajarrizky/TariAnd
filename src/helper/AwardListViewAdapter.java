package helper;

import java.util.ArrayList;

import control.V;

import model.Award;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AwardListViewAdapter extends BaseAdapter {

	private ArrayList<Award> awardArray;
	private LayoutInflater mInflater;
	
	public AwardListViewAdapter(Context context, ArrayList<Award> results) {
		awardArray = results;
		mInflater = LayoutInflater.from(context);
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return awardArray.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return awardArray.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		final int thisposition = position;
		final Award mAward = awardArray.get(position);
		if (convertView==null){
			convertView = mInflater.inflate(com.example.tariand.R.layout.list_award_view, null);
		}
		TextView tv  = (TextView) convertView.findViewById(com.example.tariand.R.id.awardName);
		TextView tv2  = (TextView) convertView.findViewById(com.example.tariand.R.id.awardDesc);
		ImageButton btn= (ImageButton) convertView.findViewById(com.example.tariand.R.id.awardIcon);
		
		if(mAward.isAchieved()){
			tv.setText(mAward.getName()+" (Sudah Didapat)");
			tv2.setText(mAward.getDescription());
		} else {
			tv.setText(mAward.getName()+" (Belum Didapat");
			tv2.setText(mAward.getDescription());
			convertView.setBackgroundColor(0x114477);
		}	

		tv.setTextColor(com.example.tariand.R.color.blue);
		tv2.setTextColor(com.example.tariand.R.color.blue);
		btn.setImageResource(V.awardImgRes[position]);
		btn.setClickable(mAward.isAchieved());
		btn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				sendIntent.putExtra(Intent.EXTRA_TEXT, mAward.getName()+" : "+mAward.getLink());
				sendIntent.setType("text/plain");
				if(mAward.isAchieved()){
				v.getContext().startActivity(sendIntent);
				} else {
					Toast.makeText(v.getContext(), "Award Belum Didapatkan", Toast.LENGTH_SHORT).show();
				}
				//startActivity(Intent.createChooser(sendIntent, "Share With"));
			}
		});
		
		
		return convertView;
	}


}
