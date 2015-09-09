package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * Created by rayboot on 15/8/25.
 */
public class BookStoreItem {

    public String image;
    public String title;
    public String author;

    public BookStoreItem(String image, String title, String author) {
        this.image = image;
        this.title = title;
        this.author = author;
    }

    public static BookStoreItem getAny() {
        return new BookStoreItem(Constant.bookImages[new Random().nextInt(Constant.bookImages.length)],
                Constant.bookNames[new Random().nextInt(Constant.bookNames.length)],
                Constant.userNames[new Random().nextInt(Constant.userNames.length)]);
    }
}
