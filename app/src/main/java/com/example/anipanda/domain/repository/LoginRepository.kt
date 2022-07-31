package com.example.anipanda.domain.repository

interface LoginRepository {
     fun signIn(login: String, password: String): Boolean
}