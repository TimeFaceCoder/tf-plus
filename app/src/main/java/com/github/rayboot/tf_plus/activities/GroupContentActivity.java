package com.github.rayboot.tf_plus.activities;

import android.content.Context;
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
import com.github.rayboot.tf_plus.models.GroupObj;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupContentActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.root)
    CoordinatorLayout mRoot;
    int type = GroupObj.TYPE_FRIEND;

    public static void open(Context context, int type) {
        Intent intent = new Intent(context, GroupContentActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_content);
        ButterKnife.bind(this);

        type = getIntent().getIntExtra("type", GroupObj.TYPE_FRIEND);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        switch (type) {
            case GroupObj.TYPE_FRIEND:
                getMenuInflater().inflate(R.menu.menu_group_type_friend, menu);
                break;
            case GroupObj.TYPE_BABY:
                getMenuInflater().inflate(R.menu.menu_group_type_baby, menu);
                break;
            case GroupObj.TYPE_STUDENT:
                getMenuInflater().inflate(R.menu.menu_group_type_student, menu);
                break;
            case GroupObj.TYPE_STAR:
                getMenuInflater().inflate(R.menu.menu_group_type_star, menu);
                break;
            case GroupObj.TYPE_FAMILY:
                getMenuInflater().inflate(R.menu.menu_group_type_family, menu);
                break;
            case GroupObj.TYPE_COM:
                getMenuInflater().inflate(R.menu.menu_group_type_com, menu);
                break;
        }
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
