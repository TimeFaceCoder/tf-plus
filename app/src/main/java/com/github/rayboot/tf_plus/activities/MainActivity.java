package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;
import com.github.rayboot.tf_plus.models.MessageObj;
import com.github.rayboot.tf_plus.models.UserObj;
import com.github.rayboot.tf_plus.views.EventAlertLayout;
import com.github.rayboot.tf_plus.views.ItemADView;
import com.github.rayboot.tf_plus.views.ItemRecommendView;
import com.github.rayboot.tf_plus.views.ItemRecommendView1;
import com.github.rayboot.tf_plus.views.ItemRecommendView2;
import com.github.rayboot.tf_plus.views.MessageView;

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
    @Bind(R.id.ad)
    ItemADView mAd;
    @Bind(R.id.eventAlert)
    EventAlertLayout mEventAlert;
    @Bind(R.id.recommend11)
    ItemRecommendView1 mRecommend11;
    @Bind(R.id.recommend12)
    ItemRecommendView1 mRecommend12;
    @Bind(R.id.recommend13)
    ItemRecommendView1 mRecommend13;
    @Bind(R.id.recommend21)
    ItemRecommendView2 mRecommend21;
    @Bind(R.id.recommend22)
    ItemRecommendView2 mRecommend22;
    @Bind(R.id.recommend23)
    ItemRecommendView2 mRecommend23;
    @Bind(R.id.recommend24)
    ItemRecommendView2 mRecommend24;
    @Bind(R.id.recommend01)
    ItemRecommendView mRecommend01;
    @Bind(R.id.recommend02)
    ItemRecommendView mRecommend02;
    @Bind(R.id.recommend03)
    ItemRecommendView mRecommend03;
    @Bind(R.id.messageView)
    MessageView mMessageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mTabLayout.addTab(mTabLayout.newTab().setText("动态"));
        mTabLayout.addTab(mTabLayout.newTab().setText("书架"));
        mTabLayout.addTab(mTabLayout.newTab().setText("个人中心"));

        mRecommend11.bindItem(BookObj.getAny(), BookObj.getAny());
        mRecommend12.bindItem(GroupObj.getAny(), GroupObj.getAny());
        mRecommend13.bindItem(GameObj.getAny(), GameObj.getAny());

        mRecommend21.bindItem(BookObj.getAny());
        mRecommend22.bindItem(GroupObj.getAny());
        mRecommend23.bindItem(GameObj.getAny());
        mRecommend24.bindItem(UserObj.getAny());

        mRecommend01.bindItem(BookObj.getAny(), BookObj.getAny());
        mRecommend02.bindItem(GroupObj.getAny(), GroupObj.getAny());
        mRecommend03.bindItem(GameObj.getAny(), GameObj.getAny());

        mMessageView.bindItem(MessageObj.getAny());

    }

    public void onFabClick(View view) {
        int[] startingLocation = new int[2];
        view.getLocationOnScreen(startingLocation);
        startingLocation[0] += view.getWidth() / 2;
        AddActivity.open(this, true, true, true, startingLocation);
        overridePendingTransition(0, 0);
    }

    public void onBtnClick(View view) {
        if (view.getId() == R.id.btnAll) {
            startActivity(new Intent(this, GroupListActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            startActivity(new Intent(this, SearchActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
