package com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jhonatanalvarezcaicedo.moviesfeedapp.R;
import com.example.jhonatanalvarezcaicedo.moviesfeedapp.view.adapter.ViewPagerAdapter;

public class BaseActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setTitle(getString(R.string.title_base));

        initComponents();

    }

    private void initComponents() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapter);
    }
}
