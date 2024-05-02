package com.example.safemoney.viewmodel

import LoginViewModel
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Cartao
import com.example.safemoney.model.CartaoGet
import com.example.safemoney.repositorio.CartaoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CartaoViewModel(private val cartaoRepository: CartaoRepository, loginViewModel: LoginViewModel) : ViewModel() {




    private val _cartaoLiveData = MutableLiveData<List<CartaoGet>>()
    val cartaoLiveData: LiveData<List<CartaoGet>> = _cartaoLiveData

    val cadastroSucesso = mutableStateOf(false)
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("ContaViewModel", "Erro ao cadastrar a conta", exception)
    }


    init {
        listarCartao(loginViewModel.getId())
    }

    fun cadastrarCartao(cartao: Cartao, userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<Void> = cartaoRepository.cadastrarCartao(cartao, userId)
                Log.d("CartaoViewModel", "Cartão cadastrado com sucesso! $cartao")
            listarCartao(userId)
        }
    }

    fun listarCartao(userId: Int): LiveData<List<CartaoGet>> {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = cartaoRepository.listarCartao(userId)
                if (response.isSuccessful) {
                    _cartaoLiveData.postValue(response.body())
                    val cartoes = response.body()
                    Log.e("CartaoViewModel", "listar cartões $response ")
                    cartoes?.forEach { cartao ->
                        Log.d("CartaoViewModel", "${cartoes}")
                    }

                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("CartaoViewModel", "Erro ao listar cartões $erro")
                }
            } catch (e: Exception) {
                Log.e("CartaoViewModel", "Erro ao listar cartões", e)
            }
        }
        return cartaoLiveData
    }
}

