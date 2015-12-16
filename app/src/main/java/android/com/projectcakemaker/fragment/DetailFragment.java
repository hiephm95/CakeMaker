package android.com.projectcakemaker.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.com.projectcakemaker.R;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }
    Button btnNextOrder;
    View root;
    ScreenChangeListener screenChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_detail, container, false);
            btnNextOrder = (Button) root.findViewById(R.id.btnNextOrder);
            btnNextOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.main_frame, new OrderFragment());
                    transaction.commit();
                }
            });

        }
        return root;
    }

    

    @Override
    public void onResume() {
        super.onResume();

        screenChangeListener.setTitleMenu("Detail");
        screenChangeListener.setIconActionLeft(R.mipmap.ic_arrow_back);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        screenChangeListener = (ScreenChangeListener) activity;
    }

}
