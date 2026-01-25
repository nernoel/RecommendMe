import { Movie } from "@/../src/app/types/movieType"
import { getRecommendedMovies } from "@/../src/app/lib/api"
import MovieGrid from "@/../src/app/components/movies/MovieGrid"


export default async function Home() {
    let movies: Movie[] = []
    let fetchError = false

    try {
        movies = await getRecommendedMovies()
    } catch (error) {
        console.error("Error loading movies:", error)
        fetchError = true
    }

    return (
        <main style={{ padding: "2rem" }}>
            <h1>Recommended Movies for 2026 🎬</h1>

            {fetchError && <p style={{ color: "red" }}>Failed to load movies.</p>}

            {!fetchError && movies.length === 0 && <p>No movies found.</p>}

            {!fetchError && movies.length > 0 && <MovieGrid movies={movies} />}
        </main>
    )
}