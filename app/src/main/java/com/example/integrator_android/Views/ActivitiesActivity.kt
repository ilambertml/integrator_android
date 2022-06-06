package com.example.integrator_android.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integrator_android.R
import com.example.integrator_android.databinding.ActivityActivitiesBinding

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activitiesBtn.setOnClickListener {
            navigateSuggestions()
        }
    }

    private fun navigateSuggestions(){
        val intent = Intent(this, SuggestionsActivity::class.java)
        startActivity(intent)
    }
}