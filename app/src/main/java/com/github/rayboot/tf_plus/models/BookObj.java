package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class BookObj {
    public String name;
    public String image;
    public UserObj author;

    public BookObj(String name, String image, UserObj author) {
        this.name = name;
        this.image = image;
        this.author = author;
    }

    public static BookObj getAny() {
        return new BookObj(Constant.bookNames[new Random().nextInt(Constant.bookNames.length)],
                Constant.bookImages[new Random().nextInt(Constant.bookImages.length)],
                UserObj.getAny());
    }
}
