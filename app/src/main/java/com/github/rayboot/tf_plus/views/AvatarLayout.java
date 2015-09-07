package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.UserObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class AvatarLayout extends RelativeLayout {
    @Bind(R.id.ivImg)
    SimpleDraweeView mIvImg;
    @Bind(R.id.tvName)
    TextView mTvName;
    @Bind(R.id.tvFrom)
    TextView mTvFrom;
    @Bind(R.id.tvDate)
    TextView mTvDate;

    public AvatarLayout(Context context) {
        super(context);
        init();
    }

    public AvatarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AvatarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AvatarLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_avatar, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(UserObj userObj) {
        mIvImg.setImageURI(Uri.parse(userObj.image));
        mTvName.setText("Rayboot >管理员");
    }
}