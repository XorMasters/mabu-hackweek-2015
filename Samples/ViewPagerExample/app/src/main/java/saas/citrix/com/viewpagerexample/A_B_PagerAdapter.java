package saas.citrix.com.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class A_B_PagerAdapter extends FragmentPagerAdapter {

    public A_B_PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
