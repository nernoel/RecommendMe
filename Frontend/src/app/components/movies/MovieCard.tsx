import { Movie } from "@/app/types/movieType";
import Link from "next/link";

type MovieCardProps = {
    movie: Movie;
};

export default function MovieCard({ movie }: MovieCardProps) {
    return (
        <div className="flex flex-col gap-4 rounded-xl bg-white border border-gray-200 p-4 shadow-sm hover:shadow-lg hover:-translate-y-1 transition-all duration-300">
            <img
                src={movie.posterUrl}
                alt={movie.title}
                className="w-full rounded-lg object-cover aspect-[3/4]"
            />

            <h3 className="font-mono text-lg font-extrabold text-gray-900">
                {movie.title}
            </h3>

            <p className="text-sm text-gray-600">
                {movie.category} • {movie.releaseDate}
            </p>

            <div className="mt-auto flex gap-3">
                <a
                    href={movie.watchUrl}
                    target="_blank"
                    rel="noopener noreferrer"
                    className="rounded-full bg-gradient-to-r from-blue-400 to-purple-600 px-4 py-2 text-white text-sm font-semibold shadow hover:brightness-110 transition"
                >
                    Watch
                </a>

                <Link
                    href={`/movies/${movie.id}`}
                    className="rounded-full border border-purple-600 px-4 py-2 text-purple-600 text-sm font-semibold hover:bg-purple-600 hover:text-white transition"
                >
                    Details
                </Link>
            </div>
        </div>
    );
}