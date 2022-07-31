package com.example.anipanda.data

import android.util.Log
import com.example.anipanda.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth

class MockLoginRepositoryImpl:LoginRepository {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun signIn(login: String, password: String): Boolean {
        var result = false
        auth.signInWithEmailAndPassword(login, password).addOnCompleteListener {
            if (it.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("TAG", "signInWithEmail:success")
                val user = auth.currentUser
                result = true
            } else {
                // If sign in fails, display a message to the user.
                Log.w("TAG", "signInWithEmail:failure", it.exception)
            }
        }
        return result
    }
}