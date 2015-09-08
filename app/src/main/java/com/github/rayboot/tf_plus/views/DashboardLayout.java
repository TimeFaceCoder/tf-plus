package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.BookDetailActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class DashboardLayout extends LinearLayout {
    @Bind(R.id.tvBookName)
    TextView mTvBookName;
    @Bind(R.id.btnEdit)
    ImageButton mBtnEdit;
    @Bind(R.id.btnDelete)
    ImageButton mBtnDelete;
    @Bind(R.id.btnLike)
    ImageButton mBtnLike;
    @Bind(R.id.btnComment)
    ImageButton mBtnComment;
    @Bind(R.id.btnShare)
    ImageButton mBtnShare;

    public DashboardLayout(Context context) {
        super(context);
        init();
    }

    public DashboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DashboardLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DashboardLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_dashboard, this, true);
        ButterKnife.bind(this);


        mTvBookName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), BookDetailActivity.class));
            }
        });
        mBtnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "发布时光\n编辑页面");
            }
        });
        mBtnDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "删除该时光", Snackbar.LENGTH_SHORT).setAction("撤销", null).show();
            }
        });
        mBtnShare.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "转摘功能\n相当于时光流影内部分享该时光\n如果发布者选择付费转摘，则用户在打印该内容时，需向原作者支付费用");
            }
        });
        mBtnComment.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "评论列表页面");
            }
        });
        mBtnLike.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "赞 或 不赞", Snackbar.LENGTH_SHORT).show();
            }
        });


    }
}
