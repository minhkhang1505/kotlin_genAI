package com.nguyenminhkhang.genai.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.cohere.ai/v1/") // Base URL
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: CohereCreateContentApi = retrofit.create(CohereCreateContentApi::class.java)
}