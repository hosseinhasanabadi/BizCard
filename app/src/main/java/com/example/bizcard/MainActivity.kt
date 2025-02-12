package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme
import com.example.bizcard.ui.theme.LocalElevation

import androidx.compose.material3.Card as Card

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCardTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }


            }
        }
    }


    @Composable
    fun CreateBizCard() {
        val buttonClickedState = remember {
            mutableStateOf(false)
        }
        Surface(
            modifier = Modifier
                // .fillMaxSize()
                //of  fillMaxHeight() and  .fillMaxWidth()
                .fillMaxHeight()
                .fillMaxWidth()

        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .padding(12.dp)
                    .width(200.dp)
                    .height(390.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = LocalElevation.current.extraSmall),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    CreateImageProfile()
                    Divider()
                    CreateInfo()
                    Button(
                        onClick = {
                            buttonClickedState.value = !buttonClickedState.value

                        }, modifier = Modifier
                            .padding(start = 20.dp)
                    ) {

                        Text(
                            text = "Portfolio",
                            style = MaterialTheme.typography.labelLarge
                        )

                    }
                    if (buttonClickedState.value) {
                        Content()
                    } else {
                        Box {
                        }
                    }
                }


            }


        }
    }

    @Composable
    fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            Surface(
                modifier = Modifier
                    .padding(3.dp)
                    .fillMaxSize(), shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                border = BorderStroke(width = 2.dp, color = Color.LightGray)
            ) {
                Portfolio(data = listOf("Project 1", "Project 2", "Project 3", "Project 4"))


            }

        }

    }

    private @Composable
    fun Portfolio(data: List<String>) {
        LazyColumn {
            items(data) { item ->
                Card(
                    modifier = Modifier
                        .padding(13.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    shape = RectangleShape
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(7.dp)
                    ) {
                        CreateImageProfile(modifier = Modifier.size(100.dp))
                        Column(
                            modifier = Modifier
                                .padding(7.dp)
                                .align(alignment = Alignment.CenterVertically)
                        ) {
                            Text(text = item, fontWeight = FontWeight.Bold)
                            Text(
                                text = "good",
                                style = MaterialTheme.typography.bodyMedium
                            )


                        }

                    }


                }


            }
        }


    }

    @Composable
    private fun CreateInfo() {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                text = "Miles P.",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Android Compose Programmer",
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = "@ThemilesCompose",
                modifier = Modifier.padding(3.dp),
            )


        }
    }


    @Composable
    private fun CreateImageProfile(modifier: Modifier = Modifier) {
        Surface(
            modifier = Modifier
                .size(150.dp)
                .padding(5.dp),
            shape = CircleShape,
            border = BorderStroke(0.5.dp, Color.LightGray),
            tonalElevation = 4.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "profile image",
                modifier = modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BizCardTheme {
            CreateBizCard()
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4"
                )
            )

        }
    }
}