package com.example.anipanda.di

import com.example.anipanda.ui.fragments.sign.login.LoginViewModel
import com.example.anipanda.ui.fragments.sign.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel() }
}