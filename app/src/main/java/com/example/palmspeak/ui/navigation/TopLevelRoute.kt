package com.example.palmspeak.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

//sealed class TopLevelRoute(val route: String) {
//
//}

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: ImageVector)

val topLevelRoutes = listOf(
    TopLevelRoute("Home", "home", Icons.Default.Home),
    TopLevelRoute("Search", "search", Icons.Default.Search),
    TopLevelRoute("Profile", "profile", Icons.Default.Person),
)