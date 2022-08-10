package com.example.ashana.retrofitwithokhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ashana.retrofitwithokhttp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: APIInterface
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiInterface = APIClient.getClient().create(APIInterface::class.java)

        getDataFromAPI()
        binding.progressCircular.visibility = View.VISIBLE
    }

    private fun getDataFromAPI() {
        var response: Call<Resources> = apiInterface.gteResources(1)
        response.enqueue(object : Callback<Resources>{
            override fun onResponse(call: Call<Resources>, response: Response<Resources>) {
                if (response.body() != null) {
                    println("Response body = ${response.body()}")
                    var resources: Resources = response.body()!!
                    accessResponse(resources)
                }
            }

            override fun onFailure(call: Call<Resources>, t: Throwable) {
                binding.progressCircular.visibility = View.GONE
                println("Error on request ${t.message}")
            }

        })
    }

    private fun accessResponse(response: Resources) {
        binding.progressCircular.visibility = View.GONE
        var firstName = response.data?.get(0)?.firstName
        binding.textTitle.text = firstName
    }
}