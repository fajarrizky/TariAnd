package control;

import java.util.ArrayList;

import model.Award;

public class AwardManager {
	ArrayList<Award> listAward;
	
	public AwardManager(){
		listAward = new ArrayList<Award>();
	}
	
	public void createAward(){
		
		//list award juga hardcode ae. soalnya kan sedikit. paling 10 biji gitu...
		listAward.add(new Award(1, "Perfect Answer", "User berhasil menjawab seluruh pertanyaan dengan benar"));
		listAward.add(new Award(1, "Power Share", "User berhasil menshare 5 buah tarian"));
		listAward.add(new Award(1, "Golden Bookmark", "User berhasil membookmark 10 tarian"));
	}
	
	
	public ArrayList<Award> getListAward(){
		return this.listAward;
	}
	
	public Award getAward(String name){
		
		
		for (Award aw : listAward) {
			if (aw.getName().equalsIgnoreCase(name))
				return aw;
		}
		return null;
	}
	
}
