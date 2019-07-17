package de.moviesmpp.data

import de.moviesmpp.data.entity.PostEntity
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

private const val BASE_URL = "jsonplaceholder.typicode.com"

@Suppress("EXPERIMENTAL_API_USAGE")
class MoviesApi(clientEngine: HttpClientEngine) {

    private val client = HttpClient(clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    suspend fun getPopularMovies(): List<PostEntity> {
        // Actually we're able to just return the get()-call and Ktor's JsonFeature will automatically do the
        // JSON parsing for us. However, this currently doesn't work with Kotlin/Native as it doesn't support reflection
        // and we have to manually use PopularMoviesEntity.serializer()
        val response = client.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                host = BASE_URL
                encodedPath = "/posts"
            }
        }

        val jsonBody = response.readText()
        return Json.parse(PostEntity.serializer().list, jsonBody)
    }
}

private fun String.asBearerToken() = "Bearer $this"