package kmp.project.rickandmortyapp.data.remote.response

import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val image: String,
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id.toString(),
            name = name,
            isAlive = status.lowercase() == "alive",
            species = species,
            type = type,
            image = image,
        )
    }
}
