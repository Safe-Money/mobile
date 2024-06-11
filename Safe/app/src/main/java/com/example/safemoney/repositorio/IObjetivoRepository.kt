package com.example.safemoney.repositorio

import com.example.safemoney.model.Objetivos
import retrofit2.Response

interface IObjetivoRepository {
    suspend fun cadastrarObjetivo(objetivo: Objetivos): Response<Unit>
    suspend fun getObjetivoById(id: Int): Response<List<Objetivos>>
    suspend fun getObjetivoByIdObj(id: Int): Response<Objetivos>
    suspend fun editarObjetivo(idObjetivo: Int, novoObjetivo: Objetivos): Response<Unit>
    suspend fun deletarObjetivo(idObjetivo: Int): Response<Unit>
    suspend fun adicionarValorInvestido(idObjetivo: Int, novoValorInvestido: Double, idUsuario: Int): Response<Unit>

}