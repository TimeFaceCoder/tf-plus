package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.rayboot.tf_plus.R;

public class EventCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create);
    }

    public void onFabClick(View view) {
        startActivity(new Intent(this, EventListActivity.class));
    }
}
