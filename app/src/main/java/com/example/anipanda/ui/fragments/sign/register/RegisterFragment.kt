package com.example.anipanda.ui.fragments.sign.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.anipanda.R
import com.example.anipanda.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModule: RegisterViewModel by viewModel()
    private val mAuth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signInButton.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment_sign)
                .navigate(R.id.action_registerFragment_to_loginFragment)
        }

        binding.signUpButton.setOnClickListener {
            val email = binding.emailEditText.editText?.text.toString()
            val password = binding.passwordEditText.editText?.text.toString()
            mAuth.createUserWithEmailAndPassword(email, password)
            requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_mainFlowFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}