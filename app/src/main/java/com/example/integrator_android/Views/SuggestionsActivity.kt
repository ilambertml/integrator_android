package com.example.integrator_android.Views

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.integrator_android.Application.Companion.prefs
import com.example.integrator_android.Model.APIService
import com.example.integrator_android.Model.ActivityResponse
import com.example.integrator_android.R
import com.example.integrator_android.databinding.ActivitySuggestionsBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Revisar porque Android dice que hay memory leak
private lateinit var binding: ActivitySuggestionsBinding


class SuggestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivitySuggestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true) // showing the back button in action bar

        getActivity()

    }
    private fun getActivity(){
        CoroutineScope(Dispatchers.IO).launch {
            var query="activity?"
            val participants = prefs.getParticipantsCounts()
            val category = prefs.getCategory()
            if(participants>0){
                if (category!="random"){
                    query += "participants=$participants&type=$category"
                } else {
                    query +="participants=$participants"
                }
            } else {
                if (category != "random") {
                    query += "type=$category"
                }
            }

            val activityResponse = getRetrofit()
                .create(APIService::class.java)
                .getActivity(query)

            val activity : ActivityResponse? = activityResponse.body()
            if(activityResponse.isSuccessful) {

                runOnUiThread {
                    binding.categoryTV.text=activity?.type
                    binding.activityTV.text = activity?.activity
                    binding.participantsTV.text = activity?.participants.toString()

                    var priceLevel = activity?.price.toString()
                    activity?.let {
                        if(it.price == 0.0){
                            priceLevel = "Free"
                        }else if (it.price <= 0.3){
                            priceLevel = "Low"
                        }else if (it.price <= 0.6){
                            priceLevel = "Medium"
                        }else{
                            priceLevel = "High"
                        }
                    }

                    binding.priceTV.text = priceLevel

                }
            } else {
                when(activityResponse.code()){
                    404 ->
                        Snackbar
                            .make(
                                binding.root,
                                "Error",
                                Snackbar.LENGTH_LONG)
                            .show()
                    403 -> Log.e("network", "forbiden")
                }
                Log.e("networking","error en retrofit")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // this event will enable the back function to the button on press:
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}