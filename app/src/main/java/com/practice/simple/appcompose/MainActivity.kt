package com.practice.simple.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewMessageCard()
        }
    }
}

@Composable
fun MessageCard(name: String, color: Color = Color.Unspecified) {
    Row {
        Text(text = "Hello")
        Text(
            text = " $name!",
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    Row(modifier = Modifier.background(Color.White)) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            MessageCard("Text1234567", Color.Blue)
            MessageCard("Text3", Color.Cyan)
        }

        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(end = 10.dp),
            horizontalAlignment = Alignment.End
        ) {
            MessageCard("Text2345678", Color.Red)
            MessageCard("Text4", Color.parse("#F556FF"))
        }
    }
}

fun Color.Companion.parse(colorString: String): Color =
    Color(android.graphics.Color.parseColor(colorString))
