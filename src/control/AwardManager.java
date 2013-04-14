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
		listAward.add(new Award(1, "Menang Quiz", "Pemain sudah memenangkan quiz setidaknya sekali"));
		
	}
	
	public Award getAward(String name){
		
		
		for (Award aw : listAward) {
			if (aw.getName().equalsIgnoreCase(name))
				return aw;
		}
		return null;
	}
	
}
