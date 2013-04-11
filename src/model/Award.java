package model;

public class Award {
	private int id;
	private String name;
	private String description;
	private boolean isAchieved;
	
	public Award(int id, String name, String description){
		this.id = id;
		this.name = name;
		this.description = description;
		isAchieved = false;
	}
	
	public void getAward(){
		this.isAchieved = true;
	}
}
