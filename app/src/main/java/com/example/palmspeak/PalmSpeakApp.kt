package com.example.palmspeak

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.palmspeak.anim.fadeInSlideInTransition
import com.example.palmspeak.anim.fadeOutSlideOutTransition
import com.example.palmspeak.ui.navigation.Screen
import com.example.palmspeak.ui.screen.about.AboutScreen
import com.example.palmspeak.ui.screen.alphabet.AlphabetScreen
import com.example.palmspeak.ui.screen.exercise.ExerciseScreen
import com.example.palmspeak.ui.screen.homescreen.HomeScreen
import com.example.palmspeak.ui.screen.introduction.IntroductionScreen
import com.example.palmspeak.ui.screen.word.WordScreen
import com.example.palmspeak.ui.theme.headerColor
import com.example.palmspeak.util.animatedComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PalmSpeakApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var topAppBarTitle by remember { mutableStateOf(context.getString(R.string.app_name)) }
    var currentPage by remember { mutableStateOf(Screen.Home.route) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AnimatedContent(
                        targetState = topAppBarTitle,
                        label = "title",
                        transitionSpec = {
                            ContentTransform(
                                targetContentEnter = fadeIn(),
                                initialContentExit = fadeOut()
                            )
                        }
                        ) { targetTitle ->
                        Text(
                            text = targetTitle,
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .fillMaxWidth()
                        )
                    }
                },
                navigationIcon = {
                    if (currentRoute != Screen.Home.route) {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "back",
                            )
                        }
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.man),
                            contentDescription = "app logo",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(28.dp)
                        )
                    }
                },
                actions = {
                    LaunchedEffect(currentRoute) {
                        topAppBarTitle = when (currentRoute) {
                            Screen.Introduction.route -> context.getString(R.string.introduction)
                            Screen.Word.route -> context.getString(R.string.word)
                            Screen.Alphabet.route -> context.getString(R.string.alphabet)
                            Screen.Exercise.route -> context.getString(R.string.exercise)
                            Screen.About.route -> context.getString(R.string.about)
                            else -> context.getString(R.string.app_name)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(headerColor)
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            modifier = Modifier.padding(innerPadding)
        ) {
            animatedComposable(Screen.Home.route) {
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



            animatedComposable(Screen.Introduction.route) {
                IntroductionScreen()
            }
            animatedComposable(Screen.Alphabet.route) {
                AlphabetScreen()
            }
            animatedComposable(Screen.Word.route) {
                WordScreen()
            }
            animatedComposable(Screen.Exercise.route) {
                ExerciseScreen()
            }
            animatedComposable(Screen.About.route) {
                AboutScreen()
            }

//            composable(
//                Screen.Word.route,
//                enterTransition = {
//                    fadeInSlideInTransition() + slideIntoContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.Start
//                    )
//                },
//                exitTransition = {
//                    fadeOutSlideOutTransition() + slideOutOfContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.End
//                    )
//                }
//            ) {
//                WordScreen()
//            }
//            composable(
//                Screen.Exercise.route,
//                enterTransition = {
//                    fadeInSlideInTransition() + slideIntoContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.Start
//                    )
//                },
//                exitTransition = {
//                    fadeOutSlideOutTransition() + slideOutOfContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.End
//                    )
//                }
//            ) {
//                ExerciseScreen()
//            }
//            composable(
//                Screen.Alphabet.route,
//                enterTransition = {
//                    fadeInSlideInTransition() + slideIntoContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.Start
//                    )
//                },
//                exitTransition = {
//                    fadeOutSlideOutTransition() + slideOutOfContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.End
//                    )
//                }
//            ) {
//                AlphabetScreen()
//            }
//            composable(
//                Screen.About.route,
//                enterTransition = {
//                    fadeInSlideInTransition() + slideIntoContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.Start
//                    )
//                },
//                exitTransition = {
//                    fadeOutSlideOutTransition() + slideOutOfContainer(
//                        animationSpec = tween(300, easing = EaseIn),
//                        towards = AnimatedContentTransitionScope.SlideDirection.End
//                    )
//                }
//            ) {
//                AboutScreen()
//
//            }
        }
    }
}
