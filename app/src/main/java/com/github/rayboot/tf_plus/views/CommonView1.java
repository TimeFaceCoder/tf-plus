package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
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
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class CommonView1 extends FrameLayout {
    @Bind(R.id.ivLogo)
    SimpleDraweeView mIvLogo;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvSubTitle)
    TextView mTvSubTitle;

    public CommonView1(Context context) {
        super(context);
        init();
    }

    public CommonView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CommonView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_common_1, this, true);
        ButterKnife.bind(this);
    }

    public void bindItem(Object object) {
        if (object instanceof BookObj) {
            BookObj item = (BookObj) object;
            mIvLogo.setAspectRatio(0.75f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.author.name + " 著");
        } else if (object instanceof GroupObj) {
            GroupObj item = (GroupObj) object;
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvTitle.setText(item.name);
            mTvSubTitle.setText(item.userCount + "参与其中");
        }else if (object instanceof UserObj) {
            UserObj item = (UserObj) object;
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvTitle.setText(item.name);
        }else if (object instanceof GameObj) {
            GameObj item = (GameObj) object;
            mIvLogo.setAspectRatio(1.0f);
            mIvLogo.setImageURI(Uri.parse(item.image));
            mTvTitle.setText(item.name);
        }
    }

}
