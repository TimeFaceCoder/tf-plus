package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.BookDetailActivity;
import com.github.rayboot.tf_plus.activities.BookStoreActivity;
import com.github.rayboot.tf_plus.activities.GroupContentActivity;
import com.github.rayboot.tf_plus.activities.GroupListActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;
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
        init();
    }

    public ItemRecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemRecommendView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemRecommendView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_recommend, this, true);
        ButterKnife.bind(this);

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = v.getTag(R.string.tag_obj);
                if (object instanceof BookObj) {
                    BookStoreActivity.open(getContext(), 1);
                }else if (object instanceof GroupObj) {
                    getContext().startActivity(new Intent(getContext(), GroupListActivity.class));
                }else if (object instanceof GameObj) {
                    TempActivity.open(getContext(), "游戏列表页");
                }
            }
        });
    }

    public void bindItem(Object left, Object right) {
        mBtnMore.setTag(R.string.tag_obj, left);
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
