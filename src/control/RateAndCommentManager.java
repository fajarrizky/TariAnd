package control;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.example.tariand.MainActivity;

import model.Comment;

public class RateAndCommentManager {
	private Comment comment;
	private int nRate;
	private float eRate;
	
	public RateAndCommentManager(Comment tr){
		this.setComment(tr);
	}
	
	public RateAndCommentManager(int nR,float eR){
		this.setNRate(nR);
		this.setERate(eR);
	}
	
	public RateAndCommentManager(Comment tr, int nR,float eR){
		this(tr);
		setNRate(nR);
		setERate(eR);
	}
	
	public RateAndCommentManager() {
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
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(7);
		 nameValuePairs.add(new BasicNameValuePair("idTarian", ""+comment.getIdTarian()));
         nameValuePairs.add(new BasicNameValuePair("username", comment.getUserName()));
         nameValuePairs.add(new BasicNameValuePair("email", comment.getEmail()));
         nameValuePairs.add(new BasicNameValuePair("comment", comment.getComment()));
         nameValuePairs.add(new BasicNameValuePair("irate", ""+comment.getRate()));
         nameValuePairs.add(new BasicNameValuePair("erate", ""+eRate));
         nameValuePairs.add(new BasicNameValuePair("nrate", ""+nRate));
         sendData(nameValuePairs);
	}

	private void sendData(ArrayList<NameValuePair> data) {
		// TODO Auto-generated method stub
		try
        {
            HttpClient httpclient = new DefaultHttpClient();
            
            ///ganti ininya dulu, inget!
            HttpPost httppost = new HttpPost(MainActivity.target+"android/rateandcomment.php");
            httppost.setEntity(new UrlEncodedFormEntity(data));
            //HttpResponse response = 
            httpclient.execute(httppost);
            
        }
        catch(Exception e)
        {
            Log.e("log_tag", "Error:  "+e.toString());
        } 
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}
