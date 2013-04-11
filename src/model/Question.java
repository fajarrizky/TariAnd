package model;

public class Question {
	private int id;
	private String question;
	private boolean correctAnswer;
	
	public Question(int id, String question, boolean answer){
		this.id = id;
		this.question = question;
		this.correctAnswer = answer;
	}
}
