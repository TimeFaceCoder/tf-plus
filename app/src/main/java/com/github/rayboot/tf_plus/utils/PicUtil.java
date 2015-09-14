package com.github.rayboot.tf_plus.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;

import com.github.rayboot.tf_plus.App;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

/**
 * @author rayboot
 * @from 14-4-14 9:34
 * @TODO 图片加载
 */
public class PicUtil {
    private static final String PICASSO_CACHE_FOLDER = "CACHE_FOLDER";
    public static boolean isDebug = false;
    private static Picasso picasso;

    public static Picasso getPicasso() {
        if (picasso == null) {
            picasso = new Picasso.Builder(App.getApp())
                    .memoryCache(new LruCache(App.getApp()))
                    .downloader(new OkHttpDownloader(createDefaultCacheDir(
                            App.getApp())))
                    .requestTransformer(new NginxRequestTransformer())
                    .indicatorsEnabled(isDebug)
                    .build();
        }
        if (picasso.areIndicatorsEnabled() != isDebug) {
            picasso.setIndicatorsEnabled(isDebug);
        }
        return picasso;
    }

    //不使用okhttp时，设置cache路径
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    static void installDiskCache(Context context) {
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache == null) {
            File cacheDir = createDefaultCacheDir(context);
            int diskCacheSize = 100; // disk cache size in MB
            int maxSize = diskCacheSize * 1024 * 1024;
            try {
                HttpResponseCache.install(cacheDir, maxSize);
            } catch (IOException e) {
                //Log.d(e.toString(), e);
            }
        }
    }

    static File createDefaultCacheDir(Context context) {
        File cache = context.getExternalCacheDir();
        if (cache == null) {
            cache = context.getCacheDir();
        }

        cache = new File(cache, PICASSO_CACHE_FOLDER);
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }

    /**
     * 扫描、刷新相册
     */
    public static void scanPhotos(String filePath, Context context)
            throws NullPointerException {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(new File(filePath));
        intent.setData(uri);
        context.sendBroadcast(intent);
    }
}
