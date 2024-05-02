package com.example.safemoney.api

import com.example.safemoney.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface CategoriaService {
    @GET("categoria/")
    suspend fun listarCategoria(): Response<List<Categoria>>
}