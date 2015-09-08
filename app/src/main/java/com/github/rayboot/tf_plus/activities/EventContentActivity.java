package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.rayboot.tf_plus.R;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuItem;
import com.shehabic.droppy.DroppyMenuPopup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventContentActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.btnTop)
    Button mBtnTop;
    DroppyMenuPopup droppyMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_content);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initDroppy();

    }

    private void initDroppy() {
        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(this, mBtnTop);
        droppyBuilder.addMenuItem(new DroppyMenuItem("活动"))
                .addMenuItem(new DroppyMenuItem("照片"))
                .addSeparator();

        droppyBuilder.setOnClick(new DroppyClickCallbackInterface() {
            @Override
            public void call(View v, int id) {
                if (id == 1) {
                    TempActivity.open(EventContentActivity.this, "所有该活动内的照片集锦，与快速成书功能整合");
                }
            }
        });

        droppyMenu = droppyBuilder.build();
    }

    @OnClick(R.id.btnTop)
    public void onTopClick(View view) {
        droppyMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_content, menu);
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
        }else if (id == R.id.action_add_person) {
            startActivity(new Intent(this, MemberActivity.class));
        }else if (id == R.id.action_add_book) {
            startActivity(new Intent(this, GroupSelectTimeActivity.class));
        }else if (id == R.id.action_event_books) {
            BookStoreActivity.open(this, 3);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onFabClick(View view) {
        startActivity(new Intent(this, PublishActivity.class));
    }
}
