package com.lib.loader;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import java.io.File;

/**
 * @author Mrz
 * @date 2018/8/3 10:07
 */
public interface Request<T> {

    T load(@NonNull String url);

    T load(@NonNull File file);

    T load(@DrawableRes int res);

    T error(@DrawableRes int res);

    T placeholder(@DrawableRes int res);

    T errAndPlace(@DrawableRes int errRes, @DrawableRes int placeRes);

    T radius(int radius);

    T useErrRes(boolean use);

    T circle(boolean isCircle);


    void into(ImageView iv);

}
