package com.example.safemoney.repositorio

import com.example.safemoney.model.TokenJWT

import retrofit2.Response

interface ILoginRepository {
    suspend fun loginUsuario(email: String, senha: String): Response<TokenJWT>

}