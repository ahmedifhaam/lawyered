package com.mit.lawyered.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mit.lawyered.R;
import com.mit.lawyered.view.fragments.LegalPartyFragment;
import com.mit.lawyered.view.fragments.PublicUserFragment;

public class TabActivitySignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout_signup);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager_signup);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),TabActivitySignUp.this);
        vp.setAdapter(pagerAdapter);

        TabLayout tl = (TabLayout) findViewById(R.id.tab_layout_signup);
        tl.setupWithViewPager(vp);

        for (int i = 0; i < tl.getTabCount(); i++) {
            TabLayout.Tab tab = tl.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));

        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

            /*if (id == R.id.action_settings) {
                return true;
            }*/

        return super.onOptionsItemSelected(item);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        String tabTitles[] = new String[]{"Public User", "Legal Party"};
        Context context;

        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new PublicUserFragment();
                case 1:
                    return new LegalPartyFragment();

            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }

        public View getTabView(int position) {
            View tab = LayoutInflater.from(TabActivitySignUp.this).inflate(R.layout.custom_tab_signup, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_tab_title);
            tv.setText(tabTitles[position]);
            return tab;
        }
    }
    
}
