package com.github.rayboot.tf_plus.viewhoders;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookStoreItem;
import com.infstory.v7.widget.BindViewHolder;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rayboot on 15/8/25.
 */
public class BookStoreViewHolder extends BindViewHolder<BookStoreItem> {


    @Bind(R.id.ivBook)
    SimpleDraweeView mIvBook;
    @Bind(R.id.tvBookTitle)
    TextView mTvBookTitle;
    @Bind(R.id.tvAuthorName)
    TextView mTvAuthorName;

    public BookStoreViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mIvBook.setAspectRatio(0.75f);
    }

    @Override
    public void onBind(int i, BookStoreItem bookStoreItem) {
        mIvBook.setImageURI(Uri.parse(bookStoreItem.image));
        mTvBookTitle.setText(bookStoreItem.title);
        mTvAuthorName.setText(bookStoreItem.author);
    }
}
