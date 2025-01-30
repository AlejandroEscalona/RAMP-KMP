package kmp.project.rickandmortyapp.data

import kmp.project.rickandmortyapp.data.remote.ApiService
import kmp.project.rickandmortyapp.domain.Repository
import kmp.project.rickandmortyapp.domain.model.CharacterModel

class RepositoryImpl(
    private val api: ApiService
): Repository {

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

}