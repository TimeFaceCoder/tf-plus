package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.UserObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class UserLayout extends LinearLayout {
    @Bind(R.id.ivLogo)
    SimpleDraweeView mIvLogo;
    @Bind(R.id.tvName)
    TextView mTvName;
    @Bind(R.id.root)
    LinearLayout mRoot;

    public UserLayout(Context context) {
        super(context);
        init();
    }

    public UserLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public UserLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_user, this, true);
        ButterKnife.bind(this);

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "个人中心");
            }
        });
    }

    public void bindItem(Object object) {
        if (object instanceof UserObj) {
            mIvLogo.setImageURI(Uri.parse(((UserObj) object).image));
            mTvName.setText(((UserObj) object).name);
        }
    }
}
