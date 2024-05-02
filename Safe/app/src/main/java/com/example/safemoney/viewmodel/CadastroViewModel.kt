package com.example.safemoney.viewmodel

import ICadastrarRepository
import Usuario
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import retrofit2.Response

class CadastroViewModel(private val cadastrarRepository: ICadastrarRepository) : ViewModel() {


    private val _cadastroResultado = MutableLiveData<Boolean>()
    suspend fun cadastrarUsuario(nome: String, dtNascimento: String, email: String, senha: String): Boolean {
        Log.d("CadastroViewModel", "Iniciando cadastro do usuário: nome=$nome, dtNascimento=$dtNascimento, email=$email")
        val response: Response<Usuario> = cadastrarRepository.cadastrarUsuario(nome, dtNascimento, email, senha)
        val cadastroSucesso = response.isSuccessful
        if (cadastroSucesso) {
            val usuarioCadastrado = response.body()
            _cadastroResultado.value = response.isSuccessful
            Log.d("CadastroViewModel", "Cadastro realizado com sucesso: Usuário cadastrado: $usuarioCadastrado")
        } else {
            val erro = response.errorBody()?.string() ?: "Erro desconhecido"
            Log.d("CadastroViewModel", "Erro durante o cadastro: $erro")
            Log.d("CadastroViewModel", "Iniciando cadastro do usuário: nome=$nome, dtNascimento=$dtNascimento, email=$email, senha=$senha")
        }
        return cadastroSucesso
    }


}
