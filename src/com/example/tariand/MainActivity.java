package com.example.tariand;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import control.TarianManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
//import android.provider.Settings;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	public static TarianManager tariManager;
	public static SharedPreferences shpr;
	public static SharedPreferences.Editor shedtr;
	public static final String target = "http://tariand.id1945.com/";
	//public static final String target = "http://192.168.91.50/";
	public static String UNIQUE_ID;
	//@SuppressWarnings("deprecation")
	//String deviceId = Settings.System.getString(getContentResolver(),Settings.System.ANDROID_ID);
 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cari = (Button) findViewById(R.id.CariTarianButton);
        Button award = (Button) findViewById(R.id.LihatAwardButton);
        Button bookmark = (Button) findViewById(R.id.LihatBookmarkButton);
        Button play = (Button) findViewById(R.id.MainkanQuizButton);
        Button contribute = (Button) findViewById(R.id.UserContribution);
        UNIQUE_ID = this.getDeviceID();
        shpr = getSharedPreferences("TariAnd", MODE_PRIVATE );
        shedtr = shpr.edit();
        setTitle("TariAnd");
        tariManager = new TarianManager();
		//tariManager.testCode();
		tariManager.retrieve();
		
        cari.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), CariTarianActivity.class));
			}
		});
        
        award.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), AwardListViewActivity.class));
			}
		});
        
        bookmark.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), ListViewActivity.class);
				i.putExtra("bookmark", true);
				startActivity(i);
				}
			});

		play.setOnClickListener(new View.OnClickListener() {
	
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getApplicationContext(), PlayQuizActivity3.class));
					}
			});
		contribute.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), UserContribution.class));
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public String getDeviceID() {

    	/*String Return_DeviceID = USERNAME_and_PASSWORD.getString(DeviceID_key,"Guest");
    	return Return_DeviceID;*/

    	TelephonyManager TelephonyMgr = (TelephonyManager) getApplicationContext().getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
    	String m_szImei = TelephonyMgr.getDeviceId(); // Requires
    	// READ_PHONE_STATE

    	// 2 compute DEVICE ID
    	String m_szDevIDShort = "35"
    	+ // we make this look like a valid IMEI
    	Build.BOARD.length() % 10 + Build.BRAND.length() % 10
    	+ Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10
    	+ Build.DISPLAY.length() % 10 + Build.HOST.length() % 10
    	+ Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
    	+ Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10
    	+ Build.TAGS.length() % 10 + Build.TYPE.length() % 10
    	+ Build.USER.length() % 10; // 13 digits
    	// 3 android ID - unreliable
    	String m_szAndroidID = Secure.getString(getContentResolver(),Secure.ANDROID_ID);
    	// 4 wifi manager, read MAC address - requires
    	// android.permission.ACCESS_WIFI_STATE or comes as null
    	WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    	String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
    	// 5 Bluetooth MAC address android.permission.BLUETOOTH required
    	BluetoothAdapter m_BluetoothAdapter = null; // Local Bluetooth adapter
    	m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    	String m_szBTMAC = m_BluetoothAdapter.getAddress();
    	System.out.println("m_szBTMAC "+m_szBTMAC);

    	// 6 SUM THE IDs
    	String m_szLongID = m_szImei + m_szDevIDShort + m_szAndroidID+ m_szWLANMAC + m_szBTMAC;
    	System.out.println("m_szLongID "+m_szLongID);
    	MessageDigest m = null;
    	try {
    	m = MessageDigest.getInstance("MD5");
    	} catch (NoSuchAlgorithmException e) {
    	e.printStackTrace();
    	                }
    	m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
    	byte p_md5Data[] = m.digest();

    	String m_szUniqueID = new String();
    	for (int i = 0; i < p_md5Data.length; i++) {
    	int b = (0xFF & p_md5Data[i]);
    	// if it is a single digit, make sure it have 0 in front (proper
    	// padding)
    	if (b <= 0xF)
    	m_szUniqueID += "0";
    	// add number to string
    	m_szUniqueID += Integer.toHexString(b);
    	}
    	m_szUniqueID = m_szUniqueID.toUpperCase();

    	Log.i("-------------DeviceID------------", m_szUniqueID);
    	Log.d("DeviceIdCheck", "DeviceId that generated MPreferenceActivity:"+m_szUniqueID);

    	return m_szUniqueID;

    	}
   
    
    
    
}
