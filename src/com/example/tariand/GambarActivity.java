package com.example.tariand;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import control.V;
import model.Tarian;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GambarActivity extends Activity {

	//TarianManager tmng;
	//ArrayList<Tarian> tariArray;
	Tarian bcc;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        
        /*
        tmng = new TarianManager();
        tmng.testCode();
        
        String tarianku = getIntent().getStringExtra("namatarian");
        
        tariArray = tmng.getListTarian();
        
        for (Tarian tari : tariArray) {
        	if (tari.getName().equalsIgnoreCase(tarianku)){
				ImageView img = (ImageView) findViewById(R.id.Img1);
				img.setImageResource(Integer.parseInt(tari.getImageURL()));			
			}
		}
        */
        //bcc = (Tarian) getIntent().getSerializableExtra("tariannya");
        bcc = V.current;
        setTitle(bcc.getName());
        ImageView Image01 = (ImageView) findViewById(R.id.Img1);
		//img.setImageResource(Integer.parseInt(bcc.getImageURL()));
        TextView abc = (TextView) findViewById(R.id.imgError);
		try{
			String url = bcc.getImageURL();
	        Drawable image =ImageOperations(this,url);
	        if(image == null){
	        	abc.setVisibility(View.VISIBLE);
		    	Image01.setVisibility(View.GONE);
	        } else {
	        	Image01.setImageDrawable(image);
		        
		        abc.setVisibility(View.GONE);
		        Image01.setVisibility(View.VISIBLE);
	        }
	        
	    }
	    catch(Exception ex)
	    {
	    	
	        ex.printStackTrace();
	    }


	    //Image01.setMinimumWidth(width);
	    //Image01.setMinimumHeight(height);

	    //Image01.setMaxWidth(width);
	    //Image01.setMaxHeight(height);
       // ImageView asd = (ImageView) findViewById(R.id.Img1);
        //asd.setImageResource(R.drawable.gambyong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gambar, menu);
        return true;
    }
    
    public Object fetch(String address) throws MalformedURLException,
    IOException {
        URL url = new URL(address);
        Object content = url.getContent();
        return content;
    }  

    private Drawable ImageOperations(Context ctx, String url) {
        try {
            InputStream is = (InputStream) this.fetch(url);
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
