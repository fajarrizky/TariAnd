package helper;

import java.util.ArrayList;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
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
		//final int thisposition = position;
		comment = comments.get(position);
		if (convertView == null) {
			convertView = mInflater.inflate(com.example.tariand.R.layout.comment_viewer, null);
		}
		TextView commenter = (TextView) convertView.findViewById(com.example.tariand.R.id.commenter);
		TextView isicomment = (TextView) convertView.findViewById(com.example.tariand.R.id.isiComment);
		RatingBar ratingPengguna = (RatingBar) convertView.findViewById(com.example.tariand.R.id.ratingPengguna);
		commenter.setText(comment.getUserName());
		//commenter.setTextColor(R.color.black);
		isicomment.setText(comment.getComment());
		//isicomment.setTextColor(R.color.black);
		ratingPengguna.setRating(comment.getRate());
		ratingPengguna.setIsIndicator(true);
		return convertView;
	}

}
