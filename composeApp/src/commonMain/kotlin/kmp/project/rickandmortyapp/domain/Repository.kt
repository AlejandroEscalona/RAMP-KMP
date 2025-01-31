package kmp.project.rickandmortyapp.domain

import androidx.paging.PagingData
import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getSingleCharacter(id: String): CharacterModel

    fun getAllCharacters(page: Int): Flow<PagingData<CharacterModel>>
}