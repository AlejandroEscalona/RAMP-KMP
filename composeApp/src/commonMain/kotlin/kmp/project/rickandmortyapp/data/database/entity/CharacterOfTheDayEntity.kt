package kmp.project.rickandmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val isAlive: Boolean,
    val species: String,
    val type: String,
    val image: String,
    val selectedDate:String
)
