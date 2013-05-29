package control;

import java.util.ArrayList;

import model.Award;

public class AwardManager {
	ArrayList<Award> listAward;
	
	public AwardManager(){
		listAward = new ArrayList<Award>();
		createAward();
	}
	
	private void createAward(){
		
		//list award juga hardcode ae. soalnya kan sedikit. paling 10 biji gitu...
		Award[] aw = new Award[7];
		aw[0] = new Award(1, "Nilai Sempurna", "Pengguna berhasil mendapat nilai 100 dalam Quiz!");
		aw[0].setLink("http://tariand.id1945.com/asd/Nilai%20Sempurna.html");
		aw[1] = new Award(2, "Komentator", "Pengguna memberikan 5 buah komentar dan rating");
		aw[1].setLink("http://tariand.id1945.com/asd/Komentator.html");
		aw[2] = new Award(3, "Penyebar Budaya", "Pengguna membagikan Tarian ke media sosial 5 kali");
		aw[2].setLink("http://tariand.id1945.com/asd/Penyebar%20Budaya.html");
		aw[3] = new Award(4, "Kontributor", "Pengguna berhasil memberikan masukan Tarian baru");
		aw[3].setLink("http://tariand.id1945.com/asd/Kontributor.html");
		aw[4] = new Award(5, "Komentator II", "Pengguna memberikan 10 buah komentar dan rating");
		aw[4].setLink("http://tariand.id1945.com/asd/Komentator%202.html");
		aw[5] = new Award(6, "Penyebar Budaya II", "Pengguna membagikan Tarian ke media sosial 10 kali");
		aw[5].setLink("http://tariand.id1945.com/asd/Penyebar%20Budaya%202.html");
		aw[6] = new Award(7, "Penanda", "Pengguna memberikan Bookmark pada 5 Tarian");
		aw[6].setLink("http://tariand.id1945.com/asd/Penanda.html");
		
		for(int i = 0; i < aw.length; i++){
			listAward.add(aw[i]);
		}
		
		
		
//		1.	Jawab seluruh pertanyaan dengan benar
//		2.	Komen 5 kali
//		3.	Share 5 kali
//		4.	Kontribusi 1 kali
//		5.	Komen 10 kali
//		6.	Share 10 kali		
//		7.	Bookmark 5 Tarian 
	}
	
	
	public ArrayList<Award> getListAward(){
		return this.listAward;
	}
	
	public Award getAward(int postition){
		return listAward.get(postition);
	}
	
	public Award getAward(String name){
		
		
		for (Award aw : listAward) {
			if (aw.getName().equalsIgnoreCase(name))
				return aw;
		}
		return null;
	}
	
}
