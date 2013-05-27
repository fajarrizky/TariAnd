package control;

import java.util.ArrayList;

import model.Tarian;

//import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.example.tariand.MainActivity;

public class UserContributionManager {
	private Tarian post;

	public UserContributionManager(Tarian tr){
		this.post = tr;
	}

	public UserContributionManager(){
		
	}
	public void post() {
		// TODO Auto-generated method stub
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(6);
		 nameValuePairs.add(new BasicNameValuePair("namaTarian", post.getName()));
         nameValuePairs.add(new BasicNameValuePair("provinsi",post.getLocation()));
         nameValuePairs.add(new BasicNameValuePair("link",post.getLink()));
         nameValuePairs.add(new BasicNameValuePair("urlgambar",post.getImageURL()));
         nameValuePairs.add(new BasicNameValuePair("urlvideo",post.getVideoURL()));
         nameValuePairs.add(new BasicNameValuePair("deskripsi",post.getDescription()));
         
         sendData(nameValuePairs);
	}

	private void sendData(ArrayList<NameValuePair> data) {
		// TODO Auto-generated method stub
		try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(V.target+"android/usercontrib.php");
            httppost.setEntity(new UrlEncodedFormEntity(data));
            httpclient.execute(httppost);
            
        }
        catch(Exception e)
        {
            Log.e("log_tag", "Error:  "+e.toString());
        } 
	}
}
