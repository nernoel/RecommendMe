export type Movie = {
    id: number
    title: string
    releaseDate: string // ISO date string (yyyy-mm-dd)
    posterUrl: string
    watchUrl: string
    category: MovieCategory
}