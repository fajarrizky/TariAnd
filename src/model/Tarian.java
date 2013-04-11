package model;

public class Tarian {
	private int id;
	private String name;
	private String location;
	private String description;

	private String[] imageURL;
	private String videoURL;

	private boolean isBookmark;

	public Tarian(int id, String name){
		setID(id);
		setName(name);
	}
	
	public int getId(){
		return this.id;
	}

	public void setID(int input){
		this.id = input;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String input){
		this.name = input;
	}
	
	public String getLocation(){
		return this.location;
	}

	public void setLocation(String input){
		this.location = input;
	}
	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String input){
		this.description = input;
	}
	
	public boolean isBookmarked(){
		return this.isBookmark;
	}

	public void setBookmark(boolean bookmark){
		this.isBookmark = bookmark;
	}

	public String[] getImageURL() {
		return imageURL;
	}

	public void setImageURL(String[] imageURL) {
		this.imageURL = imageURL;
	}

	
	public String getVideoURL() {
		return videoURL;
	}

	
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
}
