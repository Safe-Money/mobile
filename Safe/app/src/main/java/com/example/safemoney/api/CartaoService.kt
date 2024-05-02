package com.example.safemoney.api

import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CartaoService {
    @POST("cartao-credito/")
    suspend fun cadastrarCartao(@Body cartao: Cartao, @Query("userId") userId: Int): Response<Void>

    @GET("cartao-credito/listar-cartoes/{id}")
    suspend fun listarCartao(@Path("id") userId: Int): Response<List<CartaoGet>>

}
