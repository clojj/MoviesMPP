package de.moviesmpp.domain.usecase

import de.moviesmpp.data.MoviesApi
import io.mockk.mockk

class GetPopularMoviesTest {

    private val api = mockk<MoviesApi>()
    private val getPopularMovies = GetPopularMovies(api)

/*
    @Test
    fun `returns popular movies from api`() {
        val entity = mockk<PostEntity> {
            every { toModel() } returns TestUtils.post
        }
        coEvery { api.getPopularMovies() } returns entity

        // This actually doesn't work, but makes this test compile. Testing suspending functions is currently
        // not possible in common modules
        suspend {
            getPopularMovies(
                UseCase.None,
                onSuccess = {
                    print(it)
                    assertEquals(TestUtils.posts, it)
                },
                onFailure = { print(it);fail(it.toString()) }
            )
        }
    }
*/
}