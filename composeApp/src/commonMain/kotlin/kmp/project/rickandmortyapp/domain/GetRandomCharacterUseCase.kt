package kmp.project.rickandmortyapp.domain

import kmp.project.rickandmortyapp.domain.model.CharacterModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacterUseCase(private val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {

//            val characterDataBase = repository.getSavedCharacter()

//        if (getCurrentDayOfTheYear == characterDataBase.date) {
//
//        } else {
//        }


        val random = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}