package control;

import helper.CustomHttpClient;

import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;

import com.example.tariand.MainActivity;

import model.Comment;

public class RateAndCommentManager {
	private Comment comment;
	private int nRate;
	private float eRate;
	private ArrayList<Comment> comments;
	private TreeSet<String> devIDs;
	
	public RateAndCommentManager(Comment tr){
		this.setComment(tr);
	}
	
	public RateAndCommentManager(int nR,float eR){
		this.setNRate(nR);
		this.setERate(eR);
	}
	
	public RateAndCommentManager(Comment tr, int nR,float eR){
		this.setComment(tr);
		this.setNRate(nR);
		this.setERate(eR);
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
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(9);
		 nameValuePairs.add(new BasicNameValuePair("idTarian", ""+comment.getIdTarian()));
         nameValuePairs.add(new BasicNameValuePair("username", comment.getUserName()));
         nameValuePairs.add(new BasicNameValuePair("email", comment.getEmail()));
         nameValuePairs.add(new BasicNameValuePair("comment", comment.getComment()));
         nameValuePairs.add(new BasicNameValuePair("irate", ""+comment.getRate()));
         nameValuePairs.add(new BasicNameValuePair("erate", ""+eRate));
         nameValuePairs.add(new BasicNameValuePair("nrate", ""+nRate));
         nameValuePairs.add(new BasicNameValuePair("devID", MainActivity.UNIQUE_ID));
         sendData(nameValuePairs);
	}

	private void sendData(ArrayList<NameValuePair> data) {
		// TODO Auto-generated method stub 
		try
        {
            HttpClient httpclient = new DefaultHttpClient();
            
            ///ganti ininya dulu, inget!
            HttpPost httppost = new HttpPost(MainActivity.target+"android/ratecomment.php");
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
	
	public void retrieveComments(int tarianID){
		ArrayList<Comment> commentss = new ArrayList<Comment>();
		TreeSet<String> devIDss = new TreeSet<String>();
		//continue disini ==> bikin php buat retrieve yang nerima masukan.
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("idTarian", ""+tarianID));
		//postParameters.add(new BasicNameValuePair("devID", MainActivity.UNIQUE_ID));
		String response = "";
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());
		try {
			response = CustomHttpClient.executeHttpPost(MainActivity.target+"android/getcomments.php", postParameters);
			
			String result = response.toString(); 
			Log.e("debug", "result = " + result);
		    JSONArray jArray = new JSONArray(result);
		    int [] IDtarian = new int [jArray.length()];
	        String [] userName = new String [jArray.length()];
	        String [] email = new String [jArray.length()];
	        String [] comment = new String [jArray.length()];
	        float [] iRate = new float [jArray.length()];
	        //String [] devID = new String[jArray.length()];
	        for(int i=0;i<jArray.length();i++){
	        	JSONObject json_data = jArray.getJSONObject(i);
	        	IDtarian[i] = Integer.parseInt(json_data.getString("IDTarian"));
	        	userName[i] = json_data.getString("username");
	        	email[i] = json_data.getString("email");
	        	comment[i] = json_data.getString("comment");
	        	iRate[i] = Float.parseFloat(json_data.getString("iRate"));
	        	//devID[i] = json_data.getString("Device_ID");
	        	Comment cmnt = new Comment(IDtarian[i], userName[i], email[i], comment[i]);
	        	cmnt.setRate(iRate[i]);
	        	commentss.add(cmnt);
	        	//devIDss.add(devID[i]);
	        }
	        this.comments = commentss;
	        this.devIDs = devIDss;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Comment> getComments(){
		return this.comments;
	}
	
	public boolean isCommented(String devID){
		return !(devIDs == null) && devIDs.contains(devID);
	}
}
