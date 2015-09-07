package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;

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
    }
}
