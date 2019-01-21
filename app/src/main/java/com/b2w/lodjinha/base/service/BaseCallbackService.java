package com.b2w.lodjinha.base.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseCallbackService<T> implements Callback<T>  {

    private CallBackGeneric callBackGeneric;
    private String name;

    public BaseCallbackService(CallBackGeneric callBackGeneric,String name) {
        this.callBackGeneric = callBackGeneric;
        this.name = name;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            callBackGeneric.callBackSuccess(response.body());
        } else {
            onFailure(call, null);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        callBackGeneric.callBackError("Erro serviço " + name);
    }
}
