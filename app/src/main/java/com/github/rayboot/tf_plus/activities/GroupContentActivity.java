package com.github.rayboot.tf_plus.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        } else if (id == android.R.id.home) {
            this.finish();
        } else if (id == R.id.action_add_event) {
            startActivity(new Intent(this, EventCreateActivity.class));
        } else if (id == R.id.action_add_person) {
            startActivity(new Intent(this, MemberActivity.class));
        } else if (id == R.id.action_group_books) {
            BookStoreActivity.open(this, 2);
        } else if (id == R.id.action_add_book) {
            startActivity(new Intent(this, GroupSelectTimeActivity.class));
        } else if (id == R.id.action_tree) {
            TempActivity.open(this, "查看族谱\n如没有给出提示新建\n如有，则显示族谱的树状结构，可以增加，删除，以及用户关系认领和信息完善等等操作");
        } else if (id == R.id.action_share) {
            TempActivity.open(this, "调用分享功能，可以分享给微信微博，也可以分享给时光流影内部，可作为快速入圈的一种途径");
        } else if (id == R.id.action_exit) {
            Snackbar.make(mRoot, "退出时光圈", Snackbar.LENGTH_SHORT).show();
        } else if (id == R.id.action_fuck) {
            TempActivity.open(this, "举报流程");
        } else if (id == R.id.action_setting) {
            TempActivity.open(this, "设置\n如推送消息\n圈消息是否在首页显示\n等等");
        } else if (id == R.id.action_help) {
            TempActivity.open(this, "帮助\n可以有视频简介，或者文字简介。主要是关于时光圈的");
        } else if (id == R.id.action_big_thing) {
            TempActivity.open(this, "还没想好，到底是制作企业大事记的入口，还是浏览企业大事记的入口。");
        } else if (id == R.id.action_com_verify) {
            TempActivity.open(this, "企业认证流程，上传营业执照或者证明你为该企业时光圈官方用户的凭证\n一旦认证成功，则直接获取超级管理员权限，超级管理员可以不付费转载圈内信息，只有超级管理员才可以发布企业大事记的信息等等权限。");
        } else if (id == R.id.action_contacts) {
            TempActivity.open(this, "查看通讯录\n如没有上传则引导上传\n如已经上传则列表展示通讯录内容\n该页面针对普通用户只能认领自己本人和完善个人信息\n增删改只有管理员或群主有权限");
        } else if (id == R.id.action_star_verify) {
            TempActivity.open(this, "明星圈认证。\n具体认证完后续没想好");
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
