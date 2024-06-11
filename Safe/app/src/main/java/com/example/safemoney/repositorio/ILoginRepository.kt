package com.example.safemoney.repositorio

import Usuario
import com.example.safemoney.model.Senha
import com.example.safemoney.model.TokenJWT
import com.example.safemoney.model.User

import retrofit2.Response

interface ILoginRepository {
    suspend fun loginUsuario(email: String, senha: String): Response<TokenJWT>
    suspend fun atualizarUsuario(id: Int, usuario: User): Response<Unit>
    suspend fun atualizarSenha(id: Int, usuario: Senha): Response<Unit>
    suspend fun getUsuario(id: Int): Response<User>

    suspend fun excluirUsuario(id: Int): Response<Unit>

}