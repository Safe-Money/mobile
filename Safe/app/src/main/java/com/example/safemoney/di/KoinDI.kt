package com.example.safemoney.di

import CadastrarRepository
import ContaViewModel
import ICadastrarRepository
import LancamentoViewModel
import LoginRepository
import LoginViewModel
import UsuarioViewModel
import com.example.safemoney.repositorio.CartaoRepository
import com.example.safemoney.repositorio.CategoriaRepository
import com.example.safemoney.viewmodel.CartaoViewModel
import com.example.safemoney.repositorio.ContaRepository
import com.example.safemoney.repositorio.ICartaoRepository
import com.example.safemoney.repositorio.ICategoriaRepository
import com.example.safemoney.repositorio.IContaRepository
import com.example.safemoney.repositorio.ILancamentoRepository
import com.example.safemoney.repositorio.ILoginRepository
import com.example.safemoney.repositorio.LancamentoRepository
import com.example.safemoney.viewmodel.CadastroViewModel
import com.example.safemoney.viewmodel.CategoriaViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module


val appModule: Module = module {
    single<ICadastrarRepository> { CadastrarRepository() }
    single<ILoginRepository> { LoginRepository() }
    single<IContaRepository> { ContaRepository() }
    single<ILancamentoRepository> { LancamentoRepository() }
    single<ICategoriaRepository> { CategoriaRepository() }
    single { CartaoRepository() }
    single { UsuarioViewModel() }

    viewModel { CadastroViewModel(get()) }
    viewModel { LancamentoViewModel(get()) }
    viewModel { ContaViewModel(get()) }
    viewModel { CategoriaViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { CartaoViewModel(get(), get()) }

}
