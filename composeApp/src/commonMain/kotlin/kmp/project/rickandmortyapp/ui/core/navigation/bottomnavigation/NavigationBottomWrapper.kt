package kmp.project.rickandmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kmp.project.rickandmortyapp.ui.core.navigation.Routes
import kmp.project.rickandmortyapp.ui.home.tabs.characters.CharactersScreen
import kmp.project.rickandmortyapp.ui.home.tabs.episodes.EpisodesScreen

@Composable
fun NavigationBottomWrapper(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characteres.route) {
            CharactersScreen()
        }
    }
}