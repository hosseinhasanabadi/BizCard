package com.example.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme
import com.example.bizcard.ui.theme.LocalElevation
import com.example.bizcard.ui.theme.elevation
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
                    modifier = Modifier.fillMaxSize(300f),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally



                ) {
                    CreateImageProfile()
                    Divider()
                }


            }


        }
    }

    @Composable
    private fun CreateImageProfile(modifier: Modifier=Modifier) {
        Surface(
            modifier = Modifier
                .size(150.dp)
                .padding(5.dp), shape = CircleShape,
            border = BorderStroke(0.5.dp, Color.LightGray),
            tonalElevation = 50.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)

        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "profile image",
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Crop
            )


        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BizCardTheme {
            CreateBizCard()

        }
    }
}