package kmp.project.rickandmortyapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kmp.project.rickandmortyapp.ui.core.navigation.bottomnavigation.BottomBarItem
import kmp.project.rickandmortyapp.ui.core.navigation.bottomnavigation.BottomBarItem.*
import kmp.project.rickandmortyapp.ui.core.navigation.bottomnavigation.NavigationBottomWrapper

@Composable
fun HomeScreen() {
    val items = listOf(Episodes(), Characters())
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(items = items, navController = navController)
        }
    ) {
        Box {
            NavigationBottomWrapper(navController = navController)
        }
    }
}

@Composable
fun BottomNavigation(items: List<BottomBarItem>, navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.route == currentRoute,
                onClick = {
                    navController.navigate(route = item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = item.icon,
                label = { Text(text = item.title) },
                alwaysShowLabel = false
            )
        }
    }
}