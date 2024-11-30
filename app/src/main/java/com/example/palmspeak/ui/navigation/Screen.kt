package com.example.palmspeak.ui.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Introduction : Screen("introduction")
    data object Learning : Screen("learning")
    data object Exercise : Screen("exercise")
    data object About : Screen("about")

}