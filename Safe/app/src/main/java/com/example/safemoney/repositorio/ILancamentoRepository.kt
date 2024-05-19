package com.example.safemoney.repositorio


import Lancamentos
import LancamentosGet
import com.example.safemoney.model.CartaoGet
import retrofit2.Response

interface ILancamentoRepository {

    suspend fun cadastrarLancamento(lancamento: Lancamentos)
    suspend fun listarLancamentos(contaId: Int): Response<List<LancamentosGet>>

    }


