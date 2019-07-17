package de.moviesmpp.domain.usecase

import de.moviesmpp.data.MoviesApi
import de.moviesmpp.domain.model.*

/**
 * A `use case` to get the currently most popular movies.
 */
class GetPopularMovies(private val moviesApi: MoviesApi) : UseCase<List<Post>, UseCase.None>() {

    override suspend fun run(params: None): Either<Exception, List<Post>> {
        return try {
            val movies = moviesApi.getPopularMovies().map { toModel(it) }
            Success(movies)
        } catch (e: Exception) {
            println("e = ${e}")
            Failure(e)
        }
    }
}