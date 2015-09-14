package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.BookDetailActivity;
import com.github.rayboot.tf_plus.activities.GroupContentActivity;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.BookObj;
import com.github.rayboot.tf_plus.models.GameObj;
import com.github.rayboot.tf_plus.models.GroupObj;
import com.github.rayboot.tf_plus.utils.PicUtil;

import net.soulwolf.widget.ratiolayout.RatioDatumMode;
import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class CommonView extends LinearLayout {
    @Bind(R.id.ivImg)
    RatioImageView mIvImg;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvSubTitle)
    TextView mTvSubTitle;
    @Bind(R.id.ivDesc)
    RatioImageView mIvDesc;
    @Bind(R.id.tvDesc)
    TextView mTvDesc;
    @Bind(R.id.llDesc)
    LinearLayout mLlDesc;
    @Bind(R.id.root)
    LinearLayout mRoot;

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

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Object object = v.getTag(R.string.tag_obj);
                if (object instanceof BookObj) {
                    getContext().startActivity(new Intent(getContext(), BookDetailActivity.class));
                } else if (object instanceof GroupObj) {
                    GroupContentActivity.open(getContext(), GroupObj.TYPE_FRIEND);
                } else if (object instanceof GameObj) {
                    TempActivity.open(getContext(), "游戏详情页面");
                }
            }
        });
    }

    public void bindItem(Object object) {
        mLlDesc.setVisibility(GONE);
        mRoot.setTag(R.string.tag_obj, object);
        if (object instanceof BookObj) {
            BookObj item = (BookObj) object;
            mIvImg.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvImg);
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.author.name + " 著");
        } else if (object instanceof GroupObj) {
            GroupObj item = (GroupObj) object;
            mIvImg.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvImg);
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.userCount + "参与其中");
        } else if (object instanceof GameObj) {
            GameObj item = (GameObj) object;
            mIvImg.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().into(mIvImg);
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.userCount + "参与其中");
            mLlDesc.setVisibility(VISIBLE);
            mIvImg.setRatio(RatioDatumMode.DATUM_WIDTH, 1, 1);
            PicUtil.getPicasso().load(Uri.parse(item.image)).fit().centerCrop().transform(new CropCircleTransformation()).into(mIvDesc);
            mTvDesc.setText(item.friendCount + "个好友也在玩");
        }
    }
}
