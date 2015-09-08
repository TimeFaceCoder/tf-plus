package com.github.rayboot.tf_plus.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookStoreItem;
import com.github.rayboot.tf_plus.utils.SpacesItemDecoration;
import com.github.rayboot.tf_plus.viewhoders.BookStoreViewHolder;
import com.infstory.v7.widget.ListRecyclerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Func2;

public class BookStoreActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.fabBtn)
    FloatingActionButton mFabBtn;
    @Bind(R.id.recycler)
    RecyclerView mRecycler;

    public static void open(Context context, int type) {
        Intent intent = new Intent(context, BookStoreActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        switch (getIntent().getIntExtra("type", 1)) {
            case 0:
                mTabLayout.setVisibility(View.GONE);
                break;
            case 1:
                mTabLayout.addTab(mTabLayout.newTab().setText("我的书架"));
                mTabLayout.addTab(mTabLayout.newTab().setText("全部"));
                mTabLayout.addTab(mTabLayout.newTab().setText("青春"));
                mTabLayout.addTab(mTabLayout.newTab().setText("旅游"));
                mTabLayout.addTab(mTabLayout.newTab().setText("亲子"));
                mTabLayout.addTab(mTabLayout.newTab().setText("青春"));
                mTabLayout.addTab(mTabLayout.newTab().setText("旅游"));
                mTabLayout.addTab(mTabLayout.newTab().setText("亲子"));
                mTabLayout.addTab(mTabLayout.newTab().setText("青春"));
                mTabLayout.addTab(mTabLayout.newTab().setText("旅游"));
                mTabLayout.addTab(mTabLayout.newTab().setText("亲子"));
                mTabLayout.addTab(mTabLayout.newTab().setText("青春"));
                mTabLayout.addTab(mTabLayout.newTab().setText("旅游"));
                break;
            case 2:
                mTabLayout.addTab(mTabLayout.newTab().setText("我的书架"));
                mTabLayout.addTab(mTabLayout.newTab().setText("全部"));
                mTabLayout.addTab(mTabLayout.newTab().setText("活动1"));
                mTabLayout.addTab(mTabLayout.newTab().setText("活动2"));
                mTabLayout.addTab(mTabLayout.newTab().setText("活动3"));
                mTabLayout.addTab(mTabLayout.newTab().setText("活动4"));
                break;
            case 3:
                mTabLayout.addTab(mTabLayout.newTab().setText("我的书架"));
                mTabLayout.addTab(mTabLayout.newTab().setText("活动名称"));
                break;
        }
        ListRecyclerAdapter<BookStoreItem, BookStoreViewHolder> listAdapter = ListRecyclerAdapter.create();
        for (int i = 0; i < 99; i++) {
            listAdapter.getList().add(new BookStoreItem("http://www.timeface.cn/uploads/album/2015/05/18142503_13KSHm.jpg", "我在文博会", "想想"));
        }


        listAdapter.createViewHolder(new Func2<ViewGroup, Integer, BookStoreViewHolder>() {
            @Override
            public BookStoreViewHolder call(ViewGroup viewGroup, Integer integer) {
                return new BookStoreViewHolder(LayoutInflater.from(BookStoreActivity.this).inflate(R.layout.item_book, viewGroup, false)
                        , new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BookStoreActivity.this.startActivity(new Intent(BookStoreActivity.this, BookDetailActivity.class));
                    }
                });
            }
        });
        mRecycler.addItemDecoration(new SpacesItemDecoration(24));

        mRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        mRecycler.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_store, menu);
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
        } else if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
