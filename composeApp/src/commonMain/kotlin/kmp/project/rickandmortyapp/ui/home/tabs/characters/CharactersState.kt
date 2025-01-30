package kmp.project.rickandmortyapp.ui.home.tabs.characters

import kmp.project.rickandmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null,
)
