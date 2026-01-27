import { Movie } from "@/app/types/movieType";
import MovieCard from "./MovieCard";

type MovieGridProps = {
    movies?: Movie[];
};

export default function MovieGrid({ movies = [] }: MovieGridProps) {
    if (!movies.length) {
        return (
            <div className="mt-12 flex justify-center">
                <p className="font-mono text-lg text-gray-500">
                    No recommendations right now.
                </p>
            </div>
        );
    }

    return (
        <section className="mt-12">
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8">
                {movies.map(
                    (movie) => movie?.id && <MovieCard key={movie.id} movie={movie} />
                )}
            </div>
        </section>
    );
}