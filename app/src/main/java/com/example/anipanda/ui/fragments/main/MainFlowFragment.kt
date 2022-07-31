package com.example.anipanda.ui.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.anipanda.R
import com.example.anipanda.databinding.FragmentMainFlowBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainFlowFragment : Fragment() {
    private var _binding: FragmentMainFlowBinding? = null
    private val binding get() = _binding!!
    private val mAuth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainFlowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signOutButton.setOnClickListener {
            mAuth.signOut()
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_signFlowFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}