package com.nguyenminhkhang.genai

data class CohereCreateContentRequest(
    val model: String = "command",
    val prompt: String,
    val max_tokens: Int = 300,
    val temperature: Float = 0.7f
)
