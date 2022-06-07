package com.example.integrator_android.Views

import android.R.attr.text
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.ActivitiesListAdapter
import com.example.integrator_android.R
import com.example.integrator_android.databinding.ActivityActivitiesBinding


class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activitiesList: List<String> = listOf(getString(R.string.actRandom),
            getString(R.string.actEducation), getString(R.string.actRec), getString(R.string.actSocial),
            getString(R.string.actDIY), getString(R.string.actCharity), getString(R.string.actCooking),
            getString(R.string.actRelaxation), getString(R.string.actMusic), getString(R.string.actBusywork))

        val listAdapter = ActivitiesListAdapter(this,activitiesList)
        binding.activitiesLV.adapter = listAdapter
        
        binding.activitiesLV.setOnItemClickListener { parent, view, position, id ->
            navigateSuggestions()
        }

        supportActionBar?.apply {
            title = getString(R.string.titleActivities)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val defaultValue = 0
        val sharedPreferences = getSharedPreferences("preference_participants", Context.MODE_PRIVATE )
        val participants = sharedPreferences.getInt("participants", defaultValue)

        val toast = Toast.makeText(
            applicationContext,
            "Cantidad de participantes: $participants ",
            Toast.LENGTH_SHORT
        )
        toast.show()





    }

    private fun navigateSuggestions(){
        val intent = Intent(this, SuggestionsActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}