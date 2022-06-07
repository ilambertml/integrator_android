package com.example.integrator_android.Views

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.R


class TyCActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tyc_activity)

        val btnClose = findViewById<ImageButton>(R.id.btnClose)
        btnClose.setOnClickListener{
            onBackPressed()
        }

    }


}