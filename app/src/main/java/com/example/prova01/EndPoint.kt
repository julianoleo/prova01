package com.example.prova01

import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {
    @GET("droidcafe")
    fun getProdutos(): Call<List<Produtos>>
}