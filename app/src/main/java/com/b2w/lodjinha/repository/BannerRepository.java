package com.b2w.lodjinha.repository;

import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.rest.LodjinhaWService;
import com.b2w.lodjinha.rest.model.Banner;
import com.b2w.lodjinha.rest.model.DataBanner;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class BannerRepository {

    @Bean
    protected LodjinhaWService service;

    @Background
    public void obterBanner(final CallBackGeneric<List<Banner>> callBackGeneric) {
        service.obterBanner(new CallBackGeneric<DataBanner>() {
            @Override
            public void callBackSuccess(DataBanner response) {
                callBackGeneric.callBackSuccess(response.getData());
            }

            @Override
            public void callBackError(String response) {
                callBackGeneric.callBackError(response);
            }
        });
    }

}
