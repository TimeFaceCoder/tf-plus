package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.GroupContentActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.GroupObj;
import com.github.rayboot.tf_plus.models.UserObj;
import com.github.rayboot.tf_plus.utils.PicUtil;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class AvatarLayout extends RelativeLayout {
    @Bind(R.id.ivImg)
    RatioImageView mIvImg;
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

        mIvImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "个人中心");
            }
        });
        mTvName.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "个人中心");
            }
        });
        mTvFrom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupContentActivity.open(getContext(), GroupObj.TYPE_FRIEND);
            }
        });
    }

    public void bindItem(UserObj userObj) {
        mTvName.setText("Rayboot >管理员");
        PicUtil.getPicasso().load(Uri.parse(userObj.image)).into(mIvImg);
    }
}
