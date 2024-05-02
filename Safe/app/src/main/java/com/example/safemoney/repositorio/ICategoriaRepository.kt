package com.example.safemoney.repositorio

import com.example.safemoney.model.CartaoGet
import com.example.safemoney.model.Categoria
import retrofit2.Response

interface ICategoriaRepository {
    suspend fun listarCategoria(): Response<List<Categoria>>
}