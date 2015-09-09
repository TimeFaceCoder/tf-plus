package com.github.rayboot.tf_plus.models;

/**
 * author: rayboot  Created on 15/9/4.
 * email : sy0725work@gmail.com
 */
public class ADObj {
    public String imageUrl;
    public String url;

    public ADObj(String imageUrl, String url) {
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public static ADObj getAny() {
        return new ADObj("", "http://www.baidu.com");
    }
}
