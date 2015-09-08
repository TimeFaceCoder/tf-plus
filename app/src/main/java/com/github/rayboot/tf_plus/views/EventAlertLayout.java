package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.EventContentActivity;
import com.github.rayboot.tf_plus.activities.EventListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class EventAlertLayout extends FrameLayout {
    @Bind(R.id.ivUserLogo)
    SimpleDraweeView mIvUserLogo;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvTime)
    TextView mTvTime;
    @Bind(R.id.tvUserName)
    TextView mTvUserName;
    @Bind(R.id.tvState)
    TextView mTvState;
    @Bind(R.id.main)
    LinearLayout mMain;
    @Bind(R.id.btnMore)
    TextView mBtnMore;

    public EventAlertLayout(Context context) {
        super(context);
        init();
    }

    public EventAlertLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventAlertLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EventAlertLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_event_alert, this, true);
        ButterKnife.bind(this);

        mMain.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EventContentActivity.class));
            }
        });

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EventListActivity.class));
            }
        });
    }
}
