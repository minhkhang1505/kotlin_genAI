package com.nguyenminhkhang.genai.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextGenerationScreen(viewModel: CreateContentViewModel = viewModel()) {
    var inputText by remember { mutableStateOf(TextFieldValue("")) }

    val generatedContent by viewModel.generatedContent.observeAsState("Your content will be displayed here...")
    val isLoading by viewModel.loading.observeAsState(false)
    val errorMessage by viewModel.error.observeAsState()

    val scrollState = rememberScrollState()
    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Create content", color = Color.Black) },
//            )
//        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it)
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
                .padding(vertical = 5.dp),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 5.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
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
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray.copy(alpha = 0.3f), shape = MaterialTheme.shapes.small)
                        .padding(12.dp),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (inputText.text == "") {
                                Text(
                                    text = "Enter your text here...",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.LightGray
                                )
                            }
                            innerTextField() // nội dung người dùng gõ
                        }
                    }
                )

                // Display error (nếu có)
                errorMessage?.let {
                    Text(
                        text = it,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Generated content area
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(top = 16.dp, bottom = 50.dp)
                ) {
                    Text(
                        text = if (isLoading) "Đang tạo nội dung..." else generatedContent,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray.copy(alpha = 0.1f), shape = MaterialTheme.shapes.small)
                            .padding(12.dp)
                            .heightIn(min = 300.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
            // Button to trigger content generation
            Button(
                onClick = {
                    viewModel.generateVideoContent(inputText.text)
                },
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(horizontal = 16.dp),
                enabled = !isLoading,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6F00EE), // Màu nền
                    contentColor = Color.White           // Màu chữ/icon
                )
            ) {
                Text(text = if (isLoading) "Đang xử lý..." else "Create Content")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTextGenerationScreen() {
    TextGenerationScreen()
}
