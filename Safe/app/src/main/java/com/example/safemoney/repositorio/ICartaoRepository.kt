package com.example.safemoney.repositorio

import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import retrofit2.Response

interface ICartaoRepository {
    suspend fun cadastrarCartao(cartao: Cartao, userId: Int): Response<Void>

    suspend fun listarCartao(userId: Int): Response<List<CartaoGet>>
}
