package com.github.rayboot.tf_plus.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.GroupObj;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GroupCreateActivity extends AppCompatActivity {
    int type = GroupObj.TYPE_FRIEND;
    @Bind(R.id.etTitle)
    EditText mEtTitle;
    @Bind(R.id.etDesc)
    EditText mEtDesc;
    @Bind(R.id.llPrivate)
    LinearLayout mLlPrivate;
    @Bind(R.id.llLocation)
    LinearLayout mLlLocation;
    @Bind(R.id.btnBaby)
    Button mBtnBaby;
    @Bind(R.id.btnAdd)
    Button mBtnAdd;

    public static void open(Context context, int type) {
        Intent intent = new Intent(context, GroupCreateActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);
        ButterKnife.bind(this);
        type = getIntent().getIntExtra("type", GroupObj.TYPE_FRIEND);
        mBtnBaby.setVisibility(View.GONE);

        switch (type) {
            case GroupObj.TYPE_FRIEND:
                mEtTitle.setHint("朋友圈名称");
                mBtnAdd.setText("邀请好友");
                break;
            case GroupObj.TYPE_BABY:
                mEtTitle.setHint("亲子圈名称");
                mBtnBaby.setVisibility(View.VISIBLE);
                mBtnAdd.setText("邀请家人");
                break;
            case GroupObj.TYPE_STUDENT:
                mEtTitle.setHint("同学圈名称");
                mBtnAdd.setText("邀请同学");
                break;
            case GroupObj.TYPE_STAR:
                mEtTitle.setHint("明星圈名称");
                mBtnAdd.setText("邀请好友");
                break;
            case GroupObj.TYPE_FAMILY:
                mEtTitle.setHint("家族圈名称");
                mBtnAdd.setText("邀请好友");
                break;
            case GroupObj.TYPE_COM:
                mEtTitle.setHint("企业圈名称");
                mBtnAdd.setText("邀请好友");
                break;
        }

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
