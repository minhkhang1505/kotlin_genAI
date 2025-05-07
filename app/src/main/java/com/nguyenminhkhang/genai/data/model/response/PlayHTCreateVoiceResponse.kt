package com.nguyenminhkhang.genai.data.model.response

import com.google.gson.annotations.SerializedName

data class PlayHTCreateVoiceResponse(
    @SerializedName("audioUrl") val audioUrl: String
)
