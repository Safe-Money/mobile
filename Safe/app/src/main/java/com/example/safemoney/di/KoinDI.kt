package com.example.safemoney.di

import CadastrarRepository
import ContaViewModel
import ICadastrarRepository
import LoginRepository
import LoginViewModel
import UsuarioViewModel
import com.example.safemoney.repositorio.ContaRepository
import com.example.safemoney.repositorio.IContaRepository
import com.example.safemoney.repositorio.ILoginRepository
import com.example.safemoney.viewmodel.CadastroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module


val appModule: Module = module {
    single<ICadastrarRepository> { CadastrarRepository() }
    single<ILoginRepository> { LoginRepository() }
    single<IContaRepository> { ContaRepository() }
    single { UsuarioViewModel() }

    viewModel { CadastroViewModel(get()) }
    viewModel { ContaViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }


}
