package com.nguyenminhkhang.genai

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateContentViewModel : ViewModel() {
    private val _generatedContent = MutableLiveData<String>()
    val generatedContent: LiveData<String> get() = _generatedContent

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun generateVideoContent(prompt: String) {
        _loading.value = true
        _error.value = null

        val request = CohereCreateContentRequest(
            prompt = prompt,
            max_tokens = 300,
            temperature = 0.7f
        )

        RetrofitClient.api.generateContent(request).enqueue(object : Callback<CohereCreateContentResponse> {
            override fun onResponse(call: Call<CohereCreateContentResponse>, response: Response<CohereCreateContentResponse>) {
                _loading.value = false
                if (response.isSuccessful) {
                    val text = response.body()?.generations?.firstOrNull()?.text?.trim()
                    _generatedContent.value = text ?: "Không có nội dung trả về."
                } else {
                    _error.value = "Lỗi từ server: ${response.code()}"
                    Log.e("CohereViewModel", "API error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<CohereCreateContentResponse>, t: Throwable) {
                _loading.value = false
                _error.value = "Lỗi kết nối: ${t.localizedMessage}"
                Log.e("CohereViewModel", "Network failure", t)
            }
        })
    }
}