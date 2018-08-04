package com.lib.loader;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.lib.loader.ImageOption.LIFE_TYPE_ACTIVITY;
import static com.lib.loader.ImageOption.LIFE_TYPE_CONTEXT;
import static com.lib.loader.ImageOption.LIFE_TYPE_FRAGMENT;
import static com.lib.loader.ImageOption.LOAD_TYPE_FILE;
import static com.lib.loader.ImageOption.LOAD_TYPE_ID;
import static com.lib.loader.ImageOption.LOAD_TYPE_URL;

/**
 * @author Mrz
 * @date 2018/8/3 12:29
 */

public class GlideLoader implements LoaderRequest {


    public GlideLoader() {

    }

    public RequestManager getRequesManage(ImageOption option) {
        RequestManager requestManager = null;
        switch (option.getLifeType()) {
            case LIFE_TYPE_ACTIVITY:
                requestManager = Glide.with(option.getAppCompatActivity());
                break;
            case LIFE_TYPE_CONTEXT:
                requestManager = Glide.with(option.getContext());
                break;
            case LIFE_TYPE_FRAGMENT:
                requestManager = Glide.with(option.getFragment());
                break;
            default:
        }
        return requestManager;
    }

    private RequestBuilder getLoadType(RequestManager requesManage, ImageOption option) {
        RequestBuilder builder = null;
        if (option.getLoadType() == LOAD_TYPE_FILE) {
            builder = requesManage.load(option.getFile());
        } else if (option.getLoadType() == LOAD_TYPE_ID) {
            builder = requesManage.load(option.getResId());
        } else if (option.getLoadType() == LOAD_TYPE_URL) {
            builder = requesManage.load(TextUtils.isEmpty(option.getUrl()) ? getDefaultUrl() :
                    option
                            .getUrl());
        }
        return builder;
    }

    @SuppressLint("CheckResult")
    private RequestOptions getRequestOption(ImageOption option) {
        RequestOptions options = new RequestOptions();
        if (option.isUseErrRes()) {
            options.error(option.getErrResId() == 0 ? getDefaultErrRes() :
                    option.getErrResId())
                    .placeholder(option.getPlaceholderResId() == 0 ? getDefaultPlaceRes() : option
                            .getPlaceholderResId());
        }
        if (option.isCircle()) {
            options.circleCrop();
        }
        if (option.getRadius() > 0) {
            options.transform(new RoundedCornersTransformation(option.getRadius(), 0));
        }
        return options;
    }

    private String getDefaultUrl() {
        return ImageLoader.getInstant().defaultUrl;
    }

    private int getDefaultErrRes() {
        return ImageLoader.getInstant().defaultErrRes;
    }

    private int getDefaultPlaceRes() {
        return ImageLoader.getInstant().defaultPlaceRes;
    }

    @Override
    public void into(ImageView iv, ImageOption option) {
        RequestManager requesManage = getRequesManage(option);
        RequestBuilder requestBuilder = getLoadType(requesManage, option);
        RequestOptions requestOptions = getRequestOption(option);
        requestBuilder.apply(requestOptions).into(iv);
    }
}

