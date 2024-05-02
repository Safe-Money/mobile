package com.example.safemoney.repositorio

import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.api.CartaoService
import com.example.safemoney.api.CategoriaService
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.model.Categoria
import retrofit2.Response

class CategoriaRepository : ICategoriaRepository {

    private val categoriaService by lazy {
        Rest.getInstance().create(CategoriaService::class.java)
    }

    override suspend fun listarCategoria(): Response<List<Categoria>> {
        return categoriaService.listarCategoria()
    }

}