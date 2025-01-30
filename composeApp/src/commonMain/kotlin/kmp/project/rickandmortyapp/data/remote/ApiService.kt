package kmp.project.rickandmortyapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kmp.project.rickandmortyapp.data.remote.response.CharacterResponse

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get("api/character/$id").body()
    }

}