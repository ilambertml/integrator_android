package com.example.integrator_android

import android.app.Application
import com.example.integrator_android.Model.Prefs

class Application: Application(){
    companion object {
        lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}