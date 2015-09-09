package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class UserObj {
    public String name;
    public String image;

    public UserObj(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public static UserObj getAny() {
        return new UserObj(Constant.userNames[new Random().nextInt(Constant.userNames.length)],
                Constant.userImage[new Random().nextInt(Constant.userImage.length)]);
    }
}
