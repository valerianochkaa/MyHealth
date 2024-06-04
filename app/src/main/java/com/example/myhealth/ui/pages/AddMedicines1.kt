package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentAddMedicines1Binding

class AddMedicines1 : Fragment(R.layout.fragment_add_medicines1) {
    private var _binding: FragmentAddMedicines1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddMedicines1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        val navigationMap = mapOf(
            binding.btnPill to R.id.addMedicines1_to_addMedicines2,
            binding.btnBack to R.id.addMedicines1_to_calendar,
        )
        navigationMap.forEach { (view, destination) ->
            view.setOnClickListener {
                findNavController().navigate(destination)
            }
        }
    }
}