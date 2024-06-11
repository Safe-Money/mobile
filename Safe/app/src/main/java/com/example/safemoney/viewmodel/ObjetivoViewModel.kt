package com.example.safemoney.telas_acao.inputs

import LoginViewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Objetivos
import com.example.safemoney.repositorio.ObjetivoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObjetivoViewModel(private val objetivoRepository: ObjetivoRepository, private val loginViewModel: LoginViewModel) : ViewModel() {

    companion object {
        private const val TAG = "ObjetivoViewModel"
    }

    private val _objetivos = MutableLiveData<List<Objetivos>>()
    val objetivos: LiveData<List<Objetivos>> = _objetivos

    init {
        getObjetivoById()
    }

    private val _objetivo = MutableLiveData<Objetivos>()
    val objetivo: LiveData<Objetivos> = _objetivo

    fun cadastrarObjetivo(objetivo: Objetivos) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG, "Iniciando cadastro do objetivo: $objetivo")
                objetivoRepository.cadastrarObjetivo(objetivo)
                Log.d(TAG, "Objetivo cadastrado com sucesso: $objetivo")
                getObjetivoById()
            } catch (e: Exception) {
                Log.e(TAG, "Erro ao cadastrar o objetivo: $objetivo", e)
            }
        }
    }

    fun adicionarValorInvestido(idObjetivo: Int, novoValorInvestido: Double) {
        val userId = loginViewModel.getId()
        if (userId != -1) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    Log.d(TAG, "Adicionando valor investido: $novoValorInvestido para o objetivo: $idObjetivo")
                    objetivoRepository.adicionarValorInvestido(idObjetivo, novoValorInvestido, userId)
                    Log.d(TAG, "Valor investido adicionado com sucesso")
                    getObjetivoById()
                } catch (e: Exception) {
                    Log.e(TAG, "Erro ao adicionar valor investido", e)
                }
            }
        } else {
            Log.e(TAG, "ID do usuário inválido")
        }
    }

    private fun getObjetivoById() {
        val userId = loginViewModel.getId()
        if (userId != -1) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = objetivoRepository.getObjetivoById(userId)
                    val objetivosList = response.body()
                    objetivosList?.let {
                        _objetivos.postValue(it)
                    } ?: Log.e(TAG, "Objetivos não encontrados para o ID: $userId")
                } catch (e: Exception) {
                    Log.e(TAG, "Erro ao obter os objetivos", e)
                }
            }
        } else {
            Log.e(TAG, "ID do usuário inválido")
        }
    }

    fun getObjetivoById1(objetivoId: Int) {
        val userId = loginViewModel.getId()
        if (userId != -1) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = objetivoRepository.getObjetivoByIdObj(objetivoId)
                    val objetivo = response.body()
                    objetivo?.let {
                        _objetivo.postValue(it)
                    } ?: Log.e(TAG, "Objetivo não encontrado para o ID: $objetivoId")
                } catch (e: Exception) {
                    Log.e(TAG, "Erro ao obter o objetivo por ID: $objetivoId", e)
                }
            }
        } else {
            Log.e(TAG, "ID do usuário inválido")
        }
    }

    fun editarObjetivo(idObjetivo: Int, novoObjetivo: Objetivos) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG, "Editando objetivo: $novoObjetivo")
                objetivoRepository.editarObjetivo(idObjetivo, novoObjetivo)
                Log.d(TAG, "Objetivo editado com sucesso")
                getObjetivoById1(idObjetivo)
            } catch (e: Exception) {
                Log.e(TAG, "Erro ao editar o objetivo", e)
            }
        }
    }

    fun deletarObjetivo(idObjetivo: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG, "Deletando objetivo: $idObjetivo")
                objetivoRepository.deletarObjetivo(idObjetivo)
                Log.d(TAG, "Objetivo deletado com sucesso")
                getObjetivoById()
            } catch (e: Exception) {
                Log.e(TAG, "Erro ao deletar o objetivo", e)
            }
        }
    }



}
