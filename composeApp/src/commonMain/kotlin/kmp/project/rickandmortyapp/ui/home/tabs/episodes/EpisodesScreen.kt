package kmp.project.rickandmortyapp.ui.home.tabs.episodes

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EpisodesScreen() {
    Box() {
        val name = helloName()
        Text(text = "Episodes $name")
    }
}

expect fun helloName(): String