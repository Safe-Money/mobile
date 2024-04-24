package com.example.safemoney.di

import CadastrarRepository
import ICadastrarRepository

import com.example.safemoney.viewmodel.CadastroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule: Module = module {
    single<ICadastrarRepository> {
        CadastrarRepository()
    }
    viewModel{
        CadastroViewModel(get())
    }

}
