package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentAddMedicines3Binding

class AddMedicines3 : Fragment(R.layout.fragment_add_medicines3) {
    private var _binding: FragmentAddMedicines3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddMedicines3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        val navigationMap = mapOf(
            binding.btnAdd to R.id.addMedicines3_to_calendar,
            binding.btnBack to R.id.addMedicines3_to_addMedicines2,
        )
        navigationMap.forEach { (view, destination) ->
            view.setOnClickListener {
                findNavController().navigate(destination)
            }
        }
    }
}