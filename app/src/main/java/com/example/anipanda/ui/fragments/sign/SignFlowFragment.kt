package com.example.anipanda.ui.fragments.sign

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.anipanda.R

class SignFlowFragment: Fragment(R.layout.fragment_sign_flow) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_fragment_sign) as NavHostFragment
        navController = navHostFragment.navController

        setupNavigation()
    }

    private fun setupNavigation() {
//        requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.action_loginFragment_to_registerFragment)

    }
}