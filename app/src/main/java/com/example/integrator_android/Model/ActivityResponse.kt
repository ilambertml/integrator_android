package com.example.integrator_android.Model

import com.google.gson.annotations.SerializedName

data class ActivityResponse (
    //TODO hay que cambiar estos parametros,lo deje asi para que ande el APIService
    @SerializedName("message") var activityList: List<String>
)