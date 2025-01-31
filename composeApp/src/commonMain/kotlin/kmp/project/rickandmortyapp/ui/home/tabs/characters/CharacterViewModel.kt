package kmp.project.rickandmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kmp.project.rickandmortyapp.domain.GetAllCharacterUseCase
import kmp.project.rickandmortyapp.domain.GetRandomCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(
    val getRandomCharacterUseCase: GetRandomCharacterUseCase,
    val getAllCharacterUseCase: GetAllCharacterUseCase
):ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getRandomCharacterUseCase().let { character ->
                    _state.update { it.copy(characterOfTheDay = character) }
                }
                getAllCharacterUseCase(1).let { characters ->
                    _state.update { it.copy(characters = characters) }
                }
            }
        }

    }
}