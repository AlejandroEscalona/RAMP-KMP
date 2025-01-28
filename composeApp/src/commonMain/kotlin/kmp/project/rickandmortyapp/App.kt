package kmp.project.rickandmortyapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import kmp.project.rickandmortyapp.ui.core.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}