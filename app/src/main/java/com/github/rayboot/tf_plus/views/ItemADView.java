package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.ADObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/4.
 * email : sy0725work@gmail.com
 */
public class ItemADView extends FrameLayout {
    @Bind(R.id.image)
    SimpleDraweeView mImage;

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
    }

    public void bindItem(ADObj adObj) {
        mImage.setImageURI(Uri.parse(adObj.imageUrl));
        mImage.setTag(R.string.tag_obj, adObj);
    }
}
