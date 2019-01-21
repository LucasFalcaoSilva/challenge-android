package com.b2w.lodjinha.base.service;

public interface CallBackGeneric<T> {

    void callBackSuccess(T response);

    void callBackError(String response);
}