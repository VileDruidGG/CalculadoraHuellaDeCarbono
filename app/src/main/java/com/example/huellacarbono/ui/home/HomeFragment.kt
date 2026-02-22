package com.example.huellacarbono.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.huellacarbono.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // (Opcional) Esto demuestra “vista código”, aunque ya lo tengas en XML
        binding.tvTitle.text = "Huella de carbono"
        binding.tvBody.text =
            "La huella de carbono es la cantidad de gases de efecto invernadero generados por nuestras actividades diarias. Aquí podrás ver información y acceder a una calculadora por categorías."
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
