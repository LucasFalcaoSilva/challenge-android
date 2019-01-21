package com.b2w.lodjinha.rest.retrofit;

import com.b2w.lodjinha.rest.model.DataBanner;
import com.b2w.lodjinha.rest.model.DataCategoria;
import com.b2w.lodjinha.rest.model.DataProduto;
import com.b2w.lodjinha.rest.model.Produto;
import com.b2w.lodjinha.rest.model.Resultado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LodjinhaRest {

    @GET("/banner")
    Call<DataBanner> obterBanner();

    @GET("/categoria")
    Call<DataCategoria> obterCategoria();

    @GET("/produto")
    Call<DataProduto> obterProduto();

    @GET("/produto/maisvendidos")
    Call<DataProduto> obterProdutoMaisVendidos();

    @GET("/produto")
    Call<DataProduto> obterProdutoCategoria(@Path("categoriaId") Long idCategoria);

    @GET("/produto/{produtoId}")
    Call<Produto> obterProdutoId(@Query("produtoId") Long idProduto);

    @POST("/produto/{produtoId}")
    Call<Resultado> reservarProduto(@Path("produtoId") Long idProduto);

}
