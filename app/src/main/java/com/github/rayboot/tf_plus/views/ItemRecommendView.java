package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.FrameLayout;
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
public class ItemRecommendView extends FrameLayout {


    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvSubTitle)
    TextView mTvSubTitle;
    @Bind(R.id.btnMore)
    Button mBtnMore;
    @Bind(R.id.left)
    CommonView mLeft;
    @Bind(R.id.right)
    CommonView mRight;
    @Bind(R.id.ivMainLogo)
    SimpleDraweeView mIvMainLogo;

    public ItemRecommendView(Context context) {
        super(context);
    }

    public ItemRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ItemRecommendView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_recommend, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(Object left, Object right) {
        mLeft.bindItem(left);
        mRight.bindItem(right);
        if (left instanceof BookObj) {
            mTvTitle.setText("他们也在读");
            mTvSubTitle.setText("看看朋友们都喜欢时光流影的什么");
        } else if (left instanceof GroupObj) {
            mTvTitle.setText("与好友同圈");
            mTvSubTitle.setText("看看朋友们都喜欢时光流影的什么");
        } else if (left instanceof GameObj) {
            mTvTitle.setText("与好友同乐");
            mTvSubTitle.setText("看看朋友们都喜欢在玩神马游戏");
        }
    }
}