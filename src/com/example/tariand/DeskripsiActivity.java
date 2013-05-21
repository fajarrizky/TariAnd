package com.example.tariand;

import helper.CommentListViewAdapter;

import java.util.ArrayList;

import control.RateAndCommentManager;
import model.Comment;
import model.Tarian;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DeskripsiActivity extends Activity {
	RatingBar rerataRating, beriRating;
	ListView listComments;
	TextView beriKomentarTV, deskripsiTarian;
	LinearLayout beriKomentarLayout;
	EditText namaKomenter, emailKomenter, komentar;
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
		
		//rncm.retrieveComments(bcc.getId());
		
		//comments = rncm.getComments();
		//if(comments == null){
			comments = new ArrayList<Comment>();
			Comment cm1 = new Comment(1,"vann","vann_aaa", "nice one sir");
			Comment cm2 = new Comment(1,"vann2","vann_aaa", "nice one sir");
			cm1.setRate((float) 2);
			cm2.setRate(4);
			comments.add(cm1);
			comments.add(cm2);
		//}
		
		listComments = (ListView) findViewById(R.id.listComments);
		if(comments != null){
			for(int i = 0; i < comments.size(); i++){
				Log.e("komen ke "+i, comments.get(i).getUserName());
			}
			CommentListViewAdapter adapter = new CommentListViewAdapter(getApplicationContext(), comments);
			listComments.setAdapter(adapter);
		} else {
			ArrayList<String> listString = new ArrayList<String>();
			listString.add("Belum ada komentar. Silahkan beri komentar");
			Log.e("komen", "belum ada komenta, eww");
			ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listString);
			listComments.setAdapter(adapter2);
		}
		
		//part 3
		beriKomentarTV = (TextView) findViewById(R.id.beriKomentarTV);	
		beriKomentarLayout = (LinearLayout) findViewById(R.id.BeriKomentar);
		beriRating = (RatingBar) findViewById(R.id.beriRating);
		namaKomenter = (EditText) findViewById(R.id.namaKomenter);
		emailKomenter = (EditText) findViewById(R.id.emailKomenter);
		komentar = (EditText) findViewById(R.id.komentar);
		submitKomentar = (Button) findViewById(R.id.submitKomentar);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		if(rncm.isCommented(MainActivity.UNIQUE_ID)){
			beriKomentarLayout.setVisibility(View.GONE);
		}
		TableLayout x = (TableLayout) findViewById(R.id.tablelayout);
		for(int i = 0; i<comments.size(); i++){
			Comment k = comments.get(i);
			TableRow y = new TableRow(this);
			TableRow y2 = new TableRow(this);
			TableRow y3 = new TableRow(this);
			TableRow y4 = new TableRow(this);
			TextView rating = new TextView(getApplicationContext());
			rating.setText("Rating : ");
			y.addView(rating);
			RatingBar rcc = new RatingBar(getApplicationContext());
			rcc.setIsIndicator(true);
			rcc.setRating(k.getRate());
			y2.addView(rcc);
			TextView ecc = new TextView(getApplicationContext());
			ecc.setText(k.getUserName());
			y3.addView(ecc);
			TextView ekk = new TextView(getApplicationContext());
			ekk.setText(k.getComment());
			y4.addView(ekk);
			x.addView(y);
			x.addView(y2);
			x.addView(y3);
			x.addView(y4);
		}
		
		submitKomentar.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				process();
				Intent intent = new Intent(getApplicationContext(), DeskripsiActivity.class);
				intent.putExtra("tariannya", bcc);
				startActivity(intent);
			}
		});
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
	}
}
