package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment(R.layout.fragment_diary) {
    private var _binding: FragmentDiaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigation Component
        val navigationMap = mapOf(
            binding.cardWeight to R.id.diary_to_weight,
            binding.cardPressure to R.id.diary_to_pressure,
            binding.cardTemperature to R.id.diary_to_temperature,
            binding.cardWater to R.id.diary_to_water
        )
        navigationMap.forEach { (view, destination) ->
            view.setOnClickListener {
                findNavController().navigate(destination)
            }
        }
    }
}