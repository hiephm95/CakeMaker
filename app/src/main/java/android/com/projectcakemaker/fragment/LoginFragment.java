package android.com.projectcakemaker.fragment;


import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.com.projectcakemaker.MainProductActivity;
import android.com.projectcakemaker.R;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{

    View root;
    ShimmerTextView tvSkip;
    Shimmer shimmer = new Shimmer();
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_login, container, false);
            tvSkip = (ShimmerTextView) root.findViewById(R.id.tvSkip);
            tvSkip.setOnClickListener(this);
            shimmer.start(tvSkip);
        }
        return root;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),MainProductActivity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view, "hello");
        startActivity(intent, options.toBundle());
    }
}
