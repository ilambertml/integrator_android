package com.example.integrator_android.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.integrator_android.R
import com.example.integrator_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.startBtn.setOnClickListener { 
            navigateActivities()
        }
        
        binding.TandCBtn.setOnClickListener { 
            navigateTandC()
        }
    }
    
    private fun navigateTandC(){
        val intent = Intent(this, TyCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateActivities(){
        val intent = Intent(this, ActivitiesActivity::class.java)
        startActivity(intent)
    }
}