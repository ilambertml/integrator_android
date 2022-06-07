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


class TyCActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tyc_activity)

        val btnClose = findViewById<ImageButton>(R.id.btnClose)
        btnClose.setOnClickListener{
            onBackPressed()
        }



        val chbxTermsAndCond = findViewById<CheckBox>(R.id.chbxTermsAndCond)
        chbxTermsAndCond.setOnClickListener() {
            if (chbxTermsAndCond.isChecked()){
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