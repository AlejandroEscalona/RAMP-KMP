package kmp.project.rickandmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import kmp.project.rickandmortyapp.ui.core.navigation.Routes

sealed class BottomBarItem {
    abstract val route:String
    abstract val title:String
    abstract val icon: @Composable () -> Unit

    data class Episodes(
        override val route: String = Routes.Episodes.route,
        override val title: String = "Episodes",
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Done, contentDescription = "Home")
        }
    ): BottomBarItem()

    data class Characters(
        override val route: String = Routes.Characteres.route,
        override val title: String = "Characters",
        override val icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Characters")
        }
    ): BottomBarItem()
}