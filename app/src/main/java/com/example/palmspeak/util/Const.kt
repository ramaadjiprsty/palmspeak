package com.example.palmspeak.util

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.palmspeak.R
import com.example.palmspeak.ui.theme.CardColor

val cardTexts = listOf(
    R.string.introduction,
    R.string.alphabet,
    R.string.word,
    R.string.exercise,
    R.string.about,
)

val cardImage = listOf(
    R.drawable.presentation,
    R.drawable.sign_language,
    R.drawable.choose,
    R.drawable.quiz,
    R.drawable.about
)

val cardColors = listOf(
    CardColor.introductionCard,
    CardColor.learningCard,
    CardColor.exerciseCard,
    CardColor.quizCard,
    CardColor.aboutCard
)

fun NavGraphBuilder.animatedComposable(
    route: String,
    content: @Composable () -> Unit
) {
    composable(
        route = route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300, easing = EaseInOut)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300, easing = EaseInOut)
            ).plus(
                fadeOut(animationSpec = tween(300))
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(300, easing = EaseInOut)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(300, easing = EaseInOut)
            ).plus(
                fadeOut(animationSpec = tween(300))
            )
        }
    ) {
        content()
    }
}