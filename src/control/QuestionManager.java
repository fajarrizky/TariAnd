package control;

import java.util.ArrayList;
import java.util.ListIterator;

import android.util.Log;

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
		listQuestion.add(new Question(21, "question 21", true));
		listQuestion.add(new Question(22, "question 22", true));
		listQuestion.add(new Question(23, "question 23", true));
		listQuestion.add(new Question(24, "question 24", true));
		listQuestion.add(new Question(25, "question 25", true));
		listQuestion.add(new Question(26, "question 26", true));
		listQuestion.add(new Question(27, "question 27", true));
		listQuestion.add(new Question(28, "question 28", true));
		listQuestion.add(new Question(29, "question 29", true));
		listQuestion.add(new Question(30, "question 30", true));
		listQuestion.add(new Question(31, "question 31", true));
		listQuestion.add(new Question(32, "question 32", true));
		listQuestion.add(new Question(33, "question 33", true));
		listQuestion.add(new Question(34, "question 34", true));
		listQuestion.add(new Question(35, "question 35", true));
		listQuestion.add(new Question(36, "question 36", true));
		listQuestion.add(new Question(37, "question 37", true));
		listQuestion.add(new Question(38, "question 38", true));
		listQuestion.add(new Question(39, "question 39", true));
		listQuestion.add(new Question(40, "question 40", true));
		
	}
	
	public ArrayList<Question> getForQuiz(){
		ArrayList<Question> result = new ArrayList<Question>();
		int n = 0;
		int[] i = new int[10];
		for (int j = 0; j < i.length; j++) {
			i[j] = -1;
		}
		
		int rdm = (int) (Math.random()*listQuestion.size());
		
		while(n < 10){
			if(checkList(i, rdm)){
				Log.d("rdm = "+rdm, ""+"masuk");
				result.add(listQuestion.get(rdm));
				i[n] = rdm;
				n++;
			} else {
				Log.d("rdm = "+rdm, ""+"gak masuk");
			}
			rdm = (int) (Math.random()*listQuestion.size());
		}
		return result;
	}
	
	private boolean checkList(int[] arr, int id){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == id){
				return false;
			}
		}
		return true;
	}
	
	public void cekcobacoba(ArrayList<Question> haa){
		for (Question question : haa) {
			Log.d("ID = "+question.getId(), question.getQuestion());
		}
		
	}
	
	public Question getOne(){
		int i = (int) (Math.random()*listQuestion.size());
		return listQuestion.get(i);
	}
}
