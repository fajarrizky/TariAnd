package control;

import java.util.ArrayList;

import model.Award;

public class AwardManager {
	ArrayList<Award> listAward;
	
	public void createAward(){
		listAward = new ArrayList<Award>();
		
		//list award juga hardcode ae. soalnya kan sedikit. paling 10 biji gitu...
		listAward.add(new Award(1, "Menang Quiz", "Pemain sudah memenangkan quiz setidaknya sekali"));
		
	}
}
