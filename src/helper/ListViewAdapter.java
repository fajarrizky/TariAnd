package helper;

import java.util.ArrayList;

import model.Tarian;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {

	private Tarian[] tarianArray;
	private LayoutInflater mInflater;
	
	public ListViewAdapter (Context context, Tarian[] results){
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
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.simple_list_item_1, null);
			
		}
		
		return null;
	}
	
	

}
