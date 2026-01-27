import Navbar from "./components/PageComponents/NavBar";
import HeroSection from "./components/PageComponents/HeroSection";

export default function Home() {
    return (
        <div className="page min-h-screen flex flex-col">
            <Navbar />
            <main
                className="flex-grow flex items-center justify-center px-4"
                style={{ minHeight: 'calc(100vh - 80px)', paddingTop: '10px', paddingRight:'50px' }}
            >
                <HeroSection />
            </main>
        </div>
    );
}