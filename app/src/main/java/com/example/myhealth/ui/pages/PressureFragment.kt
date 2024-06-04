package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentPressureBinding
import com.example.myhealth.ui.adapters.PressureAdapter
import com.example.myhealth.ui.data.PressureDate
import java.util.ArrayList

class PressureFragment : Fragment(R.layout.fragment_pressure) {
    private var _binding: FragmentPressureBinding? = null
    private val binding get() = _binding!!
    private var pressureList = ArrayList<PressureDate>()
    private lateinit var adapter: PressureAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPressureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.pressure_to_diary)
        }
        // Recycler View
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = PressureAdapter(pressureList, context)
        binding.recyclerView.adapter = adapter
    }

    private fun addDataToList() {
        pressureList.add(PressureDate(120,80, 70, "01.01.2024"))
        pressureList.add(PressureDate(118,78, 75, "01.01.2024"))
        pressureList.add(PressureDate(122,78, 72, "02.01.2024"))
    }
}