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
		listQuestion.add(new Question(1, "Tari Gambyong berasal dari Provinsi Sumatera Utara", true));
		
	}
}
