package com.example.safemoney.api

import com.example.safemoney.model.Credenciais
import com.example.safemoney.model.TokenJWT

import okhttp3.Credentials
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginService {
    @POST("autenticacao/login")
    suspend fun loginUser(@Body credencias: Credenciais): Response<TokenJWT>

    }

