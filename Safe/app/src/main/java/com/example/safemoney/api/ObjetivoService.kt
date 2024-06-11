package com.example.safemoney.api

import com.example.safemoney.model.Objetivos
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ObjetivoService {
    @POST("objetivos/")
    suspend fun cadastrarObjetivo(@Body objetivo: Objetivos): Response<Unit>

    @GET("objetivos/usuario/{id}")
    suspend fun getObjetivoById(@Path("id") id: Int): Response<List<Objetivos>>

    @GET("objetivos/{id}")
    suspend fun getObjetivoByIdObj(@Path("id") id: Int): Response<Objetivos>

    @PUT("objetivos/adicionar/{idObjetivo}/{novoValorInvestido}/{idUsuario}")
    suspend fun adicionarValorInvestido(
        @Path("idObjetivo") idObjetivo: Int,
        @Path("novoValorInvestido") novoValorInvestido: Double,
        @Path("idUsuario") idUsuario: Int
    ): Response<Unit>

    @PUT("objetivos/{idObjetivo}")
    suspend fun editarObjetivo(
        @Path("idObjetivo") idObjetivo: Int,
        @Body novoObjetivo: Objetivos
    ): Response<Unit>

    @DELETE("objetivos/{id}")
    suspend fun deletarObjetivo(@Path("id") id: Int): Response<Unit>
}
