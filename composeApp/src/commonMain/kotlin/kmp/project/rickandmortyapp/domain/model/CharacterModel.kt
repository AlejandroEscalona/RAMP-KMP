package kmp.project.rickandmortyapp.domain.model

data class CharacterModel(
    val id: String,
    val name: String,
    val isAlive: Boolean,
    val species: String,
    val type: String,
    val image: String,
)
