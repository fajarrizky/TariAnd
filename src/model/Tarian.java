package model;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.tariand.MainActivity;


public class Tarian implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8781724562703465639L;
	private int id;
	private String name;
	private String location;
	private String description;

	private String imageURL;
	private String videoURL;

	private boolean isBookmark;

	// tambahan variabel dari iterasi 2
	private ArrayList<Comment> comments;
	private double rate;
	private int nrate;
	private boolean published;

	public Tarian(){
		
	}
	//
	public Tarian(int id, String name) {
		setID(id);
		setName(name);
		comments = new ArrayList<Comment>();
		isBookmark = MainActivity.shpr.getBoolean("" + this.getName(), false);
	}

	public int getId() {
		return this.id;
	}

	public void setID(int input) {
		this.id = input;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String input) {
		this.name = input;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String input) {
		this.location = input;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String input) {
		this.description = input;
	}

	public boolean isBookmarked() {
		// isBookmark = MainActivity.shpr.getBoolean(""+this.getName(), false);
		return this.isBookmark;
	}

	public void setBookmark(boolean bookmark) {
		this.isBookmark = bookmark;
		MainActivity.shedtr.putBoolean("" + this.name, this.isBookmark);
		MainActivity.shedtr.commit();
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public double getRate() {
		return this.rate;
	}

	public void addRate(double inp) {
		if (nrate == 0) {
			nrate = 1;
			rate = inp;
		} else {
			double sum = rate * nrate;
			nrate++;
			sum = (sum + inp) / nrate;
		}
	}

	public void addComment(Comment newComment) {
		comments.add(newComment);
	}

	public ArrayList<Comment> getComments(){
		return this.comments;
				
	}

	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

}
