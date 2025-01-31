package kmp.project.rickandmortyapp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kmp.project.rickandmortyapp.data.remote.ApiService
import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.io.IOException

class CharactersPagingSource(
    private val api: ApiService
) : PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 1
            val response = api.getAllCharacters(page)
            val characters = response.results

            val nextKey = if (characters.isEmpty()) null else page + 1
            val prevKey = if (page == 1) null else page - 1

            return LoadResult.Page(
                data = characters.map { it.toDomain() },
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
             LoadResult.Error(e)
        }
    }
}