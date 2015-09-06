package com.github.rayboot.tf_plus.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.rayboot.tf_plus.R;

public class GroupCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);
    }

    public void onFabClick(View view) {
        startActivity(new Intent(this, GroupContentActivity.class));
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.llPrivate:
                break;
            case R.id.llLocation:
                break;
            case R.id.llType:
                break;
        }
    }
}
