import { Movie } from "@/app/types/movieType"
import MovieCard from "./MovieCard"

type MovieGridProps = {
    movies: Movie[]
}

export default function MovieGrid({ movies }: MovieGridProps) {
    if (movies.length === 0) {
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
                <MovieCard key={movie.id} movie={movie} />
            ))}
        </div>
    )
}