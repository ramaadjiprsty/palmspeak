package com.example.palmspeak

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.palmspeak.ui.navigation.Screen
import com.example.palmspeak.ui.screen.exercise.ExerciseScreen
import com.example.palmspeak.ui.screen.homescreen.Home
import com.example.palmspeak.ui.screen.introduction.IntroductionScreen
import com.example.palmspeak.ui.screen.learning.LearningScreen

@Composable
fun PalmSpeakApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                Home(
                    navHostController = navController,
                    navigate = { title ->
                        navController.navigate(
                            when (title) {
                                "Introduction" -> Screen.Introduction.route
                                "Learning" -> Screen.Learning.route
                                else -> Screen.Exercise.route
                            }
                        )
//                        when (title) {
//                            R.string.introduction.toString() -> navController.navigate(Screen.Introduction.route)
//                            R.string.learning.toString() -> navController.navigate(Screen.Learning.route)
//                        }
                    }
                )
            }
            composable(Screen.Introduction.route) {
                IntroductionScreen()
            }
            composable(Screen.Learning.route) {
                LearningScreen()
            }
            composable(Screen.Exercise.route) {
                ExerciseScreen()
            }

        }
    }
}