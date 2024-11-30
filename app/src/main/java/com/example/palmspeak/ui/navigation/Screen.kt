package com.example.palmspeak.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Introduction : Screen("introduction")
    data object Word : Screen("word")
    data object Alphabet : Screen("alphabet")
    data object Exercise : Screen("exercise")
    data object About : Screen("about")


}