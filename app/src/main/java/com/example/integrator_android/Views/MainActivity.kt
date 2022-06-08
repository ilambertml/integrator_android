package com.example.integrator_android.Views

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.Application.Companion.prefs
import com.example.integrator_android.Views.activitiesList.ActivitiesActivity
import com.example.integrator_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var numParticipants: String
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {

            val termsAndConditions = prefs.getStateTermsAndCondition()


            if (termsAndConditions) {
                val participants =
                    findViewById<EditText>(com.example.integrator_android.R.id.editTextParticipants)
                numParticipants = participants.text.toString()
                if (numParticipants == "") {
                    numParticipants = "0"
                }
                val numPart = numParticipants.toInt()
                prefs.saveParticipantsCounts(numPart)
                navigateActivities()
            } else {
                val toast = Toast.makeText(
                    applicationContext,
                    "Please accept terms and conditions",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }

        }



        binding.editTextParticipants.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(intInserted: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(intInserted: CharSequence, start: Int,
                                       before: Int, count: Int) {

                if (intInserted.length == 0){
                    binding.startBtn.setEnabled(false)
                } else {
                    binding.startBtn.setEnabled(true)
                }
                
            }
        })

        binding.textLinkTermsAndCond.setOnClickListener {
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