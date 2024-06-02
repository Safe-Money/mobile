package com.example.safemoney.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Transacao
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.repositorio.ITransacaoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransacaoViewModel(
    private val transacaoRepository: ITransacaoRepository
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("TransacaoViewModel", "Erro ao cadastrar transacao!!", exception)
    }

    private val _transacao = MutableLiveData<Transacao>()
    val transacao: LiveData<Transacao>
        get() = _transacao

    private val _transacoes = MutableLiveData<List<Transacao>>()
    val transacoes: LiveData<List<Transacao>>
        get() = _transacoes

    private val _successEvent = MutableLiveData<Boolean>()
    val successEvent: LiveData<Boolean>
        get() = _successEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String>
        get() = _errorEvent

    fun adicionarReceita(receita: Transacao) {
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

    fun adicionarFixa(receita: Transacao) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                Log.d("TransacaoViewModel", "Adicionando transacao fixa... $receita")
                transacaoRepository.adicionarFixa(receita)
                _successEvent.value = true
                Log.d("TransacaoViewModel", "Transacao adicionada com sucesso: $receita")
            } catch (e: Exception) {
                _errorEvent.value = "Erro ao adicionar transacao fixa: ${e.message}"
            }
        }
    }

    fun adicionarDespesa(despesa: Transacao) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                Log.d("TransacaoViewModel", "Adicionando despesa... $despesa")
                transacaoRepository.adicionarDespesa(despesa)
                _successEvent.value = true
                Log.d("TransacaoViewModel", "Despesa adicionada com sucesso: $despesa")
            } catch (e: Exception) {
                _errorEvent.value = "Erro ao adicionar despesa: ${e.message}"
            }
        }
    }

    fun listarTransacoes(id: Int): LiveData<List<Transacao>>{
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = transacaoRepository.listarTransacoes(id)
                if (response.isSuccessful) {
                    _transacoes.postValue(response.body())
                    val transacoes = response.body()
                    Log.d("TransacaoViewModel", "Trazendo transacoes do id ${id}: ${transacoes}")
                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("planejamentosViewModel", "Erro ao listar transacoes $erro")
                }
            } catch (e: Exception) {
                Log.e("TransacaoViewModel", "Erro ao listar transacoes", e)
            }
        }
        return transacoes
    }

}