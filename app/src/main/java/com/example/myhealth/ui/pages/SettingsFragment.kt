package com.example.myhealth.ui.pages

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myhealth.R
import com.example.myhealth.databinding.FragmentLoginBinding
import com.example.myhealth.databinding.FragmentSettingsBinding
import com.example.myhealth.ui.Utils.ThemeUtils
import com.example.myhealth.ui.components.DialogWater
import com.example.myhealth.ui.components.DialogAboutApp

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    // Подключение View binding
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dark Theme
        val sharedPreferences = requireContext().getSharedPreferences("theme_prefs", Context.MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("current_theme", false)
        binding.switchTheme.isChecked = isDarkMode
        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            ThemeUtils.saveTheme(requireContext(), isChecked)
            ThemeUtils.applyTheme(requireContext())
            activity?.recreate()
        }

        // Navigation Component
        binding.btnLogout.setOnClickListener{
            findNavController().navigate(R.id.settings_to_login)
        }

        // Dialog
        binding.subtitle2Btn.setOnClickListener {
            DialogWater(
                onSubmitClickListener = { quantity ->
                    Toast.makeText(requireContext(), "1", Toast.LENGTH_SHORT).show()
                }
            ).show(parentFragmentManager, "dialog")
        }
        binding.subtitle3Btn.setOnClickListener {
            DialogAboutApp(
                onSubmitClickListener = { quantity ->
                    Toast.makeText(requireContext(), "2", Toast.LENGTH_SHORT).show()
                }
            ).show(parentFragmentManager, "dialog")
        }
    }
}