package com.example.cotacaomoedas4adsc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {

    private const val baseURL = "http://192.168.1.110:8080/api/"
    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}