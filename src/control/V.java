package control;

import model.Tarian;
import android.content.SharedPreferences;

public class V {
	public static TarianManager tariManager;
	public static SharedPreferences shpr;
	public static SharedPreferences.Editor shedtr;
	public static final String target = "http://tariand.id1945.com/";
	//public static final String target = "http://192.168.91.50/";
	public static String UNIQUE_ID;
	//@SuppressWarnings("deprecation")
	//String deviceId = Settings.System.getString(getContentResolver(),Settings.System.ANDROID_ID);
	
	public static Tarian current;
	public static AwardManager awrdMngr;
	public static RateAndCommentManager rtcmmngr;
	public static UserContributionManager ucmngr;
	public static QuestionManager qmngr;
	
	public static void initiateVariables(){
		//tariManager = new TarianManager();
		awrdMngr = new AwardManager();
		rtcmmngr = new RateAndCommentManager();
		ucmngr = new UserContributionManager();
		qmngr = new QuestionManager();
	}
}
