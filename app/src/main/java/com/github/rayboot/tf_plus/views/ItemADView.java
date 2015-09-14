package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.ADObj;
import com.github.rayboot.tf_plus.utils.PicUtil;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/4.
 * email : sy0725work@gmail.com
 */
public class ItemADView extends FrameLayout {
    @Bind(R.id.image)
    RatioImageView mImage;

    public ItemADView(Context context) {
        super(context);
        init();
    }

    public ItemADView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemADView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemADView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_main_ad, this, true);
        ButterKnife.bind(this);

        mImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "打开广告页面");
            }
        });

    }

    public void bindItem(ADObj adObj) {
        PicUtil.getPicasso().load(Uri.parse(adObj.imageUrl)).centerCrop().into(mImage);

        mImage.setTag(R.string.tag_obj, adObj);
    }
}
