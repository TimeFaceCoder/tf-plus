package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;

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
    }
}
