package com.example.safemoney.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.safemoney.model.Categoria
import com.example.safemoney.repositorio.ICategoriaRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CategoriaViewModel(private val categoriaRepository: ICategoriaRepository) : ViewModel() {


    private val _categoriaLiveData = MutableLiveData<List<Categoria>>()
    val contasLiveData: LiveData<List<Categoria>> = _categoriaLiveData
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("CategoriaViewModel", "Erro ", exception)
    }

    fun listarCategorias(): LiveData<List<Categoria>> {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            try {
                val response = categoriaRepository.listarCategoria()
                if (response.isSuccessful) {
                    _categoriaLiveData.postValue(response.body())
                    Log.e("CategoriaViewModel", "listar as categorias $response")


                } else {
                    val erro = response.errorBody()?.string() ?: "Erro desconhecido"
                    Log.e("categoriasViewModel", "Erro ao listar as categorias $erro")
                }
            } catch (e: Exception) {
                Log.e("categoriasViewModel", "Erro ao listar as contas", e)
            }
        }
        return contasLiveData
    }

}
