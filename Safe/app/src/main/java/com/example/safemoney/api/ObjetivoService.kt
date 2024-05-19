package com.example.safemoney.api

import Objetivo
import com.example.safemoney.model.Objetivos
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ObjetivoService {
    @POST("objetivos/")
    suspend fun cadastrarObjetivo(@Body objetivo: Objetivos): Response<Unit>

    @GET("objetivos/usuario/{id}")
    suspend fun getObjetivoById(@Path("id") id: Int): Response<List<Objetivos>>

}