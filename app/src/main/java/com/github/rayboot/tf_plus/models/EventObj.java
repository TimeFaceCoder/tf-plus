package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class EventObj {
    public String name;
    public String image;

    public EventObj(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public static EventObj getAny() {
        return new EventObj(Constant.eventNames[new Random().nextInt(Constant.eventNames.length)],
                Constant.eventImages[new Random().nextInt(Constant.eventImages.length)]);
    }
}
