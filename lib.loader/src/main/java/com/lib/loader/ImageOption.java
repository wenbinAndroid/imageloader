package com.lib.loader;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

/**
 * @author Mrz
 * @date 2018/8/3 11:24
 */
public class ImageOption implements Request<ImageManage> {
    //网址显示
    private String url;
    //文件显示
    private File mFile;
    //资源显示
    private int resId;
    //错误占位图
    private int errResId;
    //加载中的占位图
    private int placeholderResId;
    //
    private int lifeType;
    //是否显示占位图
    private boolean useErrRes = true;
    //是否是圆形图片
    private boolean isCircle;
    //弧度
    private int radius;
    public static final int LIFE_TYPE_CONTEXT = 1;
    public static final int LIFE_TYPE_FRAGMENT = 2;
    public static final int LIFE_TYPE_ACTIVITY = 3;
    private int loadType;
    public static final int LOAD_TYPE_URL = 1;
    public static final int LOAD_TYPE_ID = 2;
    public static final int LOAD_TYPE_FILE = 3;
    private Fragment mFragment;
    private AppCompatActivity mAppCompatActivity;
    private Context mContext;
    private ImageManage mImageManage;

    private ImageOption() {

    }

    public ImageOption(AppCompatActivity appCompatActivity, ImageManage manage) {
        lifeType = LIFE_TYPE_ACTIVITY;
        this.mAppCompatActivity = appCompatActivity;
        this.mImageManage = manage;
    }

    public ImageOption(Fragment fragment, ImageManage manage) {
        lifeType = LIFE_TYPE_FRAGMENT;
        this.mFragment = fragment;
        this.mImageManage = manage;
    }

    public ImageOption(Context context, ImageManage manage) {
        lifeType = LIFE_TYPE_CONTEXT;
        this.mContext = context.getApplicationContext();
        this.mImageManage = manage;
    }


    @Override
    public ImageManage load(@NonNull String url) {
        this.url = url;
        this.loadType = LOAD_TYPE_URL;
        return mImageManage;
    }

    @Override
    public ImageManage load(@NonNull File file) {
        this.mFile = file;
        this.loadType = LOAD_TYPE_FILE;
        return mImageManage;
    }

    @Override
    public ImageManage load(int id) {
        this.resId = id;
        this.loadType = LOAD_TYPE_ID;
        return mImageManage;
    }

    @Override
    public ImageManage error(int res) {
        this.errResId = res;
        return mImageManage;
    }

    @Override
    public ImageManage placeholder(int res) {
        this.placeholderResId = res;
        return mImageManage;
    }

    @Override
    public ImageManage errAndPlace(int errRes, int placeRes) {
        this.errResId = errRes;
        this.placeholderResId = placeRes;
        return mImageManage;
    }

    @Override
    public ImageManage radius(int radius) {
        this.radius = radius;
        return mImageManage;
    }

    @Override
    public ImageManage useErrRes(boolean use) {
        this.useErrRes = use;
        return mImageManage;
    }

    @Override
    public ImageManage circle(boolean isCircle) {
        this.isCircle = isCircle;
        return mImageManage;
    }

    @Override
    public void into(ImageView iv) {
    }

    public String getUrl() {
        return url == null ? "" : url;
    }

    public File getFile() {
        return mFile;
    }

    public int getResId() {
        return resId;
    }

    public int getErrResId() {
        return errResId;
    }

    public int getPlaceholderResId() {
        return placeholderResId;
    }

    public int getLifeType() {
        return lifeType;
    }

    public boolean isUseErrRes() {
        return useErrRes;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public int getRadius() {
        return radius;
    }

    public static int getLifeTypeContext() {
        return LIFE_TYPE_CONTEXT;
    }

    public static int getLifeTypeFragment() {
        return LIFE_TYPE_FRAGMENT;
    }

    public static int getLifeTypeActivity() {
        return LIFE_TYPE_ACTIVITY;
    }

    public int getLoadType() {
        return loadType;
    }

    public static int getLoadTypeUrl() {
        return LOAD_TYPE_URL;
    }

    public static int getLoadTypeId() {
        return LOAD_TYPE_ID;
    }

    public static int getLoadTypeFile() {
        return LOAD_TYPE_FILE;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public AppCompatActivity getAppCompatActivity() {
        return mAppCompatActivity;
    }

    public Context getContext() {
        return mContext;
    }

    public ImageManage getImageManage() {
        return mImageManage;
    }
}
