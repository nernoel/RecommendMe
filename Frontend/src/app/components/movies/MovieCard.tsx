import { Movie } from "@/app/types/movieType"
import Link from "next/link"

type MovieCardProps = {
    movie: Movie
}

export default function MovieCard({ movie }: MovieCardProps) {
    return (
        <div
            style={{
                border: "1px solid #e5e7eb",
                borderRadius: "8px",
                padding: "1rem",
                display: "flex",
                flexDirection: "column",
                gap: "0.5rem",
            }}
        >
            <img
                src={movie.posterUrl}
                alt={movie.title}
                style={{
                    width: "100%",
                    borderRadius: "6px",
                    objectFit: "cover",
                }}
            />

            <h3>{movie.title}</h3>

            <p style={{ fontSize: "0.9rem", color: "#555" }}>
                {movie.category} • {movie.releaseDate}
            </p>

            <div style={{ marginTop: "auto", display: "flex", gap: "0.5rem" }}>
                <a
                    href={movie.watchUrl}
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <button>Watch</button>
                </a>

                <Link href={`/movies/${movie.id}`}>
                    <button>Details</button>
                </Link>
            </div>
        </div>
    )
}

const cardStyle = {
    padding: "1rem",
    borderRadius: "8px",
    border: "1px solid #ddd"
}

const imgStyle = {
    width: "100%",
    borderRadius: "6px"
}