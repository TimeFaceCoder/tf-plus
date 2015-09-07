package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class ItemRecommendView1 extends LinearLayout {
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.button)
    Button mButton;
    @Bind(R.id.left)
    CommonView1 mLeft;
    @Bind(R.id.right)
    CommonView1 mRight;

    public ItemRecommendView1(Context context) {
        super(context);
        init();
    }

    public ItemRecommendView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemRecommendView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemRecommendView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_recommend_1, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(Object left, Object right) {
        mLeft.bindItem(left);
        mRight.bindItem(right);
        if (left instanceof BookObj) {
            mTvTitle.setText("推荐图书");
        } else if (left instanceof GroupObj) {
            mTvTitle.setText("推荐圈子");
        } else if (left instanceof GameObj) {
            mTvTitle.setText("推荐游戏");
        }
    }
}
