package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/8.
 * email : sy0725work@gmail.com
 */
public class MessageView extends FrameLayout {

    @Bind(R.id.avatar)
    AvatarLayout mAvatar;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvContent)
    TextView mTvContent;
    @Bind(R.id.ivPhoto)
    ImageView mIvPhoto;
    @Bind(R.id.dashboard)
    DashboardLayout mDashboard;

    public MessageView(Context context) {
        super(context);
        init();
    }

    public MessageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MessageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MessageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_message_1, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem() {

    }
}
