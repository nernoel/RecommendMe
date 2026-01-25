import { Movie } from "@/../src/app/types/movieType"

export async function getRecommendedMovies(): Promise<Movie[]> {
    const res = await fetch("http://localhost:3000/api/movies", {
        cache: "no-store",
    })

    if (!res.ok) {
        throw new Error("Failed to fetch movies")
    }

    try {
        return await res.json()
    } catch (error) {
        console.error("Failed to parse movies JSON:", error)
        return []
    }
}