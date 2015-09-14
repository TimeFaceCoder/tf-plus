package com.github.rayboot.tf_plus.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.utils.RevealBackgroundView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements RevealBackgroundView.OnStateChangeListener {

    int[] colors = {Color.parseColor("#e91e63"),
            Color.parseColor("#00bcd4"),
            Color.parseColor("#259b2c"),
            Color.parseColor("#ffc107"),
            Color.parseColor("#ff5722"),
            Color.parseColor("#673ab7"),
            Color.parseColor("#9c27b0"),
            Color.parseColor("#9e9e9e"),
            Color.parseColor("#009688")};

    @Bind({R.id.addQQ,
            R.id.addWeChat,
            R.id.addFastest,
            R.id.addBook,
            R.id.addGroup,
            R.id.addEvent,
            R.id.addFriend,
            R.id.addScan,
            R.id.addWrite,
            R.id.addImage,})
    LinearLayout[] addLayouts;

    @Bind(R.id.tvAddBook)
    TextView tvAddBook;
    @Bind(R.id.tvAddSocial)
    TextView tvAddSocial;
    @Bind(R.id.tvAddWrite)
    TextView tvAddWrite;

    @Bind(R.id.llContent)
    LinearLayout llContent;
    @Bind(R.id.llAddBook)
    LinearLayout llAddBook;
    @Bind(R.id.llAddSocial)
    LinearLayout llAddSocial;
    @Bind(R.id.llAddWrite)
    LinearLayout llAddWrite;
    @Bind(R.id.vRevealBackground)
    RevealBackgroundView vRevealBackground;

    public static void open(Context context, boolean showBook, boolean showSocial, boolean showWrite, int[] startingLocation) {
        Intent intent = new Intent(context, AddActivity.class);
        intent.putExtra("showBook", showBook);
        intent.putExtra("showSocial", showSocial);
        intent.putExtra("showWrite", showWrite);
        intent.putExtra("reveal_start_location", startingLocation);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        for (int i = 0; i < addLayouts.length; i++) {
            LinearLayout ll = addLayouts[i];
            ShapeDrawable circle = new ShapeDrawable(new OvalShape());
            circle.getPaint().setColor(colors[i % colors.length]);
            ll.getChildAt(0).setBackground(circle);
        }

        tvAddBook.setVisibility(getIntent().getBooleanExtra("showBook", true) ? View.VISIBLE : View.GONE);
        llAddBook.setVisibility(getIntent().getBooleanExtra("showBook", true) ? View.VISIBLE : View.GONE);
        tvAddSocial.setVisibility(getIntent().getBooleanExtra("showSocial", true) ? View.VISIBLE : View.GONE);
        llAddSocial.setVisibility(getIntent().getBooleanExtra("showSocial", true) ? View.VISIBLE : View.GONE);
        tvAddWrite.setVisibility(getIntent().getBooleanExtra("showWrite", true) ? View.VISIBLE : View.GONE);
        llAddWrite.setVisibility(getIntent().getBooleanExtra("showWrite", true) ? View.VISIBLE : View.GONE);
        setupRevealBackground(savedInstanceState);
    }

    private void setupRevealBackground(Bundle savedInstanceState) {
        vRevealBackground.setFillPaintColor(getResources().getColor(R.color.colorPrimary));
        vRevealBackground.setOnStateChangeListener(this);
        if (savedInstanceState == null) {
            final int[] startingLocation = getIntent().getIntArrayExtra("reveal_start_location");
            vRevealBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    vRevealBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                    vRevealBackground.startFromLocation(startingLocation);
                    return true;
                }
            });
        } else {
            vRevealBackground.setToFinishedFrame();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.addQQ:
                TempActivity.open(this, "添加QQ书");
                break;
            case R.id.addWeChat:
                TempActivity.open(this, "添加微信书");
                break;
            case R.id.addFastest:
                TempActivity.open(this, "快速成书");
                break;
            case R.id.addBook:
                TempActivity.open(this, "添加时光书");
                break;
            case R.id.addGroup:
                startActivity(new Intent(this, GroupTypeActivity.class));
                break;
            case R.id.addEvent:
                startActivity(new Intent(this, EventCreateActivity.class));

                break;
            case R.id.addFriend:
                TempActivity.open(this, "添加好友");
                break;
            case R.id.addScan:
                TempActivity.open(this, "扫描老照片");
                break;
            case R.id.addWrite:
                TempActivity.open(this, "写文字时光");
                break;
            case R.id.addImage:
                TempActivity.open(this, "发布时光");
                break;
        }

    }

    public void onFabClick(View view) {
        finish();
    }

    @Override
    public void onStateChange(int state) {

        if (RevealBackgroundView.STATE_FINISHED == state) {
            llContent.setVisibility(View.VISIBLE);
            animationView(tvAddBook, 300);
            animationView(tvAddSocial, 500);
            animationView(tvAddWrite, 900);
            animationLinearLayout(llAddBook, 400);
            animationLinearLayout(llAddSocial, 600);
            animationLinearLayout(llAddWrite, 1000);

        } else {
            llContent.setVisibility(View.INVISIBLE);
        }
    }

    private void animationView(View view, int startDelay) {
        view.setTranslationY(view.getHeight());
        view.setAlpha(0);
        view.animate()
                .translationY(0)
                .alpha(1)
                .setDuration(300)
                .setStartDelay(startDelay);
    }

    private void animationLinearLayout(LinearLayout linearLayout, int baseDelay) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            animationView(v, (i + 1) * 100 + baseDelay);
        }
    }
}
