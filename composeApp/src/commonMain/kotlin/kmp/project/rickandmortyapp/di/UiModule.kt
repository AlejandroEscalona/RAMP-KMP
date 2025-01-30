package kmp.project.rickandmortyapp.di

import kmp.project.rickandmortyapp.ui.home.tabs.characters.CharacterViewModel
import kmp.project.rickandmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharacterViewModel)
}