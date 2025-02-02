package kmp.project.rickandmortyapp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import kmp.project.rickandmortyapp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rick_and_morty_database"

expect object RickMortyCTor:RoomDatabaseConstructor<RickMortyDatabase>

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCTor::class)
abstract class RickMortyDatabase: RoomDatabase() {
//    abstract fun characterDao(): CharacterDao
}