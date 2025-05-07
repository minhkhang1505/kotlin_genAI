package com.nguyenminhkhang.genai.data.api

import retrofit2.Call
import com.nguyenminhkhang.genai.data.model.request.PlayHTCreateVoiceRequest
import com.nguyenminhkhang.genai.data.model.response.PlayHTCreateVoiceResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface PlayHTCreateVoiceApi {
    @POST("api/v2/tts")
    fun synthesizeSpeech(
        @Body body: PlayHTCreateVoiceRequest,
        @Header("Authorization") auth: String,
        @Header("X-User-ID") userId: String
    ): Call<PlayHTCreateVoiceResponse>
}