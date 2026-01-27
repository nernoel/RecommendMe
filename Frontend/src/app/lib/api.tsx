import { Movie } from "@/../src/app/types/movieType"

/*
Fetch movies from the database API
 */
export async function getRecommendedMovies(): Promise<Movie[]> {
    const response : Response = await fetch("http://localhost:3000/api/movies", {
    })

    if (!response.ok) {
        throw new Error("Failed to fetch movies")
    }

    try {
        return await response.json()

    } catch (error) {
        console.error("Failed to parse movies JSON:", error)
        return []
    }
}