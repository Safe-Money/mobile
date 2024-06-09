package com.example.cotacaomoedas4adsc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {

    private const val baseURL = "https://safemoney.ddns.net/api/"
    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}