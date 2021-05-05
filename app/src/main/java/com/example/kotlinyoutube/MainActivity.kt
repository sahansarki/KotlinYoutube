package com.example.kotlinyoutube

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recyclerview_main.setBackgroundColor(ContextCompat.getColor(this,R.color.design_default_color_primary_dark))

        recyclerview_main.layoutManager = LinearLayoutManager(this)
        //recyclerview_main.adapter = MainAdapter()

        fetchJson()
    }

    private fun fetchJson() {
        println("Attempting o Fetch JSON")

        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)



                runOnUiThread{
                    recyclerview_main.adapter = MainAdapter(homeFeed)
                }
            }

        })

    }


}

data class HomeFeed(val videos: List<Video>)

data class Video(val id: Int , val name: String, val link : String, val imageUrl: String, val numberOfView: Int, val channel : Channel)

data class Channel(val name: String, val profileImageUrl: String , val numberOfSubscribers: Int)