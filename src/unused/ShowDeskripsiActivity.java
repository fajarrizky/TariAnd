package unused;

import com.example.tariand.R;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShowDeskripsiActivity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View FragView = inflater.inflate(R.layout.activity_show_deskripsi,
				container, false);
		return FragView;

	}

}
