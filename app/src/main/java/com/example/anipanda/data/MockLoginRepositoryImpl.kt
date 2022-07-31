package com.example.anipanda.data

import com.example.anipanda.domain.repository.LoginRepository

class MockLoginRepositoryImpl:LoginRepository {
    override fun signIn(login: String, password: String): Boolean {
        return login == "login" && password == "password"
    }
}