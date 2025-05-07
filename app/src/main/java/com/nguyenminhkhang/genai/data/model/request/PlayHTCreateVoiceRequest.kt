package com.nguyenminhkhang.genai.data.model.request

data class PlayHTCreateVoiceRequest(
    val voice: String = "en-US-JennyNeural",  // chọn voice khác nếu muốn
    val content: String,
    val speed: Float = 1.0f
)
