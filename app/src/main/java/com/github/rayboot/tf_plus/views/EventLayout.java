package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class EventLayout extends FrameLayout {
    @Bind(R.id.ivEventLogo)
    SimpleDraweeView mIvEventLogo;
    @Bind(R.id.tvState)
    TextView mTvState;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvTime)
    TextView mTvTime;
    @Bind(R.id.tvLocation)
    TextView mTvLocation;
    @Bind(R.id.ivUserLogo)
    SimpleDraweeView mIvUserLogo;
    @Bind(R.id.ivState)
    View mIvState;

    public EventLayout(Context context) {
        super(context);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_event, this, true);
        ButterKnife.bind(this);
    }
}
