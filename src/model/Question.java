package model;

public class Question {
	private int id;
	private String question;
	private boolean correctAnswer;
	
	public Question(int id, String question, boolean answer){
		this.setId(id);
		this.setQuestion(question);
		this.setCorrectAnswer(answer);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
