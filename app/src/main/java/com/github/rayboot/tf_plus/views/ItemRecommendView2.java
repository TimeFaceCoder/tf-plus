package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;
import com.github.rayboot.tf_plus.models.UserObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class ItemRecommendView2 extends LinearLayout {

    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvReason)
    TextView mTvReason;
    @Bind(R.id.btnMore)
    Button mBtnMore;
    @Bind(R.id.ivLogo)
    SimpleDraweeView mIvLogo;
    @Bind(R.id.tvName)
    TextView mTvName;
    @Bind(R.id.btnAdd)
    Button mBtnAdd;

    public ItemRecommendView2(Context context) {
        super(context);
        init();
    }

    public ItemRecommendView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemRecommendView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemRecommendView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_recommend_2, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(Object obj) {
        if (obj instanceof BookObj) {
            BookObj item = (BookObj) obj;
            mTvTitle.setText("可能喜欢");
            mTvReason.setText("好友 非也君 也在看这本书");
            mIvLogo.setAspectRatio(0.75f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof GroupObj) {
            GroupObj item = (GroupObj) obj;
            mTvTitle.setText("推荐圈子");
            mTvReason.setText("好友 非也君 在这个圈里");
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof GameObj) {
            GameObj item = (GameObj) obj;
            mTvTitle.setText("推荐游戏");
            mTvReason.setText("21位好友都在玩这个游戏");
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof UserObj) {
            UserObj item = (UserObj) obj;
            mTvTitle.setText("可能认识");
            mTvReason.setText("与你有共同好友 非也君");
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvName.setText(item.name);
            mBtnAdd.setText("+添加");
        }
    }

}
