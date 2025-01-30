package kmp.project.rickandmortyapp.ui.home.tabs.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CharactersScreen() {
    val characterViewModel = koinViewModel<CharacterViewModel>()
    val state by characterViewModel.state.collectAsState()
    Column {
        if (state.characterOfTheDay != null) {
            Text(text = "Character of the day: ${state.characterOfTheDay!!.name}")
        }
    }
}