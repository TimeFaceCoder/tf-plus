package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/9.
 * email : sy0725work@gmail.com
 */
public class ItemGroup extends LinearLayout {

    @Bind(R.id.ivLogo)
    ImageView mIvLogo;
    @Bind(R.id.tvTime)
    TextView mTvTime;
    @Bind(R.id.tvCount)
    TextView mTvCount;
    @Bind(R.id.root)
    LinearLayout mRoot;

    public ItemGroup(Context context) {
        super(context);
        init();
    }

    public ItemGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_group, this, true);
        ButterKnife.bind(this);
    }
}
