package control;

import java.util.ArrayList;

import android.util.Log;

import model.Question;

public class QuestionManager {
	ArrayList<Question> listQuestion;
	
	public QuestionManager(){
		createQuestion();
	}
	
	private void createQuestion(){
		listQuestion = new ArrayList<Question>();

		//question nya bikin sendiri yak. hardcode ae.
		listQuestion.add(new Question(1, "Tari Kecak adalah tarian tradisional yang berasal dari Provinsi Bali.", true));
		listQuestion.add(new Question(2, "Salah satu tarian tradisional yang berasal dari daerah Jawa Barat adalah Tari Tor-Tor.", false));
		listQuestion.add(new Question(3, "Tari Gambyong berasal dari Provinsi Sumatera Utara.", true));
		listQuestion.add(new Question(4, "Tidak ada tarian tradisional yang berasal dari Provinsi Bali.", false));
		listQuestion.add(new Question(5, "Tari Pendet menceritakan tentang dewi-dewi yang turun dari kayangan ke bumi.", true));
		listQuestion.add(new Question(6, "Tari Pendet adalah tarian yang dibawakan oleh satu orang penari.", false));
		listQuestion.add(new Question(7, "Pada Tari Pendet, penarinya masing-masing membawa sesajian dan mengenakan pakaian upacara.", true));
		listQuestion.add(new Question(8, "Tari Saman adalah salah satu tarian yang berasal dari D.I Yogyakarta.", false));
		listQuestion.add(new Question(9, "Tari Saman merupakan media untuk menyampaikan kekecewaan terhadap suatu hal.", false));
		listQuestion.add(new Question(10, "Tari Pendet berasal dari Bali.", true));
		listQuestion.add(new Question(11, "Tari Tortor berasal dari Sumatera Utara.", true));
		listQuestion.add(new Question(12, "Salah satu tarian yang berasal dari Jawa Tengah adalah tari Gambyong.", true));
		listQuestion.add(new Question(13, "Tari Piring berasal dari Minangkabau.", true));
		listQuestion.add(new Question(14, "Tari Jaipong berasal dari Banten.", false));
		listQuestion.add(new Question(15, "Tari Maengket berasal dari Sulawesi Tenggara.", false));
		listQuestion.add(new Question(16, "Tari Seudati adalah salah satu tarian dari Aceh.", true));
		listQuestion.add(new Question(17, "Salah satu tarian dari Papua Barat adalah tari Perang Papua.", true));
		listQuestion.add(new Question(18, "Tari Jepen Berasal dari Kalimantan Barat.", false));
		listQuestion.add(new Question(19, "Tari Hudoq Berasal dari Kalimantan Barat.", false));
		listQuestion.add(new Question(20, "Tarian yang berasal dari Sulawesi Utara salah satunya adalah tari Katrili.", true));
		listQuestion.add(new Question(21, "Tari Laweut berasal dari Jambi.", false));
		listQuestion.add(new Question(22, "Tari Pakarena berasal dari Sulawesi Tengah.", false));
		listQuestion.add(new Question(23, "Tari Saman, Seudati, dan Tortor adalah tarian yang berasal dari Aceh.", false));
		listQuestion.add(new Question(24, "Ciri khas dari tari Kecak adalah seruan \"cak\" dari para penarinya.", true));
		listQuestion.add(new Question(25, "Tari Tortor pada awalnya merupakan tarian yang berhubungan dengan roh-roh.", true));
		listQuestion.add(new Question(26, "Kendang dan gong adalah instrumen yang digunakan dalam tari Gambyong.", true));
		listQuestion.add(new Question(27, "Jumlah penari pada tari Piring harus genap", false));
		listQuestion.add(new Question(28, "Tari Maengket terdiri dari 2 babak.", false));
		listQuestion.add(new Question(29, "Ciri dari Tari Seudati adalah adanya 2 kelompok yang saling bersaing.", true));
		listQuestion.add(new Question(30, "Tari Perang Papua melambangkan kegagahan dan perjuangan bekas penjajah.", false));
		listQuestion.add(new Question(31, "Tari Jepen adalah perpaduan dari budaya kerajaan Kutai, kerajaan Majapahit, dan agama Islam.", false));
		listQuestion.add(new Question(32, "Gerakan menghentakkan kaki dengan tumit serta mengibaskan tangan bermakna mengusir hama dari padi.", true));
		listQuestion.add(new Question(33, "Tari katrili termasuk tari tradisional yang sifatnya kerakyatan.", false));
		listQuestion.add(new Question(34, "Tari  Laweut berasal dari kata Selawat, yaitu suatu sanjungan yang ditujukan kepada junjungan Nabi Muhammad SAW.", true));
		listQuestion.add(new Question(35, "Drum dan gitar adalah instrumen yang digunakan dalam Tari Pakarena.", false));
		listQuestion.add(new Question(36, "Tari Piring melambangkan rasa bersyukur kepada Tuhan atas karunia yang diberikan.", true));
		listQuestion.add(new Question(37, "Tari Kecak diciptakan pada tahun 1830-an.", false));
		listQuestion.add(new Question(38, "Tari Saman dipimpin oleh seorang pemimpin yang disebut Syech.", true));
		listQuestion.add(new Question(39, "Tari Perang Papua dimainkan oleh 14 laki-laki dan 2 perempuan.", false));
		listQuestion.add(new Question(40, "Para penari duduk melingkar pada Tari Kecak.", true));
		
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
