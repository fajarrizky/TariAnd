package control;

import java.util.ArrayList;
import java.util.ListIterator;

import model.Tarian;

public class TarianManager {
	ArrayList<Tarian> listTarian;

	public TarianManager(){
		listTarian = new ArrayList<Tarian>();
	}

	//niatnya ini buat ngeretrieve dari database, masukin semua tarian ke list.
	public void retrieve(){

	}

	
	//yang ini buat nyari dari nama
	public ArrayList<Tarian> searchByName(String targetName){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.getName().equals(targetName)){
				target.add(temp);
			}
		}
		return target;
	}


	//yang ini buat nyari dari lokasi
	public ArrayList<Tarian> searchByLocation(String targetLocation){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.getLocation().equals(targetLocation)){
				target.add(temp);
			}
		}
		return target;
	}

	//yang ini buat nyari yang udah d bookmark ae
	public ArrayList<Tarian> getBookmarkedTarian(){
		ArrayList<Tarian> target = new ArrayList<Tarian>();

		ListIterator<Tarian> MainIterator = listTarian.listIterator();
		while(MainIterator.hasNext()){
			Tarian temp = MainIterator.next();
			if(temp.isBookmarked()){
				target.add(temp);
			}
		}
		return target;
	}
}
