package com.lib.loader;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

/**
 * @author Mrz
 * @date 2018/8/3 09:47
 */


public class ImageManage implements Request<ImageManage> {

    private ImageOption mOption;

    private ImageManage() {

    }

    public ImageManage(AppCompatActivity activity) {
        mOption = new ImageOption(activity, this);
    }

    public ImageManage(Fragment fragment) {
        mOption = new ImageOption(fragment, this);
    }

    public ImageManage(Context context) {
        mOption = new ImageOption(context, this);
    }

    @Override
    public ImageManage load(String url) {
        return mOption.load(url);
    }

    @Override
    public ImageManage load(File file) {
        return mOption.load(file);
    }

    @Override
    public ImageManage load(int res) {
        return mOption.load(res);
    }

    @Override
    public ImageManage error(int res) {
        return mOption.error(res);
    }

    @Override
    public ImageManage placeholder(int res) {
        return mOption.placeholder(res);
    }

    @Override
    public ImageManage errAndPlace(int errRes, int placeRes) {
        return mOption.errAndPlace(errRes, placeRes);
    }

    @Override
    public ImageManage radius(int radius) {
        return mOption.radius(radius);
    }

    @Override
    public ImageManage useErrRes(boolean use) {

        return mOption.useErrRes(use);
    }

    @Override
    public ImageManage circle(boolean isCircle) {
        return mOption.circle(isCircle);
    }

    @Override
    public void into(ImageView iv) {
        new LoaderControl(mOption).into(iv);
    }


}
