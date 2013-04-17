package control;

import java.util.ArrayList;

import model.Question;

public class QuestionManager {
	ArrayList<Question> listQuestion;
	
	public void createQuestion(){
		listQuestion = new ArrayList<Question>();

		//question nya bikin sendiri yak. hardcode ae.
		listQuestion.add(new Question(1, "Tari Kecak adalah tarian tradisional yang berasal dari Provinsi Bali", true));
		listQuestion.add(new Question(2, "Salah satu tarian tradisional yang berasal dari daerah Jawa Barat adalah Tari Tor-Tor", false));
		listQuestion.add(new Question(3, "Tari Gambyong berasal dari Provinsi Sumatera Utara", true));
		listQuestion.add(new Question(4, "Tidak ada tarian tradisional yang berasal dari Provinsi Bali", false));
		listQuestion.add(new Question(5, "question 5", true));
		listQuestion.add(new Question(6, "question 6", true));
		listQuestion.add(new Question(7, "question 7", true));
		listQuestion.add(new Question(8, "question 8", true));
		listQuestion.add(new Question(9, "question 9", true));
		listQuestion.add(new Question(10, "question 10", true));
		listQuestion.add(new Question(11, "question 11", true));
		listQuestion.add(new Question(12, "question 12", true));
		listQuestion.add(new Question(13, "question 13", true));
		listQuestion.add(new Question(14, "question 14", true));
		listQuestion.add(new Question(15, "question 15", true));
		listQuestion.add(new Question(16, "question 16", true));
		listQuestion.add(new Question(17, "question 17", true));
		listQuestion.add(new Question(18, "question 18", true));
		listQuestion.add(new Question(19, "question 19", true));
		listQuestion.add(new Question(20, "question 20", true));
		
	}
	
	public ArrayList<Question> getForQuiz(){
		ArrayList<Question> result = new ArrayList<Question>();
		int i = 0;
		int rdm = (int) (1+Math.random()*listQuestion.size());
		while(i < 10){
			result.add(listQuestion.get(rdm));
		}
		return result;
	}
}
