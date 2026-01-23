import { getRecommendedMovies } from "@/../src/app/lib/api"
import MovieGrid from "@/../src/app/components/movies/MovieGrid"

export default async function Home() {
    const movies = await getRecommendedMovies()

    return (
        <main style={{ padding: "2rem" }}>
            <h1>Recommended Movies 🎬</h1>
            <MovieGrid movies={movies} />
        </main>
    )
}