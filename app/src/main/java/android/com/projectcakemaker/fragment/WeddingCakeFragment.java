package android.com.projectcakemaker.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.com.projectcakemaker.R;
import android.com.projectcakemaker.adapter.RecyclerViewAdapter;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.com.projectcakemaker.model.Picture;
import android.com.projectcakemaker.model.Product;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeddingCakeFragment extends Fragment implements FindCallback<Product> {
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

            Product.getListProduct(this);


        }
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void done(List<Product> objects, ParseException e) {
        if (e == null) {
            for (final Product p : objects) {
                try {
                    p.setPictureList(p.getPictureRelation().getQuery().find());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
//                p.getPictureRelation().getQuery().findInBackground(new FindCallback<Picture>() {
//                    @Override
//                    public void done(List<Picture> objects, ParseException e) {
//                        p.setPictureList(objects);
//                        Log.d("URL:", p.getPicturesList().get(0).getFile().getUrl());
//                    }
//                });
            }
            mAdapter = new RecyclerViewAdapter(objects);
            mRecyclerView.setAdapter(mAdapter);
            setOnItemClick();
        } else {
            Log.d("Error:", e.toString());
        }
    }

    private void setOnItemClick() {
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
