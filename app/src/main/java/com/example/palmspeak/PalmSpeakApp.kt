package com.example.palmspeak

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.palmspeak.ui.navigation.Screen
import com.example.palmspeak.ui.screen.about.AboutScreen
import com.example.palmspeak.ui.screen.alphabet.AlphabetScreen
import com.example.palmspeak.ui.screen.exercise.ExerciseScreen
import com.example.palmspeak.ui.screen.homescreen.HomeScreen
import com.example.palmspeak.ui.screen.introduction.IntroductionScreen
import com.example.palmspeak.ui.screen.word.WordScreen

@Composable
fun PalmSpeakApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navHostController = navController,
                    navigate = { title ->
                        navController.navigate(
                            when (title) {
                                context.getString(R.string.introduction) -> Screen.Introduction.route
                                context.getString(R.string.alphabet) -> Screen.Alphabet.route
                                context.getString(R.string.word) -> Screen.Word.route
                                context.getString(R.string.exercise) -> Screen.Exercise.route
                                else -> Screen.About.route
                            }
                        )
                    }
                )
            }
            composable(Screen.Introduction.route) {
                IntroductionScreen()
            }
            composable(Screen.Word.route) {
                WordScreen()
            }
            composable(Screen.Exercise.route) {
                ExerciseScreen()
            }
            composable(Screen.Alphabet.route) {
                AlphabetScreen()
            }
            composable(Screen.About.route) {
                AboutScreen()

            }
        }
    }
}