package com.example.safemoney.repositorio

import com.example.safemoney.model.Objetivos
import retrofit2.Response

interface IObjetivoRepository {
    suspend fun cadastrarObjetivo(objetivo: Objetivos): Response<Unit>
    suspend fun getObjetivoById(id: Int): Response<List<Objetivos>>

}