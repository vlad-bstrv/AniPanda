package com.example.anipanda.ui.fragments.sign.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel():ViewModel() {

    private val liveData = MutableLiveData<Boolean>()
    fun getData(): LiveData<Boolean> = liveData

    fun login(login: String, password: String) {
//            liveData.value = repository.signIn(login, password)
    }

}

sealed class LoginState(){
    class Success(): LoginState()
    class Loading(): LoginState()
    class Error(): LoginState()
}