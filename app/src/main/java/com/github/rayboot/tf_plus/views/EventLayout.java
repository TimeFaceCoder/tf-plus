package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.EventContentActivity;
import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuItem;
import com.shehabic.droppy.DroppyMenuPopup;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/7.
 * email : sy0725work@gmail.com
 */
public class EventLayout extends FrameLayout {
    @Bind(R.id.ivEventLogo)
    RatioImageView mIvEventLogo;
    @Bind(R.id.tvState)
    TextView mTvState;
    @Bind(R.id.tvTitle)
    TextView mTvTitle;
    @Bind(R.id.tvTime)
    TextView mTvTime;
    @Bind(R.id.tvLocation)
    TextView mTvLocation;
    @Bind(R.id.ivUserLogo)
    RatioImageView mIvUserLogo;
    @Bind(R.id.ivState)
    View mIvState;
    @Bind(R.id.main)
    LinearLayout mMain;

    DroppyMenuPopup droppyMenu;
    @Bind(R.id.root)
    FrameLayout mRoot;

    public EventLayout(Context context) {
        super(context);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public EventLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_event, this, true);
        ButterKnife.bind(this);


        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(getContext(), mTvState);

        droppyBuilder.addMenuItem(new DroppyMenuItem("会参加"))
                .addMenuItem(new DroppyMenuItem("不参加"))
                .addMenuItem(new DroppyMenuItem("可能参加"))
                .addSeparator();

        droppyBuilder.setOnClick(new DroppyClickCallbackInterface() {
            @Override
            public void call(View v, int id) {
                switch (id) {
                    case 0:
                        mTvState.setText("会参加");
                        mTvState.setTextColor(Color.GREEN);
                        mIvState.setBackgroundColor(Color.GREEN);
                        break;
                    case 1:
                        mTvState.setText("不参加");
                        mTvState.setTextColor(Color.RED);
                        mIvState.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        mTvState.setText("可能参加");
                        mTvState.setTextColor(Color.GRAY);
                        mIvState.setBackgroundColor(Color.GRAY);
                        break;
                }
            }
        });

        droppyMenu = droppyBuilder.build();

        mTvState.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                droppyMenu.show();
            }
        });

        mRoot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EventContentActivity.class));
            }
        });
    }
}
