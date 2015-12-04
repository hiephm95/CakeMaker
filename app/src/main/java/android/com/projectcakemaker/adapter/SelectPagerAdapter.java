package android.com.projectcakemaker.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.com.projectcakemaker.fragment.WeddingCakeFragment;
import android.com.projectcakemaker.fragment.BirthDayCakeFragment;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by hoanghiep on 03/12/2015.
 */
public class SelectPagerAdapter extends FragmentPagerAdapter {
    public SelectPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new WeddingCakeFragment();
            case 1:
                return new BirthDayCakeFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Wedding";
            case 1:
                return "BirthDay";
        }
        return null;
    }
}
