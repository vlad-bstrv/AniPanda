package com.example.anipanda.ui.fragments.sign.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.anipanda.R
import com.example.anipanda.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    val viewModel: LoginViewModel by viewModel()
    private val mAuth = Firebase.auth

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.getData().observe(viewLifecycleOwner) {
//            if (it) {
//                requireActivity().findNavController(R.id.nav_host_fragment_sign).navigate(R.id.action_loginFragment_to_registerFragment)
//            } else {
//                Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
//
//            }
//        }
        binding.signInButton.setOnClickListener {
            val login = binding.emailEditText.editText?.text
            val password = binding.passwordEditText.editText?.text
            if(!login.isNullOrBlank() && !password.isNullOrBlank()) {
                mAuth.signInWithEmailAndPassword(login.toString(), password.toString())
                    .addOnSuccessListener {
                        Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_mainFlowFragment)
                    }
            } else {
                Toast.makeText(requireActivity(), "заполните поля", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}