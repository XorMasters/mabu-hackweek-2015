package saas.citrix.com.viewpagerexample;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private A_B_PagerAdapter a_b_pagerAdapter;
    private ViewPager a_b_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        //Toolbar will now take on default Action Bar characteristics
        toolbar.setTitle("");

        toolbar.findViewById(R.id.fragment_a_button).setOnClickListener(this);
        toolbar.findViewById(R.id.fragment_b_button).setOnClickListener(this);

        a_b_pagerAdapter = new A_B_PagerAdapter(getSupportFragmentManager());
        a_b_pager = (ViewPager)findViewById(R.id.pager);
        a_b_pager.setAdapter(a_b_pagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fragment_a_button:
                a_b_pager.setCurrentItem(0);
                break;
            case R.id.fragment_b_button:
                a_b_pager.setCurrentItem(1);
                break;
        }
    }

    private class MainTabListener implements ActionBar.TabListener {

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.d("findme", "onTabSelected");
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.d("findme", "onTabUnselected");
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            Log.d("findme", "onTabReselected");
        }
    }
}
