package kmp.project.rickandmortyapp.ui.core.navigation

sealed class Routes (val route: String) {
    data object Home : Routes("home")


    //BottomNav
    data object Episodes : Routes("episodes")
    data object Characteres : Routes("characters")
}
