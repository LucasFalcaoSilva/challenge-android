package com.b2w.lodjinha.rest;

import com.b2w.lodjinha.base.service.BaseCallbackService;
import com.b2w.lodjinha.base.service.BaseService;
import com.b2w.lodjinha.base.service.CallBackGeneric;
import com.b2w.lodjinha.rest.model.Banner;
import com.b2w.lodjinha.rest.model.DataBanner;
import com.b2w.lodjinha.rest.model.DataCategoria;
import com.b2w.lodjinha.rest.model.DataProduto;
import com.b2w.lodjinha.rest.model.Produto;
import com.b2w.lodjinha.rest.retrofit.LodjinhaRest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.util.List;

import retrofit2.Call;

@EBean
public class LodjinhaWService extends BaseService {

    private LodjinhaRest lodjinhaRest;

    @AfterInject
    protected void iniciar() {
        lodjinhaRest = (LodjinhaRest) retrofitCreate(LodjinhaRest.class, "alodjinha.herokuapp.com");
    }

    public void obterBanner(final CallBackGeneric<DataBanner> callback) {

        final Call<DataBanner> call = lodjinhaRest.obterBanner();

        call.enqueue(new BaseCallbackService<DataBanner>(callback,"obterBanner"));
    }

    public void obterCategoria(final CallBackGeneric<DataCategoria> callback) {

        final Call<DataCategoria> call = lodjinhaRest.obterCategoria();

        call.enqueue(new BaseCallbackService<DataCategoria>(callback,"obterCategoria"));
    }

    public void obterProdutoCategoria(final CallBackGeneric<DataProduto> callback,Long idCategoria) {

        final Call<DataProduto> call = lodjinhaRest.obterProdutoCategoria(idCategoria);

        call.enqueue(new BaseCallbackService<DataProduto>(callback,"obterProdutoCategoria"));
    }

    public void obterProduto(final CallBackGeneric<DataProduto> callback,Long idProduto) {

        final Call<Produto> call = lodjinhaRest.obterProdutoId(idProduto);

        call.enqueue(new BaseCallbackService<Produto>(callback,"obterProdutoCategoria"));
    }


    public void obterProdutosMaisVendidos(final CallBackGeneric<DataProduto> callback) {

        final Call<DataProduto> call = lodjinhaRest.obterProdutoMaisVendidos();

        call.enqueue(new BaseCallbackService<DataProduto>(callback,"obterProdutosMaisVendidos"));
    }


}

