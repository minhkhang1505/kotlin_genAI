package com.nguyenminhkhang.genai.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nguyenminhkhang.genai.CreateContentViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun TextGenerationScreen(viewModel: CreateContentViewModel = viewModel()) {
    var inputText by remember { mutableStateOf(TextFieldValue("Enter your text here...")) }

    val generatedContent by viewModel.generatedContent.observeAsState("Your content will be displayed here...")
    val isLoading by viewModel.loading.observeAsState(false)
    val errorMessage by viewModel.error.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF120C2F),
                        Color(0xFF1D1039),
                        Color(0xFF371E57),
                        Color(0xFF2F184C)
                    )
                )
            )
            .padding(vertical = 5.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Enter related text to create content for video",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Input Text Field
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                .padding(12.dp)
        )

        // Display error (nếu có)
        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Generated content area
        Text(
            text = if (isLoading) "Đang tạo nội dung..." else generatedContent,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                .padding(12.dp)
                .heightIn(min = 300.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Button to trigger content generation
        Button(
            onClick = {
                viewModel.generateVideoContent(inputText.text)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ) {
            Text(text = if (isLoading) "Đang xử lý..." else "Create Content")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTextGenerationScreen() {
    TextGenerationScreen()
}
