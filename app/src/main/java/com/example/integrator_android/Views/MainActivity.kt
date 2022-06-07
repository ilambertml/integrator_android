package com.example.integrator_android.Views

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.Application.Companion.prefs
import com.example.integrator_android.Views.activitiesList.ActivitiesActivity
import com.example.integrator_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numParticipants: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            val participants = findViewById<EditText>(com.example.integrator_android.R.id.editTextParticipants)
            numParticipants = participants.text.toString()
            if (numParticipants == ""){
                numParticipants = "0"
            }
            val numPart = numParticipants.toInt()
            prefs.saveParticipantsCounts(numPart)
            navigateActivities()
        }
        
        binding.TandCBtn.setOnClickListener { 
            navigateTandC()
        }
    }
    
    private fun navigateTandC(){
        //obtain participant number

        val intent = Intent(this, TyCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateActivities() {
        val intent = Intent(this, ActivitiesActivity::class.java)
        startActivity(intent)
    }
}