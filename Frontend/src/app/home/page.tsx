import { Movie } from "@/../src/app/types/movieType";
import { getRecommendedMovies } from "@/../src/app/lib/api";
import MovieGrid from "@/../src/app/components/movies/MovieGrid";
import Navbar from "@/../src/app/components/PageComponents/NavBar";

export default async function Home() {
    let movies: Movie[] = [];
    let fetchError = false;

    try {
        movies = await getRecommendedMovies();
    } catch (error) {
        console.error("Error loading movies:", error);
        fetchError = true;
    }

    return (
        <div className="min-h-screen bg-gray-50">
            {/* Fixed Navbar */}
            <Navbar />

            {/* Page Content */}
            <main className="pt-36 px-6 max-w-7xl mx-auto">
                <h1 className="font-mono text-4xl md:text-5xl font-extrabold text-gray-900 mb-10">

                </h1>

                {fetchError && (
                    <p className="text-red-500 font-mono">
                        Failed to load movies.
                    </p>
                )}

                {!fetchError && movies.length === 0 && (
                    <p className="text-gray-600 font-mono">
                        No movies found.
                    </p>
                )}

                {!fetchError && movies.length > 0 && (
                    <MovieGrid movies={movies} />
                )}
            </main>
        </div>
    );
}