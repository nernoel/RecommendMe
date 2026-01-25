import { Movie } from "@/app/types/movieType"
import MovieCard from "./MovieCard"

type MovieGridProps = {
    movies?: Movie[]  // Make movies optional to avoid crashes if undefined
}

export default function MovieGrid({ movies = [] }: MovieGridProps) {
    if (!movies || movies.length === 0) {
        return <p>No recommendations right now.</p>
    }

    return (
        <div
            style={{
                display: "grid",
                gridTemplateColumns: "repeat(auto-fill, minmax(220px, 1fr))",
                gap: "1.5rem",
                marginTop: "1.5rem",
            }}
        >
            {movies.map(movie => (
                // Defensive check: only render if movie and movie.id exist
                movie && movie.id ? (
                    <MovieCard key={movie.id} movie={movie} />
                ) : null
            ))}
        </div>
    )
}