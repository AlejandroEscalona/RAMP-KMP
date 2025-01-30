package kmp.project.rickandmortyapp.domain

import kmp.project.rickandmortyapp.domain.model.CharacterModel

class GetRandomCharacterUseCase(private val repository: Repository) {

        suspend operator fun invoke(): CharacterModel {
            val random = (1..826).random()
            return repository.getSingleCharacter(random.toString())
        }
}