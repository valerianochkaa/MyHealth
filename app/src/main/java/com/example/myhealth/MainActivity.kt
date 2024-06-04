package com.example.myhealth

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myhealth.ui.Utils.ThemeUtils
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ThemeUtils.applyTheme(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navigation Component
        val navController = findNavController(R.id.nav_host_fragment)
        val navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.calendarFragment -> navView.visibility = View.VISIBLE
                R.id.medicinesFragment -> navView.visibility = View.VISIBLE
                R.id.diaryFragment -> navView.visibility = View.VISIBLE
                R.id.settingsFragment -> navView.visibility = View.VISIBLE
                else -> navView.visibility = View.GONE
            }
        }
    }
}