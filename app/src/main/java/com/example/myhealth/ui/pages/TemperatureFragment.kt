package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentTemperatureBinding
import com.example.myhealth.ui.adapters.TemperatureAdapter
import com.example.myhealth.ui.data.TemperatureDate
import java.util.ArrayList

class TemperatureFragment : Fragment(R.layout.fragment_temperature) {
    private var _binding: FragmentTemperatureBinding? = null
    private val binding get() = _binding!!
    private var temperatureList = ArrayList<TemperatureDate>()
    private lateinit var adapter: TemperatureAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTemperatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.temperature_to_diary)
        }
        // Recycler View
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = TemperatureAdapter(temperatureList, context)
        binding.recyclerView.adapter = adapter
    }
    private fun addDataToList() {
        temperatureList.add(TemperatureDate(36.7,"01.01.2024"))
        temperatureList.add(TemperatureDate(36.5,"02.01.2024"))
        temperatureList.add(TemperatureDate(36.6,"03.01.2024"))
        temperatureList.add(TemperatureDate(36.6,"04.01.2024"))
    }
}