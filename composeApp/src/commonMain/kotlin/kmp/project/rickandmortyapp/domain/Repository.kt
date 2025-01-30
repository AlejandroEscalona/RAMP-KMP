package kmp.project.rickandmortyapp.domain

import kmp.project.rickandmortyapp.domain.model.CharacterModel

interface Repository {

    suspend fun getSingleCharacter(id: String): CharacterModel


}