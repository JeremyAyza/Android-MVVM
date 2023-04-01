package com.myprojects.ejemplomvvm.core

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

  fun getRetrofit():Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://api-joi-inventory2.onrender.com")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}