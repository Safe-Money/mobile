package com.example.safemoney.repositorio

import com.example.safemoney.planejamento.PlanejamentoGet
import com.example.safemoney.planejamento.PlanejamentoItem
import retrofit2.Response

interface IPlanejamentoRepository {
    suspend fun cadastrarPlanejamento(planejamento: PlanejamentoItem)
    suspend fun getPorIdUser(id: Int): Response<List<PlanejamentoGet>>
    suspend fun getPorId(id: Int): Response<PlanejamentoItem>
    suspend fun excluirPlanejamento(id: Int)
    suspend fun editarPlanejamento(planejamento: PlanejamentoItem, id: Int)
}