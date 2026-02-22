package com.example.huellacarbono.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.huellacarbono.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            val familyKwh = binding.etFamilyKwh.text.toString().toDoubleOrNull() ?: 0.0
            val transportKmWeek = binding.etTransportKm.text.toString().toDoubleOrNull() ?: 0.0
            val lifestylePoints = binding.etLifestylePoints.text.toString().toDoubleOrNull() ?: 0.0

            val factorElectricidad = 0.43          // kg CO2e por kWh (ejemplo)
            val factorAutoGasolina = 0.192         // kg CO2e por km (ejemplo)
            val factorEstiloVida = 1.0             // kg CO2e por punto (ejemplo)

            val co2Familia = familyKwh * factorElectricidad
            val co2Transporte = (transportKmWeek * 4.33) * factorAutoGasolina
            val co2Estilo = lifestylePoints * factorEstiloVida

            val total = co2Familia + co2Transporte + co2Estilo

            binding.tvResult.text = "Huella estimada: %.2f kg CO₂e/mes".format(total)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
