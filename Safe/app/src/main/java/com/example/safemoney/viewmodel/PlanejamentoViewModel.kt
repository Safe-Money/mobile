package com.example.safemoney.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.planejamento.PlanejamentoItem
import com.example.safemoney.repositorio.IPlanejamentoRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanejamentoViewModel(
    private val planejamentoRepository: IPlanejamentoRepository
) : ViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("PlanejamentoViewModel", "Erro ao cadastrar um planejamento", exception)
    }


    private val _successEvent = MutableLiveData<Boolean>()
    val successEvent: LiveData<Boolean>
        get() = _successEvent

    private val _errorEvent = MutableLiveData<String>()
    val errorEvent: LiveData<String>
        get() = _errorEvent

    private val _planejamento = MutableLiveData<PlanejamentoItem>()
    val planejamento: LiveData<PlanejamentoItem>
        get() = _planejamento

    private val _planejamentos = MutableLiveData<List<PlanejamentoItem>>()
    val planejamentos: LiveData<List<PlanejamentoItem>>
        get() = _planejamentos

    fun cadastrarPlanejamento(planejamento: PlanejamentoItem){
        viewModelScope.launch {
            try{
                Log.d("PlanejamentoViewModel", "Realizando cadastro de planejamento: ${planejamento}")

                planejamentoRepository.cadastrarPlanejamento(planejamento);
                _successEvent.value = true

                Log.d("PlanejamentoViewModel", "Planejamento realizado com sucesso!")

            }catch (e: Exception){
                _errorEvent.value = "Erro ao cadastrar planejamento: ${e.message}"
            }
        }
    }
    fun getPorIdUser(id: Int): LiveData<List<PlanejamentoItem>>{
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = planejamentoRepository.getPorIdUser(id)
                if (response.isSuccessful) {
                    _planejamentos.postValue(response.body())
                    val planejamentos = response.body()
                    Log.d("PlanejamentoViewModel", "Trazendo planejamentos do id ${id}: ${planejamentos}")
                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("planejamentosViewModel", "Erro ao listar planejamentos $erro")
                }
            } catch (e: Exception) {
                Log.e("planejamentosViewModel", "Erro ao listar planejamentos", e)
            }
        }
        return planejamentos
    }

    fun getPorId(id: Int): LiveData<PlanejamentoItem>{
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = planejamentoRepository.getPorId(id)

                if (response.isSuccessful){
                    _planejamento.postValue(response.body())
                    val planejamento = response.body()
                    Log.d("PlanejamentoViewModel", "Trazendo o planejamento do id ${id}: ${planejamento}")
                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("planejamentosViewModel", "Erro ao trazer planejamento $erro")
                }
            }catch (e: Exception){
                Log.e("planejamentosViewModel", "Erro ao trazer o planejamento", e)
            }
        }

        return planejamento
    }

    fun excluirPlanejamento(id: Int) {
        viewModelScope.launch {
            try {
                Log.d("PlanejamentoViewModel", "Realizando exclusão de planejamento de id: ${id}")
                planejamentoRepository.excluirPlanejamento(id)
                _successEvent.value = true
                Log.d("PlanejamentoViewModel", "Exclusão realizada com sucesso!")
            } catch (e: Exception) {
                Log.e("PlanejamentoViewModel", "Erro ao excluir planejamento", e)
                _errorEvent.value = "Erro ao excluir planejamento: ${e.message}"
            }
        }
    }

    fun editarPlanejamento(planejamento: PlanejamentoItem, id: Int){
        viewModelScope.launch {
            try{
                Log.d("PlanejamentoViewModel", "Realizando edição de planejamento de id: ${id}")
                planejamentoRepository.editarPlanejamento(planejamento, id)
                _successEvent.value = true
                Log.d("PlanejamentoViewModel", "Edição realizada com sucesso!")
            }catch (e: Exception) {
                Log.e("PlanejamentoViewModel", "Erro ao editar planejamento", e)
                _errorEvent.value = "Erro ao editar planejamento: ${e.message}"
            }
        }
    }
}