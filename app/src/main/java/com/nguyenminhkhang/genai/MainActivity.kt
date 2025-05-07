package com.nguyenminhkhang.genai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nguyenminhkhang.genai.ui.theme.GenAITheme
import com.nguyenminhkhang.genai.screen.TextGenerationScreen
import com.nguyenminhkhang.genai.ui.screen.create_content.CreateContentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = CreateContentViewModel()
            GenAITheme {
                TextGenerationScreen(viewModel)
            }
        }
    }
}
