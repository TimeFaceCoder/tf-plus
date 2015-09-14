package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.BookDetailActivity;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/8.
 * email : sy0725work@gmail.com
 */
public class BookView extends CardView {
    @Bind(R.id.ivBook)
    RatioImageView mIvBook;
    @Bind(R.id.tvBookTitle)
    TextView mTvBookTitle;
    @Bind(R.id.tvAuthorName)
    TextView mTvAuthorName;
    @Bind(R.id.root)
    CardView mRoot;

    public BookView(Context context) {
        super(context);
        init();
    }

    public BookView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_book, this, true);
        ButterKnife.bind(this);

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), BookDetailActivity.class));
            }
        });
    }
}
