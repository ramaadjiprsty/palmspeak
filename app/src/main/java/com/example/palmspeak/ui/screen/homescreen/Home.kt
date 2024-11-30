package com.example.palmspeak.ui.screen.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.palmspeak.R
import com.example.palmspeak.ui.components.Card
import com.example.palmspeak.ui.navigation.Screen
import com.example.palmspeak.util.cardColors
import com.example.palmspeak.util.cardImage
import com.example.palmspeak.util.cardTexts

@Composable
fun Home(
    navHostController: NavHostController,
    navigate: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                Text(
                    text = stringResource(R.string.lets_learn),
                    fontSize = 26.sp,
                )
                Text(
                    text = stringResource(R.string.idn_sign_language),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            itemsIndexed(cardTexts) { index, text ->
//                val screen = when (text) {
//                    R.string.introduction -> Screen.Introduction
//                    else -> Screen.Introduction // Default to Introduction
//                }
                Card( // Call your Card composable here
                    cardText = stringResource(text),
                    cardColor = cardColors[index % cardColors.size],
                    image = cardImage[index % cardImage.size],
                    navController = navHostController,
                    navigate = navigate
                )
            }
        }
    }
}