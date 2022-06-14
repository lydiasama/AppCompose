package com.practice.simple.appcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.simple.appcompose.ui.theme.AppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppComposeTheme {
                PreviewMessageCard()
            }
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

@Composable
fun Icon(@DrawableRes imageRes: Int) {
    AppComposeTheme {
        Box(
            Modifier
                .size(48.dp)
                .wrapContentSize(Alignment.Center)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Icon"
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    AppComposeTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(R.drawable.ic_launcher_foreground)

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(vertical = 10.dp)
                    .padding(end = 5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                MessageCard("Text1234567", Color.Blue)
                MessageCard("Text3", Color.Cyan)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(start = 5.dp, end = 10.dp),
                horizontalAlignment = Alignment.End
            ) {
                MessageCard("Text2345678", Color.Red)
                MessageCard("Text4", Color.parse("#F556FF"))
            }
        }
    }
}

fun Color.Companion.parse(colorString: String): Color =
    Color(android.graphics.Color.parseColor(colorString))
