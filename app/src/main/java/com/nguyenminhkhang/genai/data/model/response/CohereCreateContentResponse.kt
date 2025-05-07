package com.nguyenminhkhang.genai.data.model.response

data class CohereCreateContentResponse(
    val generations: List<Generation>
)

data class Generation(
    val text: String
)

