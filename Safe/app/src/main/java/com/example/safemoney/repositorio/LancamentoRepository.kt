package com.example.safemoney.repositorio

import LancamentoService
import Lancamentos
import LancamentosGet
import androidx.lifecycle.ViewModel
import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.api.CategoriaService
import com.example.safemoney.model.CartaoGet

import retrofit2.Response

class LancamentoRepository: ILancamentoRepository {
    private val lancamentoService by lazy {
        Rest.getInstance().create(LancamentoService::class.java)
    }

    override suspend fun cadastrarLancamento(lancamento: Lancamentos) {
        lancamentoService.cadastrarLancamento(lancamento)
    }

    override suspend fun listarLancamentos(userId: Int): Response<List<LancamentosGet>> {
        return lancamentoService.listarLancamento(userId)
    }


    }

