package com.github.rayboot.tf_plus.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.adapters.GroupSelectTimeAdapter;
import com.github.rayboot.tf_plus.utils.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.dift.ui.SwipeToAction;

public class GroupSelectTimeActivity extends AppCompatActivity {

    @Bind(R.id.recycler)
    RecyclerView mRecycler;
    GroupSelectTimeAdapter adapter;
    SwipeToAction swipeToAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_select_time);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(layoutManager);

        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecycler.addItemDecoration(itemDecoration);

        adapter = new GroupSelectTimeAdapter();
        mRecycler.setAdapter(adapter);

        swipeToAction = new SwipeToAction(mRecycler, new SwipeToAction.SwipeListener<String>() {
            @Override
            public boolean swipeLeft(String o) {
                displaySnackbar("不喜欢该条时光", "Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                return true;
            }

            @Override
            public boolean swipeRight(String o) {
                displaySnackbar("该条时光入册", null, null);
                return true;
            }

            @Override
            public void onClick(String o) {

                displaySnackbar("修改某条时光", null, null);
            }

            @Override
            public void onLongClick(String o) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group_select_time, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySnackbar(String text, String actionName, View.OnClickListener action) {
        Snackbar snack = Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .setAction(actionName, action);

        View v = snack.getView();
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.WHITE);
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_action)).setTextColor(Color.BLACK);

        snack.show();
    }

    public void onFabClick(View view) {
        TempActivity.open(this, "印刷流程");
    }
}
