package com.example.integrator_android.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integrator_android.ActivitiesListAdapter
import com.example.integrator_android.databinding.ActivityActivitiesBinding

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding
    private var activitiesList: MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 1..20){
            activitiesList.add(i.toString())
        }

        val listAdapter = ActivitiesListAdapter(this,activitiesList)
        binding.activitiesLV.adapter = listAdapter
        
        binding.activitiesLV.setOnItemClickListener { parent, view, position, id ->
            navigateSuggestions()
        }

    }

    private fun navigateSuggestions(){
        val intent = Intent(this, SuggestionsActivity::class.java)
        startActivity(intent)
    }
}