package com.example.anipanda.ui.fragments.sign.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.anipanda.R
import com.example.anipanda.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner) {
            if (it) {
                requireActivity().findNavController(R.id.nav_host_fragment_sign).navigate(R.id.action_loginFragment_to_registerFragment)
            } else {
                Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()

            }
        }
        binding.signInButton.setOnClickListener {
            val login = binding.loginEditText.editText?.text
            val password = binding.passwordEditText.editText?.text
            if(!login.isNullOrBlank() && !password.isNullOrBlank()) {
                viewModel.login(login.toString(), password.toString())
            } else {
                Toast.makeText(requireActivity(), "заполните поля", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment_sign).navigate(R.id.action_loginFragment_to_registerFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}