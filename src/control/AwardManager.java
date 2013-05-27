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
		listAward.add(new Award(1, "Nilai Sempurna", "Pengguna berhasil mendapat nilai 100 dalam Quiz!"));
		listAward.add(new Award(2, "Komentator", "Pengguna memberikan 5 buah komentar dan rating"));
		listAward.add(new Award(3, "Penyebar Budaya", "Pengguna membagikan Tarian ke media sosial 5 kali"));
		listAward.add(new Award(4, "Kontributor", "Pengguna berhasil memberikan masukan Tarian baru"));
		listAward.add(new Award(5, "Komentator II", "Pengguna memberikan 10 buah komentar dan rating"));
		listAward.add(new Award(6, "Penyebar Budaya II", "Pengguna membagikan Tarian ke media sosial 5 kali"));
		listAward.add(new Award(7, "Penanda", "Pengguna memberikan Bookmark pada 5 Tarian"));
		
		
		
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
