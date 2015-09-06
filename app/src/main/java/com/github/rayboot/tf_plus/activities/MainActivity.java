package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.root)
    CoordinatorLayout mRoot;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mTabLayout.addTab(mTabLayout.newTab().setText("动态"));
        mTabLayout.addTab(mTabLayout.newTab().setText("书架"));
        mTabLayout.addTab(mTabLayout.newTab().setText("个人中心"));
    }

    public void onFabClick(View view) {
        int[] startingLocation = new int[2];
        view.getLocationOnScreen(startingLocation);
        startingLocation[0] += view.getWidth() / 2;
        AddActivity.open(this, true, true, true, startingLocation);
        overridePendingTransition(0, 0);
    }

}
