package com.github.rayboot.tf_plus.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.rayboot.tf_plus.R;
import com.github.rayboot.tf_plus.activities.TempActivity;
import com.github.rayboot.tf_plus.models.GroupObj;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author: rayboot  Created on 15/9/9.
 * email : sy0725work@gmail.com
 */
public class TreeLayout extends FrameLayout {

    public static final int TYPE_CREATE_TREE = 0;
    public static final int TYPE_VERIFY_TREE = 1;
    public static final int TYPE_INFO_TREE = 2;


    @Bind(R.id.tvDesc)
    TextView mTvDesc;
    @Bind(R.id.btnAdd)
    Button mBtnAdd;
    @Bind(R.id.btnMore)
    Button mBtnMore;

    private int groupType = GroupObj.TYPE_FAMILY;
    private int type = TYPE_CREATE_TREE;

    public TreeLayout(Context context) {
        super(context);
        init();
    }

    public TreeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TreeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TreeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_tree, this, true);
        ButterKnife.bind(this);

        mBtnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (groupType) {
                    case GroupObj.TYPE_FAMILY:
                        if (type == TYPE_CREATE_TREE) {
                            TempActivity.open(getContext(), "引导创建族谱流程");
                        } else if (type == TYPE_VERIFY_TREE) {
                            TempActivity.open(getContext(), "引导认领族谱流程");
                        } else if (type == TYPE_INFO_TREE) {
                            TempActivity.open(getContext(), "完善族谱个人信息");
                        }
                        break;
                    case GroupObj.TYPE_BABY:
                        if (type == TYPE_CREATE_TREE) {
                            TempActivity.open(getContext(), "引导创建家谱流程");
                        } else if (type == TYPE_VERIFY_TREE) {
                            TempActivity.open(getContext(), "引导认领家谱流程");
                        }
                        break;
                    case GroupObj.TYPE_STUDENT:
                        if (type == TYPE_CREATE_TREE) {
                            TempActivity.open(getContext(), "引导上传通讯录流程");
                        } else if (type == TYPE_VERIFY_TREE) {
                            TempActivity.open(getContext(), "引导认领");
                        } else if (type == TYPE_INFO_TREE) {
                            TempActivity.open(getContext(), "完善通讯录个人信息");
                        }
                        break;
                    case GroupObj.TYPE_COM:
                        if (type == TYPE_VERIFY_TREE) {
                            TempActivity.open(getContext(), "引导认证企业机构圈的流程");
                        }
                        break;
                }
            }
        });

        mBtnMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TempActivity.open(getContext(), "帮助");
            }
        });
    }

    public void bindItem(int groupType, int type) {
        this.groupType = groupType;
        this.type = type;
        switch (groupType) {
            case GroupObj.TYPE_FAMILY:
                if (type == TYPE_CREATE_TREE) {
                    mTvDesc.setText("创建你的族谱\n@#￥%*（）");
                    mBtnAdd.setText("创建");
                } else if (type == TYPE_VERIFY_TREE) {
                    mTvDesc.setText("族谱已创建\n去看看有木有你");
                    mBtnAdd.setText("认领身份");
                } else if (type == TYPE_INFO_TREE) {
                    mTvDesc.setText("完善一下你的资料吧\n让家族的人更了解你");
                    mBtnAdd.setText("完善资料");
                }
                break;
            case GroupObj.TYPE_BABY:
                if (type == TYPE_CREATE_TREE) {
                    mTvDesc.setText("创建你的家谱\n@#￥%*（）");
                    mBtnAdd.setText("创建");
                } else if (type == TYPE_VERIFY_TREE) {
                    mTvDesc.setText("家谱已创建\n去认领你的身份");
                    mBtnAdd.setText("认领身份");
                }
                break;
            case GroupObj.TYPE_STUDENT:
                if (type == TYPE_CREATE_TREE) {
                    mTvDesc.setText("上传你的通讯录\n让我们更了解你");
                    mBtnAdd.setText("上传文件");
                } else if (type == TYPE_VERIFY_TREE) {
                    mTvDesc.setText("圈住已上传你们的通讯录\n去看看有木有你");
                    mBtnAdd.setText("认领身份");
                } else if (type == TYPE_INFO_TREE) {
                    mTvDesc.setText("完善一下你的资料吧\n让我们更了解你");
                    mBtnAdd.setText("完善资料");
                }
                break;
            case GroupObj.TYPE_COM:
                if (type == TYPE_VERIFY_TREE) {
                    mTvDesc.setText("认证你的企业\n创建企业大事记");
                    mBtnAdd.setText("上传认证信息");
                }
                break;
            case GroupObj.TYPE_STAR:
                if (type == TYPE_VERIFY_TREE) {
                    mTvDesc.setText("认证你的名人圈");
                    mBtnAdd.setText("上传认证信息");
                }
                break;
        }
    }
}
