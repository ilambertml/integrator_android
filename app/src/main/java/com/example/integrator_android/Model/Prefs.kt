package com.example.integrator_android.Model

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs(private val context: Context) {
    val SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_NAME"
    private val PARTICIPANTS_COUNT = "PARTICIPANTS_COUNT"
    private val CATEGORY = "CATEGORY"

    private val storage = context.getSharedPreferences(SHARED_PREFERENCE_NAME,MODE_PRIVATE)

    fun saveParticipantsCounts(participants : Int) {
        storage.edit().putInt(PARTICIPANTS_COUNT,participants).apply()
    }
    fun getParticipantsCounts():Int{
        return storage.getInt(PARTICIPANTS_COUNT,0)
    }

    fun saveCategory(category : String) {
        storage.edit().putString(CATEGORY,category).apply()
    }
    fun getCategory():String{
        return storage.getString(CATEGORY,"") ?: ""
    }
}