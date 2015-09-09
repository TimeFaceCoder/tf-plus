package com.github.rayboot.tf_plus.models;

import com.github.rayboot.tf_plus.utils.Constant;

import java.util.Random;

/**
 * author: rayboot  Created on 15/9/6.
 * email : sy0725work@gmail.com
 */
public class GameObj {
    public String name;
    public String image;
    public int userCount;

    public UserObj friend;
    public int friendCount;

    public GameObj(String name, String image, int userCount, UserObj friend, int friendCount) {
        this.name = name;
        this.image = image;
        this.userCount = userCount;
        this.friend = friend;
        this.friendCount = friendCount;
    }

    public static GameObj getAny() {
        return new GameObj(Constant.gameNames[new Random().nextInt(Constant.gameNames.length)],
                Constant.gameImages[new Random().nextInt(Constant.gameImages.length)],
                new Random().nextInt(2000),
                UserObj.getAny(),
                new Random().nextInt(2000));
    }
}
