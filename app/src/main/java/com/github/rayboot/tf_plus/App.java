package com.github.rayboot.tf_plus;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by rayboot on 15/8/25.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
