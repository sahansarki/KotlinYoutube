package com.example.kotlinyoutube.Models

data class HomeFeed(val videos: List<Video>)

data class Video(val id: Int , val name: String, val link : String, val imageUrl: String, val numberOfView: Int, val channel : Channel)

data class Channel(val name: String, val profileimageUrl: String , val numberOfSubscribers: Int)
