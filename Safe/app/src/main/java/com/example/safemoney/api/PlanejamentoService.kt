package com.example.safemoney.api

import com.example.safemoney.planejamento.PlanejamentoGet
import com.example.safemoney.planejamento.PlanejamentoItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlanejamentoService {
    @POST("planejamento/")
    suspend fun cadastrarPlanejamento(@Body planejamento: PlanejamentoItem)

    @GET("planejamento/busca-gastos-categoria/{id}")
    suspend fun getPorIdUser(@Path("id") userId: Int): Response<List<PlanejamentoGet>>

    @GET("planejamento/editar/{idPlanejamento}")
    suspend fun getPorId(@Path("idPlanejamento") idPlanejamento: Int): Response<PlanejamentoItem>

    @DELETE("planejamento/{id}")
    suspend fun excluirPlanejamento(@Path("id") planejamentoId: Int)

    @PUT("planejamento/{id}")
    suspend fun editarPlanejamento(@Body planejamento: PlanejamentoItem, @Path("id") planejamentoId: Int)
}