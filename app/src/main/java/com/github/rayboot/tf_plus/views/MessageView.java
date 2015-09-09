package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.EventContentActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.MessageObj;

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
    @Bind(R.id.tvEvent1)
    TextView mTvEvent1;
    @Bind(R.id.tvEvent2)
    TextView mTvEvent2;
    @Bind(R.id.root)
    LinearLayout mRoot;

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

        mTvEvent1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EventContentActivity.class));
            }
        });

        mTvEvent2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EventContentActivity.class));
            }
        });

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "时光详情页面");
            }
        });
    }

    public void bindItem(MessageObj object) {
        mTvTitle.setText(object.title);
        mTvContent.setText(object.content);
        mAvatar.bindItem(object.author);
    }
}
