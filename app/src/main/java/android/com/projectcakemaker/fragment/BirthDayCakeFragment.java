package android.com.projectcakemaker.fragment;


import android.app.Fragment;
import android.com.projectcakemaker.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BirthDayCakeFragment extends Fragment {


    public BirthDayCakeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cake_birthday, container, false);
    }

}
