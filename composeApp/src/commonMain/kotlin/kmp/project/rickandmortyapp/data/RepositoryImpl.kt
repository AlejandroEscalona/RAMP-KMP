package kmp.project.rickandmortyapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kmp.project.rickandmortyapp.data.remote.ApiService
import kmp.project.rickandmortyapp.data.remote.paging.CharactersPagingSource
import kmp.project.rickandmortyapp.domain.Repository
import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val api: ApiService,
    private val pagingSource: CharactersPagingSource
) : Repository {

    companion object {
        private const val PAGE_SIZE = 20
        private const val PREFETCH_DISTANCE = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(page: Int): Flow<PagingData<CharacterModel>> {
        return Pager(config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE
        ),
            pagingSourceFactory = { pagingSource }
        ).flow
    }

}