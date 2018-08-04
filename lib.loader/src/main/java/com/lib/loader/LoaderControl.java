package com.lib.loader;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.widget.ImageView;

/**
 * @author Mrz
 * @date 2018/8/3 10:44
 */
public class LoaderControl implements LifecycleObserver {
    private ImageOption mOption;
    private GlideLoader mLoader;

    public LoaderControl(ImageOption option) {
        this.mOption = option;
    }

    public void into(ImageView iv) {
        addlifecycle();
        mLoader = new GlideLoader();
        mLoader.into(iv, mOption);
    }

    private void addlifecycle() {
        if (mOption.getLifeType() == ImageOption.LIFE_TYPE_ACTIVITY) {
            mOption.getAppCompatActivity().getLifecycle().addObserver(this);
        } else if (mOption.getLifeType() == ImageOption.LIFE_TYPE_FRAGMENT) {
            mOption.getFragment().getLifecycle().addObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        removeLife();
        mLoader = null;
        mOption = null;

    }

    private void removeLife() {
        if (mOption.getLifeType() == ImageOption.LIFE_TYPE_ACTIVITY) {
            mOption.getAppCompatActivity().getLifecycle().removeObserver(this);
        } else if (mOption.getLifeType() == ImageOption.LIFE_TYPE_FRAGMENT) {
            mOption.getFragment().getLifecycle().removeObserver(this);
        }

    }

}
