package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupContentActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.root)
    CoordinatorLayout mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_content);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group_content, menu);
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
        } else if (id == R.id.action_add_event){
            startActivity(new Intent(this, EventCreateActivity.class));
        }else if (id == R.id.action_add_person) {
            startActivity(new Intent(this, MemberActivity.class));
        }else if (id == R.id.action_group_books) {
            BookStoreActivity.open(this, 1);
        }else if (id == R.id.action_add_book) {
            startActivity(new Intent(this, GroupSelectTimeActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFabClick(View view) {
        startActivity(new Intent(this, PublishActivity.class));
    }
    @OnClick(R.id.btnGroupAllEvent)
    public void onGroupAllEventClick(View view) {
        startActivity(new Intent(this, EventListActivity.class));
    }
}
