package kmp.project.rickandmortyapp.di

import kmp.project.rickandmortyapp.domain.GetAllCharacterUseCase
import kmp.project.rickandmortyapp.domain.GetRandomCharacterUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacterUseCase)
    factoryOf(::GetAllCharacterUseCase)
}