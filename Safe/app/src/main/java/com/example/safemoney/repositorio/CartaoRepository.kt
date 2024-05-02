package com.example.safemoney.repositorio

import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.api.CartaoService
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import retrofit2.Response

class CartaoRepository : ICartaoRepository {

    private val cartaoService by lazy {
        Rest.getInstance().create(CartaoService::class.java)
    }

    override suspend fun cadastrarCartao(cartao: Cartao, userId: Int): Response<Void> {
        return cartaoService.cadastrarCartao(cartao, userId)
    }

    override suspend fun listarCartao(userId: Int): Response<List<CartaoGet>> {
        return cartaoService.listarCartao(userId)
    }

}
