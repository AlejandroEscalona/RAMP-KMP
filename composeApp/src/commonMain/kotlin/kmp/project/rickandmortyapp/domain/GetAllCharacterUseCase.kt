package kmp.project.rickandmortyapp.domain

import androidx.paging.PagingData
import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val repository: Repository) {

        suspend operator fun invoke(page: Int): Flow<PagingData<CharacterModel>> {
            return repository.getAllCharacters(page)
        }
}