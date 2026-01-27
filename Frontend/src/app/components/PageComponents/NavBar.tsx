import Link from "next/link";

export default function Navbar() {
    return (
        <nav className="w-full bg-white/90 backdrop-blur-md border-b border-gray-200 shadow-md">
            <div className="max-w-7xl mx-auto flex items-center justify-between px-6 py-4">
                {/* Title */}
                <h1 className="font-mono text-4xl font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-blue-400 to-purple-600">
                    RecommendMe
                </h1>

                {/* Right-side actions */}
                <div className="flex items-center gap-6">
                    <Link
                        href="/about"
                        className="text-gray-700 font-medium hover:text-purple-600 transition"
                    >
                        About
                    </Link>

                    <Link
                        href="/login"
                        className="rounded-md bg-gradient-to-r from-blue-400 to-purple-600 px-5 py-2 text-white text-sm font-semibold shadow hover:brightness-110 transition"
                    >
                        Login
                    </Link>
                </div>
            </div>
        </nav>
    );
}