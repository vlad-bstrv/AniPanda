package com.example.anipanda.di

import com.example.anipanda.data.MockLoginRepositoryImpl
import com.example.anipanda.domain.repository.LoginRepository
import org.koin.dsl.module

val appModule = module {
    single<LoginRepository> { MockLoginRepositoryImpl() }
}