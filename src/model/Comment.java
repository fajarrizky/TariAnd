package model;

public class Comment {
	private int idTarian;
	private float eRate;
	private	String userName;
	private String email;
	private String comment;
	
	public Comment(int ID, String usr, String eml, String cmt){
		this.setIdTarian(ID);
		this.setUserName(usr);
		this.setEmail(eml);
		this.setComment(cmt);
	}

	public int getIdTarian() {
		return idTarian;
	}

	public void setIdTarian(int idTarian) {
		this.idTarian = idTarian;
	}

	public float getRate() {
		return eRate;
	}

	public void setRate(float eRate) {
		this.eRate = eRate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
