package com.github.rayboot.tf_plus;

import android.app.Application;

/**
 * Created by rayboot on 15/8/25.
 */
public class App extends Application {

    private static App app;

    public static App getApp() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
