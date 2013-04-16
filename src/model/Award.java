package model;

public class Award {
	private int id;
	private String name;
	private String description;
	private boolean isAchieved;
	
	
	
	public Award(int id, String name, String description){
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
		setAchieved(false);
	}
	
	public void setAsAchieved(){
		this.setAchieved(true);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAchieved() {
		return isAchieved;
	}

	public void setAchieved(boolean isAchieved) {
		this.isAchieved = isAchieved;
	}
	
	
}
