package android.com.projectcakemaker.fragment;


import android.app.Activity;
import android.com.projectcakemaker.adapter.SelectPagerAdapter;
import android.com.projectcakemaker.interfaces.ScreenChangeListener;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.com.projectcakemaker.R;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {



    View root;
    ScreenChangeListener screenChangeListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_product, container, false);
            TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs_layout);
            ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewPager);

            viewPager.setAdapter(new SelectPagerAdapter(getFragmentManager()));
            tabLayout.setupWithViewPager(viewPager);
        }
        return root;
    }


    @Override
    public void onResume() {
        super.onResume();

        screenChangeListener.setTitleMenu("Product");
        screenChangeListener.setIconActionLeft(R.mipmap.ic_menu);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        screenChangeListener = (ScreenChangeListener) activity;
    }


}
