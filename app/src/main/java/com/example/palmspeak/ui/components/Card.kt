package com.example.palmspeak.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.palmspeak.ui.navigation.Screen
import com.example.palmspeak.util.cardTexts

@Composable
fun Card(
    cardText: String,
    cardColor: Color,
    image: Int,
    navController: NavHostController,
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
        ),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .size(160.dp)
            .clickable { navigate(cardText) },
        shape = RoundedCornerShape(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                alignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp)
                    .padding(8.dp)
            )
            Text(
                text = cardText,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight(),
                color = Color.Black
            )
        }
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//
//        }
    }
}