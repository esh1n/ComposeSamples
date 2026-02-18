package com.esh1n.composesamples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.size(200.dp)
            .border(5.dp, Color.Red)
            .background(Color.White)
            .padding(32.dp)
            .border(5.dp, Color.Yellow)
            .background(Color.Green)
    ) {
        Text(text = "Some text", fontSize = 30.sp)
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}


