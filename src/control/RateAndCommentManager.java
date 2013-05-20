package control;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import model.Comment;

public class RateAndCommentManager {
	private Comment comment;
	private int nRate;
	private float eRate;
	
	public RateAndCommentManager(Comment tr){
		this.setComment(tr);
	}
	
	public RateAndCommentManager(int nR, int eR){
		this.setNRate(nR);
		this.setERate(eR);
	}
	
	public RateAndCommentManager(Comment tr, int nR, int eR){
		this(tr);
		setNRate(nR);
		setERate(eR);
	}
	
	public void setNRate(int nR) {
		// TODO Auto-generated method stub
		this.nRate = nR;
	}
	
	public void setERate(float eR){
		this.eRate = eR;
	}

	public void post() {
		// TODO Auto-generated method stub
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(5);
		 nameValuePairs.add(new BasicNameValuePair("idTarian", comment.getIdTarian()()));
         nameValuePairs.add(new BasicNameValuePair("username",post.getLocation()));
         nameValuePairs.add(new BasicNameValuePair("email",post.getImageURL()));
         nameValuePairs.add(new BasicNameValuePair("comment",post.getVideoURL()));
         nameValuePairs.add(new BasicNameValuePair("irate",post.getDescription()));
         
         sendData(nameValuePairs);
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
