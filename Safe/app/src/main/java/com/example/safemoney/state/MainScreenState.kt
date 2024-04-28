package com.example.safemoney.state

import UserConta

sealed interface MainScreenState {
    data object Loading: MainScreenState

    data class Sucess(
        val data : List<UserConta>
    ): MainScreenState

    data class Error (
        val message: String
    ): MainScreenState
}