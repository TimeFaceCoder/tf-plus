package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.TempActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class UploadContactsLayout extends FrameLayout {
    @Bind(R.id.tvReason)
    TextView mTvReason;
    @Bind(R.id.btnSelectFile)
    Button mBtnSelectFile;
    @Bind(R.id.btnMore)
    Button mBtnMore;

    public UploadContactsLayout(Context context) {
        super(context);
        init();
    }

    public UploadContactsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UploadContactsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public UploadContactsLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_upload_contacts, this, true);
        ButterKnife.bind(this);

        mBtnSelectFile.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "查看通讯录页面\n\n如果没有上传引导上传通讯录\n如果已上传则直接展示通讯录");
            }
        });

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "帮助页面\n\n了解上传通讯录的好处以及上传方法");
            }
        });
    }
}
