package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class GroupObj {
    public static final int TYPE_FRIEND = 0;
    public static final int TYPE_BABY = 1;
    public static final int TYPE_STUDENT = 2;
    public static final int TYPE_STAR = 3;
    public static final int TYPE_FAMILY = 4;
    public static final int TYPE_COM = 5;
    public String name;
    public String image;
    public int userCount;
    public int type = 0;

    public GroupObj(String name, String image, int userCount, int type) {
        this.name = name;
        this.image = image;
        this.userCount = userCount;
        this.type = type;
    }

    public static GroupObj getAny() {
        return new GroupObj(Constant.groupNames[new Random().nextInt(Constant.groupNames.length)],
                Constant.groupImages[new Random().nextInt(Constant.groupImages.length)],
                new Random().nextInt(100000),
                new Random().nextInt(6));
    }
}
