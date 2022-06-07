package com.example.integrator_android.Views

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numParticipants: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.startBtn.setOnClickListener {
            val participants = findViewById<EditText>(com.example.integrator_android.R.id.editTextParticipants)
            numParticipants = participants.text.toString()
            if (numParticipants == ""){
                numParticipants = "0"
            }
            val numPart = numParticipants.toInt()
            navigateActivities(numPart)
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

    private fun navigateActivities(participants: Int){


        val intent = Intent(this, ActivitiesActivity::class.java).apply {
            putExtra("participants",participants)
        }
        startActivity(intent)
    }
}