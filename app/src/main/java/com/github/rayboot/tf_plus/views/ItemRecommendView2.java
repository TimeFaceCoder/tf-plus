package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.BookDetailActivity;
import com.github.rayboot.tf_plus.activities.BookStoreActivity;
import com.github.rayboot.tf_plus.activities.GroupContentActivity;
import com.github.rayboot.tf_plus.activities.GroupListActivity;
import com.github.rayboot.tf_plus.activities.SearchActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;
import com.github.rayboot.tf_plus.models.UserObj;
import com.github.rayboot.tf_plus.utils.PicUtil;

import net.soulwolf.widget.ratiolayout.RatioDatumMode;
import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

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
    RatioImageView mIvLogo;
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

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = v.getTag(R.string.tag_obj);
                if (object instanceof BookObj) {
                    BookStoreActivity.open(getContext(), 1);
                } else if (object instanceof GroupObj) {
                    getContext().startActivity(new Intent(getContext(), GroupListActivity.class));
                } else if (object instanceof GameObj) {
                    TempActivity.open(getContext(), "游戏列表页");
                } else if (object instanceof UserObj) {
                    getContext().startActivity(new Intent(getContext(), SearchActivity.class));
                }
            }
        });

        mBtnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = v.getTag(R.string.tag_obj);
                if (object instanceof BookObj) {
                    getContext().startActivity(new Intent(getContext(), BookDetailActivity.class));
                } else if (object instanceof GroupObj) {
                    GroupContentActivity.open(getContext(), GroupObj.TYPE_FRIEND);
                } else if (object instanceof GameObj) {
                    TempActivity.open(getContext(), "游戏详情");
                } else if (object instanceof UserObj) {
                    Snackbar.make(v, "已添加", Snackbar.LENGTH_LONG).show();
                }
            }
        });


    }

    public void bindItem(Object obj) {
        mBtnMore.setTag(R.string.tag_obj, obj);
        mBtnAdd.setTag(R.string.tag_obj, obj);
        if (obj instanceof BookObj) {
            BookObj item = (BookObj) obj;
            mTvTitle.setText("可能喜欢");
            mTvReason.setText("好友 非也君 也在看这本书");
            mIvLogo.setRatio(RatioDatumMode.DATUM_WIDTH, 3, 4);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvLogo);
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof GroupObj) {
            GroupObj item = (GroupObj) obj;
            mTvTitle.setText("推荐圈子");
            mTvReason.setText("好友 非也君 在这个圈里");
            mIvLogo.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvLogo);
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof GameObj) {
            GameObj item = (GameObj) obj;
            mTvTitle.setText("推荐游戏");
            mTvReason.setText("21位好友都在玩这个游戏");
            mIvLogo.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvLogo);
            mTvName.setText(item.name);
            mBtnAdd.setText("去看看");
        } else if (obj instanceof UserObj) {
            UserObj item = (UserObj) obj;
            mTvTitle.setText("可能认识");
            mTvReason.setText("与你有共同好友 非也君");
            mIvLogo.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvLogo);
            mTvName.setText(item.name);
            mBtnAdd.setText("+添加");
        }
    }

}
