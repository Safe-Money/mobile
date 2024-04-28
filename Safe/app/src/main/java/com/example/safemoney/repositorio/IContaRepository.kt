package com.example.safemoney.repositorio

import UserConta

import retrofit2.Response

interface IContaRepository {
    suspend fun cadastrarConta(conta: UserConta): Response<Void>
    suspend fun listarContas(userId: Int): Response<List<UserConta>>
}
