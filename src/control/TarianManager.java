package control;

import helper.CustomHttpClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;
import model.Tarian;

public class TarianManager {
	ArrayList<Tarian> listTarian;

	public TarianManager(){
		listTarian = new ArrayList<Tarian>(300);
	}
	
	public ArrayList<Tarian> getListTarian(){
		return this.listTarian;
	}

	public void testCode(){
        //test code
        Tarian aa = new Tarian(1, "Tari Pendet");
        aa.setBookmark(V.shpr.getBoolean(""+aa.getName(), false));
        aa.setDescription("Tarian dari Bali");
        aa.setLocation("Bali");
        aa.setVideoURL("QARV4YeH3dE");
        aa.setImageURL(""+com.example.tariand.R.drawable.pendet);
        listTarian.add(aa);
        
        Tarian bb = new Tarian(2, "Tari Gambyong");
        bb.setBookmark(V.shpr.getBoolean(""+bb.getName(), false));
        bb.setDescription("Salah satu tarian dari Sumatera Utara");
        bb.setLocation("Sumatera Utara");
        bb.setVideoURL("yewkOTbxY30");
        bb.setImageURL(""+ com.example.tariand.R.drawable.gambyong);
        listTarian.add(bb);
        
        
        for (Tarian asd : listTarian) {
			Log.d("Nama Tarian", asd.getName());
			Log.d("Deskripsi Tarian", asd.getDescription());
		}
        //end of test code
	}
	//niatnya ini buat ngeretrieve dari database, masukin semua tarian ke list.
	public void retrieve(){
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();  
		String response = null;
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		.detectDiskReads().detectDiskWrites().detectNetwork()
		.penaltyLog().build());
		try {
			response = CustomHttpClient.executeHttpPost(V.target+"android/lala.php", postParameters);
		    String result = response.toString();  
		    Log.e("debug", "result = " + result);
		    try{
		    	JSONArray jArray = new JSONArray(result);
		        int [] ID = new int [jArray.length()];
		        String [] Nama = new String [jArray.length()];
		        String [] Provinsi = new String [jArray.length()];
		        String [] Deskripsi = new String [jArray.length()];
		        String [] Foto = new String [jArray.length()];
		        String [] URL = new String [jArray.length()];
		        String [] published = new String[jArray.length()];
		        String [] eRate = new String[jArray.length()];
		        String [] nRate = new String[jArray.length()];
		        String [] link = new String[jArray.length()];
		        for(int i=0;i<jArray.length();i++){
		        	JSONObject json_data = jArray.getJSONObject(i);
			        ID[i] = Integer.parseInt(json_data.getString("ID"));
			        Nama[i] = json_data.getString("Nama");
		        	Provinsi[i] = json_data.getString("Provinsi");	         
			        Deskripsi[i] = json_data.getString("Deskripsi");
			        Foto[i] = json_data.getString("Lokasi");
			        URL[i] = json_data.getString("URL");
			        //published[i] = json_data.getString("isPublished");
			        published[i] = json_data.getString("published");
			        eRate[i] = json_data.getString("eRate");
			        nRate[i] = json_data.getString("nRate");
			        //link[i] = json_data.getString("Link");
			        link[i] = json_data.getString("link");
			        Tarian tarian = new Tarian(ID[i], Nama[i]);
			        tarian.setDescription(Deskripsi[i]);
			        tarian.setLocation(Provinsi[i]);
			        tarian.setImageURL(Foto[i]);
			        tarian.setVideoURL(URL[i]);
			        tarian.setPublished(published[i].equals("1"));
			        tarian.setRate(Float.valueOf(eRate[i]));
			        tarian.setNRate(Integer.parseInt(nRate[i]));
			        tarian.setLink(link[i]);
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
		Collections.sort(listTarian);
	}         
		
	//yang ini buat nyari dari nama
	public ArrayList<Tarian> searchByName(String targetName){
		ArrayList<Tarian> target = new ArrayList<Tarian>(300);

		for (Tarian tarian : listTarian) {
			if(tarian.getName().toLowerCase().contains(targetName)){
				Log.d("equals?", tarian.getName().contains(targetName) + "");
				target.add(tarian);
			}
		}
		
		return target;
	}


	//yang ini buat nyari dari lokasi
	public ArrayList<Tarian> searchByLocation(String targetLocation){
		ArrayList<Tarian> target = new ArrayList<Tarian>(300);

		for (Tarian tarian : listTarian) {
			if(tarian.getLocation().toLowerCase().equalsIgnoreCase(targetLocation)){
				Log.d("equals?", tarian.getLocation().equalsIgnoreCase(targetLocation) + "hai");
				target.add(tarian);
			}
		}
		return target;
	}
	
	

	//yang ini buat nyari yang udah d bookmark ae
	public ArrayList<Tarian> getBookmarkedTarian(){
		ArrayList<Tarian> target = new ArrayList<Tarian>(300);

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.isBookmarked()){
				target.add(temp);
			}
		}
		return target;
	}
	
	public void sortList(){
		Collections.sort(listTarian);
	}
}
