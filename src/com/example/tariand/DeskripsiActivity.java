package com.example.tariand;

import helper.CommentListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Attr;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Settings;
import com.facebook.widget.LoginButton;

import control.RateAndCommentManager;
import model.Comment;
import model.Tarian;

import android.R.attr;
import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class DeskripsiActivity extends Activity {
	RatingBar rerataRating, beriRating;
	//ListView listComments;
	TextView beriKomentarTV, deskripsiTarian;
	LinearLayout beriKomentarLayout;
	EditText namaKomenter, emailKomenter, komentar;
	ImageButton sfb;//, stw;
	Button submitKomentar;
	Tarian bcc;
	RateAndCommentManager rncm;
	ArrayList<Comment> comments;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deskripsi);
		
		/*
		 * ini bagian sulit, mesti di tulis biar inget:
		 * dibagi jadi 3 part:
		 * - Rerata Rating dan Deskripsi Tarian, bisa diambil dari putExtra tarian.
		 * - Komentar-komentar, ini mesti retrieve dari database, terus di anu2in.
		 * ?? gimana retrieve nya?
		 * !! select from comment where idtarian = bcc.id (1php)
		 * - Beri komentar. Kalo device id belum ngasih komentar, dia bisa ngasih komentar
		 * 		kalo udah, bagian berikomentar nya di ilangin.
		 * 
		 * ?? gimana ngecek dia udah pernah ngasih komentar atau belum?
		 * !! jadi pertama2 select distinct comment.device_id where idtarian = bcc.id, dimasukin ke list (1php nih)
		 * !! lalu di cek list.contains(device_id), kalo ya, berikomentar di hide. else normal.
		 * 
		 * ?? yang retrieve komentar sama cek device_id kan sama, bisa dijadiin 1 php ga sih?
		 * !! bisa kayaknya, jadi ikutin kaya yang retrieve di tarianManager, abis itu dibikin 2 list:
		 * !! yang satu list komentar, isinya semua komentar yang ada.
		 * !! yang satu lagi list string, isinya semua device_id yang pernah komentar disini.
		 * !! lalu tampilkan komentar2 di listview pake custom list view adapter
		 * !! baru deh tentuin berikomentar perlu di hide apa kagak.
		 * 
		 * ?? lalu bagaimana dengan tombol submit komentar?
		 * !! dia isi semua2nya, lalu pas neken tombol submit komentar
		 * !! masuk ke page ini lagi. tapi segalanya udah di update dong!
		 * 
		 * ?? apa aja yang di update?
		 * !! rating tarian: update di database, terus update di list manager.
		 * !! jumlah komentar: masukin komentarnya pengguna.
		 * !! berikomentar di ilangin, karena dia udah ngasih komen. cuma boleh sekali yaa.
		 * 
		 * - nambah 1 part lagi, yaitu share! fb dan twitter!
		 * ?? gimana handle nya? 
		 * || pelajarin sendiri aja yah!
		 */
		
		/*
		tmng = MainActivity.tariManager;
		String tarianku = getIntent().getStringExtra("namatarian");
		tarianList = tmng.getListTarian();

		for (Tarian tari : tarianList) {
			if (tari.getName().equalsIgnoreCase(tarianku)){
				TextView tv = (TextView) findViewById(R.id.deskripsiTarian);
				tv.setText(tari.getDescription());
			}
		}
		*/
		
		
		
		//part 1
		bcc =(Tarian) getIntent().getSerializableExtra("tariannya");
		setTitle("Deskripsi "+bcc.getName());
		rerataRating = (RatingBar) findViewById(R.id.ratingTarian);        
        rerataRating.setIsIndicator(true);
        rerataRating.setRating(bcc.getRate());
		deskripsiTarian = (TextView) findViewById(R.id.deskripsiTarian);
		deskripsiTarian.setText(bcc.getDescription());
		//kode di bawah ini mungkin suspicious, kalo terjadi sesuatu sama anu2 coba cek yg ini.
		deskripsiTarian.setMovementMethod(new ScrollingMovementMethod());
		
		//part 2
		rncm = new RateAndCommentManager();
		
		rncm.retrieveComments(bcc.getId());
		
		comments = rncm.getComments();
		ArrayList<Comment> taken = new ArrayList<Comment>();
		for(int i = 0; i<comments.size(); i++){
			Log.e("komen ke "+i, comments.get(i).getComment());
			if(comments.get(i).getIdTarian()==bcc.getId()){
				taken.add(comments.get(i));
			}
		}
		
		TableLayout tbleLayout = (TableLayout) findViewById(R.id.commentsView);
		int tsize = taken.size();
		if(tsize==0){
			TableRow tblrow = new TableRow(this);
			TextView c = new TextView(this);
			c.setText("Belum ada yang memberi komentar pada tarian ini");
			c.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
			tblrow.addView(c);
			tbleLayout.addView(tblrow);
		} else {
			for(int i = 0; i<taken.size(); i++){
				Comment k = taken.get(i);
				int bgnd;
				if(i%2 == 1){
					bgnd = Color.rgb(172, 225, 238);
				} else {
					bgnd = Color.rgb(239, 241, 169);
				}

				TableRow t1, t2, t3, t4;
				t1 = new TableRow(this);
				t1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				t2 = new TableRow(this);
				t2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				t3 = new TableRow(this);
				t3.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				t4 = new TableRow(this);
				t4.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

				t1.setBackgroundColor(bgnd);
				t2.setBackgroundColor(bgnd);
				t3.setBackgroundColor(bgnd);
				t4.setBackgroundColor(bgnd);

				TextView rate, name, comment;
				rate = new TextView(this);
				rate.setLeft(5);
				name = new TextView(this);
				name.setLeft(5);
				comment = new TextView (this);
				comment.setLeft(5);

				LinearLayout llin = new LinearLayout(this);
				llin.setOrientation(LinearLayout.HORIZONTAL);
				RatingBar rtb = new RatingBar(this);

				name.setText(k.getUserName());
				name.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
				t1.addView(name);

				rate.setText("Rating : ");
				rate.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
				rate.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
				llin.addView(rate);

				rtb.setRating(k.getRate());
				rtb.setNumStars(5);
				rtb.setIsIndicator(true);
				llin.addView(rtb);
				t3.addView(llin);

				comment.setText(k.getComment());
				comment.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
				t4.addView(comment);
				tbleLayout.addView(t1);
				tbleLayout.addView(t3);
				tbleLayout.addView(t4);
			}
		}
		//part 3
		beriKomentarTV = (TextView) findViewById(R.id.beriKomentarTV);	
		beriKomentarLayout = (LinearLayout) findViewById(R.id.BeriKomentar);
		beriRating = (RatingBar) findViewById(R.id.beriRating);
		beriRating.setNumStars(5);
		namaKomenter = (EditText) findViewById(R.id.namaKomenter);
		emailKomenter = (EditText) findViewById(R.id.emailKomenter);
		komentar = (EditText) findViewById(R.id.komentar);
		submitKomentar = (Button) findViewById(R.id.submitKomentar);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
				
