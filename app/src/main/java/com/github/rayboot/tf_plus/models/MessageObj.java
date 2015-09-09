package com.github.rayboot.tf_plus.models;

/**
 * author: rayboot  Created on 15/9/8.
 * email : sy0725work@gmail.com
 */
public class MessageObj {
    public String title;
    public String content;
    public String time;
    public UserObj author;
    public GroupObj groupObj;
    public EventObj eventObj;
    public BookObj bookObj;

    public MessageObj(String title, String content, String time, UserObj author, GroupObj groupObj, EventObj eventObj, BookObj bookObj) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.author = author;
        this.groupObj = groupObj;
        this.eventObj = eventObj;
        this.bookObj = bookObj;
    }

    public static MessageObj getAny() {
        return new MessageObj("简单概述原则", "无图片情况，内容显示5行，有图片情况内容显示3行。多图情况图片区定高可横向滑动，单张图片则显示完",
                "1天前", UserObj.getAny(), GroupObj.getAny(), EventObj.getAny(), BookObj.getAny());
    }
}
