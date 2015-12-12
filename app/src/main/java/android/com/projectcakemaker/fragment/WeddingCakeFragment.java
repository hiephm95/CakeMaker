package android.com.projectcakemaker.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.com.projectcakemaker.R;
import android.com.projectcakemaker.adapter.RecyclerViewAdapter;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.com.projectcakemaker.model.Cake;
import android.com.projectcakemaker.parse.MyTask;
import android.com.projectcakemaker.parse.ProductManager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeddingCakeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerViewAdapter recyclerViewAdapter;
    private static String LOG_TAG = "RecyclerViewActivity";
    View root;
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

            MyTask task = new MyTask();
            try {
                mAdapter = new RecyclerViewAdapter(task.execute().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
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
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        DetailFragment detailFragment = new DetailFragment();
                        transaction.addToBackStack(null);
                        transaction.replace(R.id.main_product, detailFragment).commit();
                    }
                });
    }

}