//		for(int i = 0; i<comments.size(); i++){
//			Comment k = comments.get(i);
//			TableRow y = new TableRow(this);
//			TableRow y2 = new TableRow(this);
//			TableRow y3 = new TableRow(this);
//			TableRow y4 = new TableRow(this);
//			TextView rating = new TextView(getApplicationContext());
//			rating.setText("Rating : ");
//			y.addView(rating);
//			RatingBar rcc = new RatingBar(getApplicationContext());
//			rcc.setIsIndicator(true);
//			rcc.setRating(k.getRate());
//			y2.addView(rcc);
//			TextView ecc = new TextView(getApplicationContext());
//			ecc.setText(k.getUserName());
//			y3.addView(ecc);
//			TextView ekk = new TextView(getApplicationContext());
//			ekk.setText(k.getComment());
//			y4.addView(ekk);
//			x.addView(y);
//			x.addView(y2);
//			x.addView(y3);
//			x.addView(y4);
//		}
		
		submitKomentar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				process();
				//Intent intent = new Intent(getApplicationContext(), Transfer.class);
				//intent.putExtra("tariannya", bcc);
				//intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				//startActivity(intent);
				//finish();
			}
		}); 
		
		//part 4: share dan twitter
		sfb = (ImageButton) findViewById(R.id.sfb);
		sfb.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub 
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, bcc.getLink());
				sendIntent.setType("text/plain");
				startActivity(Intent.createChooser(sendIntent, "Share With"));
				//Intent i = new Intent(getApplicationContext(), ShareFacebookActivity.class);
				//i.putExtra("tariannya", bcc);
				//startActivity(i);
			}
		});
		
//		stw.setOnClickListener(new View.OnClickListener() {
//			
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i = new Intent(getApplicationContext(), ShareTwitterActivity.class);
//				i.putExtra("tariannya", bcc);
//				startActivity(i);
//			}
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_deskripsi, menu);
		return true;
	}
	
	private void process() {
		// TODO Auto-generated method stub
		Comment cmnt = new Comment(bcc.getId(), namaKomenter.getText().toString(), emailKomenter.getText().toString(), komentar.getText().toString());       
        float irate = beriRating.getRating();
		if(irate != 0){
			cmnt.setRate(irate);
			bcc.addRate(irate);			
		}
		bcc.addComment(cmnt);
		rncm.setComment(cmnt);
		rncm.setERate(bcc.getRate());
		rncm.setNRate(bcc.getNRate());
		rncm.post();
		Toast.makeText(this, "Komentar Anda sudah dikirim", Toast.LENGTH_SHORT).show();
		beriKomentarLayout.setVisibility(View.GONE);
	}
	
}
