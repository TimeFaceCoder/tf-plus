package com.github.rayboot.tf_plus.viewhoders;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.models.BookStoreItem;
import com.github.rayboot.tf_plus.utils.PicUtil;
import com.infstory.v7.widget.BindViewHolder;

import net.soulwolf.widget.ratiolayout.RatioDatumMode;
import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by rayboot on 15/8/25.
 */
public class BookStoreViewHolder extends BindViewHolder<BookStoreItem> {

    @Bind(R.id.root)
    CardView mRoot;
    @Bind(R.id.ivBook)
    RatioImageView mIvBook;
    @Bind(R.id.tvBookTitle)
    TextView mTvBookTitle;
    @Bind(R.id.tvAuthorName)
    TextView mTvAuthorName;

    View.OnClickListener listener;

    public BookStoreViewHolder(View itemView, View.OnClickListener onClickListener) {
        super(itemView);
        this.listener = onClickListener;
        ButterKnife.bind(this, itemView);
        mIvBook.setRatio(RatioDatumMode.DATUM_WIDTH, 3, 4);
    }

    @Override
    public void onBind(int i, BookStoreItem bookStoreItem) {
        PicUtil.getPicasso().load(Uri.parse(bookStoreItem.image)).centerCrop().into(mIvBook);
        mTvBookTitle.setText(bookStoreItem.title);
        mTvAuthorName.setText(bookStoreItem.author);
        mRoot.setOnClickListener(this.listener);
    }
}
