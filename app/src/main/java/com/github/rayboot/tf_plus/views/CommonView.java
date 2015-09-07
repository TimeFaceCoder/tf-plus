package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class CommonView extends LinearLayout {
    @Bind(R.id.ivImg)
    SimpleDraweeView mIvImg;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvSubTitle)
    TextView mTvSubTitle;
    @Bind(R.id.ivDesc)
    SimpleDraweeView mIvDesc;
    @Bind(R.id.tvDesc)
    TextView mTvDesc;
    @Bind(R.id.llDesc)
    LinearLayout mLlDesc;

    public CommonView(Context context) {
        super(context);
        init();
    }

    public CommonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CommonView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_common, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(Object object) {
        mLlDesc.setVisibility(GONE);
        if (object instanceof BookObj) {
            BookObj item = (BookObj) object;
            mIvImg.setImageURI(Uri.parse(item.image));
            mIvImg.setAspectRatio(1.0f);
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.author.name + " 著");
        } else if (object instanceof GroupObj) {
            GroupObj item = (GroupObj) object;
            mIvImg.setImageURI(Uri.parse(item.image));
            mIvImg.setAspectRatio(1.0f);
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.userCount + "参与其中");
        }else if (object instanceof GameObj) {
            GameObj item = (GameObj) object;
            mIvImg.setAspectRatio(1.0f);
            mIvImg.setImageURI(Uri.parse(item.image));
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.userCount + "参与其中");

            mLlDesc.setVisibility(VISIBLE);
            mIvDesc.setImageURI(Uri.parse(item.friend.image));
            mIvDesc.setAspectRatio(1.0f);
            mTvDesc.setText(item.friendCount + "个好友也在玩");
        }
    }
}
