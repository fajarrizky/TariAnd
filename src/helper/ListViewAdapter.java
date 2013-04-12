package helper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ListViewAdapter extends ArrayAdapter<Object> {

	public ListViewAdapter(Context context, int textViewResourceId,
			Object[] objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return super.getView(position, convertView, parent);
	}
	
	

}
