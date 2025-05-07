package com.nguyenminhkhang.genai.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.genai.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen () {
    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("GenAI", color = Color.Black) },
            )
        },
    ) {
        Column(
            modifier = Modifier.padding(it).background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF120C2F),
                        Color(0xFF1D1039),
                        Color(0xFF371E57),
                        Color(0xFF2F184C)
                    )
                )).fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()

            ) {
                //Box create content
                Column(
                    modifier = Modifier.padding(16.dp)
                        .weight(1f).height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f))
                            .fillMaxWidth().aspectRatio(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.icon_create_content),
                            contentDescription = "create content",
                            tint = Color.White,
                            modifier = Modifier.size(60.dp) )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Create Content", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onPrimary)
                }
                //Box create voice AI
                Column(
                    modifier = Modifier.padding(16.dp)
                        .weight(1f).height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f))
                            .fillMaxWidth().aspectRatio(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.icon_create_voice),
                            contentDescription = "create content",
                            tint = Color.White,
                            modifier = Modifier.size(60.dp) )

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Create Voice", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    HomeScreen()
}