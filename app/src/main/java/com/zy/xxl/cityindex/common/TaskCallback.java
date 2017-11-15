package com.zy.xxl.cityindex.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface TaskCallback {

    abstract class Callback<R> {
        public Type rType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        public abstract void onSuccess(R response);
        abstract void onError(ErrorBundle error);
    }

    abstract class Success<R> extends Callback<R> {
        @Override
        void onError(ErrorBundle error) {

        }
    }
}