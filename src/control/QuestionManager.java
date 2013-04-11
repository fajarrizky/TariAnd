package control;

import java.util.ArrayList;

import model.Question;

public class QuestionManager {
	ArrayList<Question> listQuestion;
	
	public void createQuestion(){
		listQuestion = new ArrayList<Question>();

		//question nya bikin sendiri yak. hardcode ae.
		listQuestion.add(new Question(1, "Apa?", true));
		listQuestion.add(new Question(2, "gimana?", true));
	}
}
