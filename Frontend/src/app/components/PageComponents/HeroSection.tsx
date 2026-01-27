



export default function HeroSection(){
    return (
        <div className="container mx-auto mt-56">
            <div className="grid grid-cols-2">

                <div className="">
                    <h1 className="font-mono mb-4 text-3xl font-extrabold text-gray-900 md:text-5xl lg:text-6xl"><span className="text-transparent bg-clip-text bg-gradient-to-r to-purple-600 from-blue-400"> Quickly view some of the best movies to see in 2026!</span><h1>{/* emtpy text */}</h1>
                    </h1>
                    <p className="font-mono text-lg font-normal text-gray-700 lg:text-xl">Feeling bored? Get some recommended movies to watch today! Click to get started! 👇</p>

                </div>

                <img src="/favicon.ico" />

            </div>
            <hr className="border-t border-gray-200 p-1 w-full mb-4 mt-24" />
        </div>
    )
}