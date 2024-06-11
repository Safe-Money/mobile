package com.example.safemoney.api

import Usuario
import com.example.safemoney.model.Credenciais
import com.example.safemoney.model.Senha
import com.example.safemoney.model.TokenJWT
import com.example.safemoney.model.User

import okhttp3.Credentials
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface LoginService {
    @POST("autenticacao/login")
    suspend fun loginUser(@Body credencias: Credenciais): Response<TokenJWT>

    @PUT("usuarios/{id}")
    suspend fun atualizarUsuario(@Path("id") id: Int, @Body usuario: User): Response<Unit>

    @PUT("usuarios/{id}")
    suspend fun atualizarSenha(@Path("id") id: Int, @Body usuario: Senha): Response<Unit>
    @GET("usuarios/{id}")
    suspend fun getUsuario(@Path("id") id: Int): Response<User>

    @DELETE("usuarios/{id}")
    suspend fun excluirUsuario(@Path("id") id: Int): Response<Unit>

}

