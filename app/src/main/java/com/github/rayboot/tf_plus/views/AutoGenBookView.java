package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.AutoGenBookShowActivity;
import com.github.rayboot.tf_plus.models.BookObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class AutoGenBookView extends LinearLayout {
    @Bind(R.id.ivBookCover)
    SimpleDraweeView mIvBookCover;
    @Bind(R.id.root)
    LinearLayout mRoot;

    public AutoGenBookView(Context context) {
        super(context);
        init();
    }

    public AutoGenBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoGenBookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AutoGenBookView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_auto_gen_book, this, true);
        ButterKnife.bind(this);

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), AutoGenBookShowActivity.class));
            }
        });
    }

    public void bindItem(BookObj bookObj) {
        mIvBookCover.setAspectRatio(0.75f);
        mIvBookCover.setImageURI(Uri.parse(bookObj.image));

    }
}
