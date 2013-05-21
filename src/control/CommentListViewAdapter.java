package control;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import model.Comment;

public class CommentListViewAdapter extends BaseAdapter {
	ArrayList<Comment> comments;
	Comment comment;
	LayoutInflater mInflater;
	
	public CommentListViewAdapter(Context context, ArrayList<Comment> results) {
		comments = results;
		mInflater = LayoutInflater.from(context);
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return comments.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return comments.get(arg0);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
