package com.example.safemoney.repositorio

import com.example.cotacaomoedas4adsc.api.Rest
import com.example.safemoney.api.PlanejamentoService
import com.example.safemoney.planejamento.PlanejamentoItem
import retrofit2.Response

class PlanejamentoRepository: IPlanejamentoRepository {

    private val planejamentoService by lazy {
        Rest.getInstance().create(PlanejamentoService::class.java)
    }

    override suspend fun cadastrarPlanejamento(planejamento: PlanejamentoItem) {
        planejamentoService.cadastrarPlanejamento(planejamento)
    }

    override suspend fun getPorIdUser(id: Int): Response<List<PlanejamentoItem>> {
        return planejamentoService.getPorIdUser(id)
    }

    override suspend fun getPorId(id: Int): Response<PlanejamentoItem> {
        return planejamentoService.getPorId(id)
    }

    override suspend fun excluirPlanejamento(id: Int) {
        planejamentoService.excluirPlanejamento(id)
    }

    override suspend fun editarPlanejamento(planejamento: PlanejamentoItem, id: Int) {
        planejamentoService.editarPlanejamento(planejamento, id)
    }
}