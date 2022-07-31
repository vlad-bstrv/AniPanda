package com.example.anipanda.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.anipanda.R
import com.example.anipanda.data.UserData
import com.example.anipanda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
            !UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.signFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}