package helper;

import java.util.ArrayList;
import java.util.List;

import model.Award;
import model.Tarian;
import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

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

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (arg1==null){
			arg1 = mInflater.inflate(R.layout.simple_list_item_1, null);
		}
		
		return null;
	}


}
