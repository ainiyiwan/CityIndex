package com.zy.xxl.cityindex.base;

import android.content.Context;

import com.zy.xxl.cityindex.MyApplication;

/**
 * Created by SilenceDut on 16/10/29.
 * 已添加
 */

public abstract class BasePresenter<T extends BaseView> {

    protected T mPresentView;
    private Context mContext = MyApplication.getContext();

    public Context getContext() {
        return mContext;
    }

    public BasePresenter(T presenterView) {
        attachView(presenterView);
    }

    private void attachView(T presenterView) {
        mPresentView = presenterView;
    }

    public void onDetchView() {
        mPresentView = null;
    }


}
