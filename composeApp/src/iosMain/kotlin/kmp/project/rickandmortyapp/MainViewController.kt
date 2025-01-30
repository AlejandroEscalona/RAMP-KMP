package kmp.project.rickandmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import kmp.project.rickandmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }