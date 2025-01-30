package kmp.project.rickandmortyapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.encodedPath
import io.ktor.serialization.kotlinx.json.json
import kmp.project.rickandmortyapp.data.RepositoryImpl
import kmp.project.rickandmortyapp.data.remote.ApiService
import kmp.project.rickandmortyapp.domain.Repository
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation){
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
                    encodedPath = "api"
//                    parameters.append("key", "value")
                }
            }
        }
    }
    factoryOf(::ApiService)
    factoryOf(::RepositoryImpl) bind Repository::class}