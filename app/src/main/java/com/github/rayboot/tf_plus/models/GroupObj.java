package com.github.rayboot.tf_plus.models;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class GroupObj {
    public String name;
    public String image;
    public int userCount;
    public int type = 0;


    public static final int TYPE_FRIEND = 0;
    public static final int TYPE_BABY = 1;
    public static final int TYPE_STUDENT = 2;
    public static final int TYPE_STAR = 3;
    public static final int TYPE_FAMILY = 4;
    public static final int TYPE_COM = 5;
}
