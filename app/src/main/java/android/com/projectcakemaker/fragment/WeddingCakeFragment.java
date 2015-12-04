package android.com.projectcakemaker.fragment;


import android.app.Fragment;
import android.com.projectcakemaker.R;
import android.com.projectcakemaker.adapter.RecyclerViewAdapter;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.com.projectcakemaker.model.Cake;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeddingCakeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerViewAdapter recyclerViewAdapter;
    private static String LOG_TAG = "RecyclerViewActivity";
    View root;
    ArrayList<Cake> list = new ArrayList<>();
    ScreenChangeListener screenChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_cakewedding, container, false);
            final FrameLayout frameLayout = (FrameLayout) root.findViewById(R.id.dummyfrag_bg);

            mRecyclerView = (RecyclerView) root.findViewById(R.id.dummyfrag_scrollableview);

            //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            mRecyclerView.setHasFixedSize(true);
            list.add(new Cake("AAA", 1));
            list.add(new Cake("AAA", 2));
            list.add(new Cake("AAA", 3));
            list.add(new Cake("AAA", 4));
            list.add(new Cake("AAA", 5));
            list.add(new Cake("AAA", 6));
            list.add(new Cake("AAA", 7));
            mAdapter = new RecyclerViewAdapter(list);
            mRecyclerView.setAdapter(mAdapter);


        }
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new RecyclerViewAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.i(LOG_TAG, " Clicked on Item " + position);
                    }
                });
    }

}
