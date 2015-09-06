package com.github.rayboot.tf_plus.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BookDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("时光书详情");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFabClick(View view) {
        TempActivity.open(this, "评论列表");
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btnTimeList:
                TempActivity.open(this, "时光列表");
                break;
            case R.id.btnPOD:
                TempActivity.open(this, "POD预览");
                break;
            case R.id.llViewTimes:
                break;
            case R.id.llCollectTimes:
                break;
            case R.id.llType:
                BookStoreActivity.open(this, 0);
                break;
            case R.id.llCommentTimes:
                TempActivity.open(this, "评论列表");
                break;
            case R.id.llFriend:
                TempActivity.open(this, "用户个人中心");
                break;
            case R.id.tvDesc:
            case R.id.btnDescMore:
                TempActivity.open(this, "图书描述信息页面");
                break;
            case R.id.tvAuthorDesc:
            case R.id.btnAuthorMore:
                TempActivity.open(this, "作者简介");
                break;
            case R.id.tvComment:
            case R.id.btnCommentMore:
                TempActivity.open(this, "评论列表");
                break;
            case R.id.moreBook1:
            case R.id.moreBook2:
            case R.id.moreBook3:
                break;
        }

    }
}
