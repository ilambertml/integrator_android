package com.example.integrator_android.Views

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.Application
import com.example.integrator_android.R
import com.example.integrator_android.databinding.ActivityTycActivityBinding


class TyCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTycActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTycActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener{
            onBackPressed()
        }

        //load and set state from file preferences
        val terms = Application.prefs.getStateTermsAndCondition()
        binding.chbxTermsAndCond.setChecked(terms)

        //event click on checkbox of terms and conditions
        binding.chbxTermsAndCond.setOnClickListener() {
            if (binding.chbxTermsAndCond.isChecked()){
                val not_checked = true
                Application.prefs.saveTermsAndCondition(not_checked)
            } else {
                val checked = false
                Application.prefs.saveTermsAndCondition(checked)
            }

        }



    }

    private fun navigateTandC(){
        //obtain participant number

        val intent = Intent(this, TyCActivity::class.java)
        startActivity(intent)
    }


}
