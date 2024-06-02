package com.example.safemoney.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Receita
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.repositorio.ITransacaoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class TransacaoViewModel(
    private val transacaoRepository: ITransacaoRepository
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("TransacaoViewModel", "Erro ao cadastrar transacao!!", exception)
    }
    private val _successEvent = MutableLiveData<Boolean>()
    val successEvent: LiveData<Boolean>
        get() = _successEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String>
        get() = _errorEvent

    fun adicionarReceita(receita: Receita) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                Log.d("TransacaoViewModel", "Adicionando receita... $receita")
                transacaoRepository.adicionarReceita(receita)
                _successEvent.value = true
                Log.d("TransacaoViewModel", "Receita adicionada com sucesso: $receita")
            } catch (e: Exception) {
                _errorEvent.value = "Erro ao adicionar receita: ${e.message}"
            }
        }
    }

    fun adicionarReceitaFixa(receita: Receita) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                Log.d("TransacaoViewModel", "Adicionando receita fixa... $receita")
                transacaoRepository.adicionarReceitaFixa(receita)
                _successEvent.value = true
                Log.d("TransacaoViewModel", "Receita fixa adicionada com sucesso: $receita")
            } catch (e: Exception) {
                _errorEvent.value = "Erro ao adicionar receita fixa: ${e.message}"
            }
        }
    }


}