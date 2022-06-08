package com.example.integrator_android.Model

import com.google.gson.annotations.SerializedName

data class ActivityResponse (
    @SerializedName("type") var type: String,
    @SerializedName("participants") var participants: Int,
    @SerializedName("activity") var activity: String,
    @SerializedName("price") var price: Double
)