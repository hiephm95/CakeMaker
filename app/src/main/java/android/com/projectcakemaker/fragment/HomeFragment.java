package android.com.projectcakemaker.fragment;


import android.app.Activity;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.com.projectcakemaker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View root;
    ScreenChangeListener screenChangeListener;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_home, container, false);
        }
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        screenChangeListener.setTitleMenu("Home");
        screenChangeListener.setIconActionLeft(R.mipmap.ic_menu);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        screenChangeListener = (ScreenChangeListener) activity;
    }

}
