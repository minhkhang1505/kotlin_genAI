package com.nguyenminhkhang.genai.data.api

import com.nguyenminhkhang.genai.data.model.request.CohereCreateContentRequest
import com.nguyenminhkhang.genai.data.model.response.CohereCreateContentResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Call

interface CohereCreateContentApi {
    @Headers(
        "Authorization: Bearer T7XMJnVbF4djMBjtBRfZEFyrjyvF1QwVqOGnkECR",
        "Content-Type: application/json"
    )
    @POST("generate")
    fun generateContent(@Body request: CohereCreateContentRequest): Call<CohereCreateContentResponse>
}