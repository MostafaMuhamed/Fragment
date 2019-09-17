package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fragment.Fragment.carFragment;
import com.example.fragment.Fragment.foodFragment;
import com.example.fragment.Fragment.footballFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentPagerAdapter fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {
            Fragment [] fragment = new Fragment[]
                    {
                            new carFragment(),
                            new foodFragment(),
                            new footballFragment()
                    };
            @Override
            public Fragment getItem(int position)
            {
                return fragment[position];
            }

            @Override
            public int getCount()
            {
                return fragment.length;
            }
        };

        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_car_red);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_store);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_football_player);
    }
}
