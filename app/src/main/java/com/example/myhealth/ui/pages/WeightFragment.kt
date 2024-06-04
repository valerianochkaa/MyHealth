package com.example.myhealth.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentWeightBinding
import com.example.myhealth.ui.adapters.WeightAdapter
import com.example.myhealth.ui.data.WeightDate
import java.util.ArrayList

class WeightFragment : Fragment(R.layout.fragment_weight) {
    private var _binding: FragmentWeightBinding? = null
    private val binding get() = _binding!!
    private var weightList = ArrayList<WeightDate>()
    private lateinit var adapter: WeightAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigation Component
        binding.btnBack.setOnClickListener{
            findNavController().navigate(R.id.weight_to_diary)
        }
        // Recycler View
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        addDataToList()
        adapter = WeightAdapter(weightList, context)
        binding.recyclerView.adapter = adapter
    }

    private fun addDataToList() {
        weightList.add(WeightDate(55.0,"01.01.2024"))
        weightList.add(WeightDate(55.5,"02.01.2024"))
        weightList.add(WeightDate(55.4,"03.01.2024"))
        weightList.add(WeightDate(54.7,"04.01.2024"))
    }
}