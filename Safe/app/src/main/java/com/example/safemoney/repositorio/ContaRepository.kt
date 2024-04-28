package com.example.safemoney.repositorio

import ContaService
import UserConta
import com.example.cotacaomoedas4adsc.api.Rest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

import retrofit2.Response
import retrofit2.await
import java.io.IOException



class ContaRepository() : IContaRepository {

    private val contaService by lazy {
        Rest.getInstance().create(ContaService::class.java)
    }

    override suspend fun cadastrarConta(conta: UserConta): Response<Void> {
        return contaService.cadastrarConta(conta)
    }

    override suspend fun listarContas(userId: Int): Response<List<UserConta>> {
        return contaService.listarContas(userId)
    }
}
