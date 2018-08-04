package com.lib.loader;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Mrz
 * @date 2018/8/3 09:17
 */
public class ImageLoader {
    private static ImageLoader sImageLoader;
    public String defaultUrl = "www.baidu.com";
    public int defaultErrRes;
    public int defaultPlaceRes;

    private ImageLoader() {

    }

    public static ImageLoader getInstant() {
        if (sImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (sImageLoader == null) {
                    sImageLoader = new ImageLoader();
                }
            }
        }
        return sImageLoader;
    }

    public static ImageManage with(Context context) {
        return getInstant().getManage(context);
    }

    public static ImageManage with(Activity activity) {
        return getInstant().getManage(activity);
    }

    public static ImageManage with(Fragment fragment) {
        return getInstant().getManage(fragment);
    }

    private ImageManage getManage(Context context) {
        return new ImageManage(context);
    }

    private ImageManage getManage(AppCompatActivity activity) {
        return new ImageManage(activity);
    }

    private ImageManage getManage(Fragment fragment) {
        return new ImageManage(fragment);
    }

    public static void init(String defaultUrl, int defaultErrRes, int defaultPlaceRes) {
        ImageLoader imageLoader = getInstant();
        imageLoader.defaultUrl = defaultUrl;
        imageLoader.defaultErrRes = defaultErrRes;
        imageLoader.defaultPlaceRes = defaultPlaceRes;
    }


}
