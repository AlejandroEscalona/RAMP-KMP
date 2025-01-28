package kmp.project.rickandmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform