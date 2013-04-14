package control;

import helper.CustomHttpClient;

import java.util.ArrayList;
import java.util.ListIterator;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import model.Tarian;

public class TarianManager {
	ArrayList<Tarian> listTarian;

	public TarianManager(){
		listTarian = new ArrayList<Tarian>();
	}

	//niatnya ini buat ngeretrieve dari database, masukin semua tarian ke list.
	public void retrieve(){
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();  
		//postParameters.add(new BasicNameValuePair("Nama", input.getText().toString()));
		String response = null;
		try {
			response = CustomHttpClient.executeHttpPost("http://192.168.0.105/android/daftar_tarian.php", postParameters);
		    String result = response.toString();  
		    try{
		    	JSONArray jArray = new JSONArray(result);
		        int [] ID = new int [jArray.length()];
		        String [] Nama = new String [jArray.length()];
		        String [] Provinsi = new String [jArray.length()];
		        String [] Deskripsi = new String [jArray.length()];
		        
		        for(int i=0;i<jArray.length();i++){
		        	JSONObject json_data = jArray.getJSONObject(i);
			        ID[i] = Integer.parseInt(json_data.getString("ID"));
			        Nama[i] = json_data.getString("Nama");
		        	Provinsi[i] = json_data.getString("Provinsi");	         
			        Deskripsi[i] = json_data.getString("Deskripsi");
			        Tarian tarian = new Tarian(ID[i], Nama[i]);
			        tarian.setDescription(Deskripsi[i]);
			        tarian.setLocation(Provinsi[i]);
			        listTarian.add(tarian);
			        }
		    } 
		    catch(JSONException e){
		    	Log.e("log_tag", "Error parsing data "+e.toString());
		    }
		    }
		catch (Exception e) {
			Log.e("log_tag","Error in http connection!!" + e.toString());     
		}
	}         
		
	//yang ini buat nyari dari nama
	public ArrayList<Tarian> searchByName(String targetName){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.getName().equals(targetName)){
				target.add(temp);
			}
		}
		return target;
	}


	//yang ini buat nyari dari lokasi
	public ArrayList<Tarian> searchByLocation(String targetLocation){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.getLocation().equals(targetLocation)){
				target.add(temp);
			}
		}
		return target;
	}

	//yang ini buat nyari yang udah d bookmark ae
	public ArrayList<Tarian> getBookmarkedTarian(){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.isBookmarked()){
				target.add(temp);
			}
		}
		return target;
	}
}
