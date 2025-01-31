package kmp.project.rickandmortyapp.data.remote.response

data class CharactersWrapperResponse(
    val info: InfoResponse,
    val results: List<CharacterResponse>
)
