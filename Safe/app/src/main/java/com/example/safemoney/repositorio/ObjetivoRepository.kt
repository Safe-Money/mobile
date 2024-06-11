package com.example.safemoney.repositorio

import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.api.ObjetivoService
import com.example.safemoney.model.Objetivos
import retrofit2.Response

class ObjetivoRepository : IObjetivoRepository {
    private val objetivoService by lazy {
        Rest.getInstance().create(ObjetivoService::class.java)
    }

    override suspend fun cadastrarObjetivo(objetivo: Objetivos): Response<Unit> {
        return objetivoService.cadastrarObjetivo(objetivo)
    }

    override suspend fun getObjetivoById(id: Int): Response<List<Objetivos>> {
        return objetivoService.getObjetivoById(id)
    }

    override suspend fun getObjetivoByIdObj(id: Int): Response<Objetivos> {
        return objetivoService.getObjetivoByIdObj(id)
    }

    override suspend fun deletarObjetivo(id: Int): Response<Unit> {
        return objetivoService.deletarObjetivo(id)
    }

    override suspend fun adicionarValorInvestido(idObjetivo: Int, novoValorInvestido: Double, idUsuario: Int): Response<Unit> {
        return objetivoService.adicionarValorInvestido(idObjetivo, novoValorInvestido, idUsuario)
    }

    override suspend fun editarObjetivo(idObjetivo: Int, novoObjetivo: Objetivos): Response<Unit> {
        return objetivoService.editarObjetivo(idObjetivo, novoObjetivo)
    }
}
