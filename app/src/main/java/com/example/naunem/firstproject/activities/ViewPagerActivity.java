package com.example.naunem.firstproject.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.naunem.firstproject.R;
import com.example.naunem.firstproject.adapters.ViewPagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * ViewPagerActivity class
 * Created by naunem on 22/03/2017.
 */

@EActivity(R.layout.activity_viewpager)
public class ViewPagerActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    @ViewById(R.id.viewPager)
    protected ViewPager mViewPager;

    @ViewById(R.id.tabLayout)
    TabLayout mTabLayout;

    @AfterViews
    void init() {
        final TabLayout.Tab home = mTabLayout.newTab();
        final TabLayout.Tab favorite = mTabLayout.newTab();
        final TabLayout.Tab setting = mTabLayout.newTab();
        home.setIcon(R.drawable.ic_home_pink_400_24dp);
        favorite.setIcon(R.drawable.ic_favorite_white_24dp);
        setting.setIcon(R.drawable.ic_settings_white_24dp);
        home.setText("Home");
        favorite.setText("Favorite");
        setting.setText("Setting");
        mTabLayout.addTab(home, 0);
        mTabLayout.addTab(favorite, 1);
        mTabLayout.addTab(setting, 2);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setOnTabSelectedListener(this);

        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        home.setIcon(R.drawable.ic_home_pink_400_24dp);
                        favorite.setIcon(R.drawable.ic_favorite_white_24dp);
                        setting.setIcon(R.drawable.ic_settings_white_24dp);
                        break;
                    case 1:
                        home.setIcon(R.drawable.ic_home_white_24dp);
                        favorite.setIcon(R.drawable.ic_favorite_pink_400_24dp);
                        setting.setIcon(R.drawable.ic_settings_white_24dp);
                        break;
                    case 2:
                        home.setIcon(R.drawable.ic_home_white_24dp);
                        favorite.setIcon(R.drawable.ic_favorite_white_24dp);
                        setting.setIcon(R.drawable.ic_settings_pink_400_24dp);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
