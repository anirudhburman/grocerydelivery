import React from "react";
import Navbar from "../components/common/Navbar";
import Footer from "../components/common/Footer";
import Header from "../components/common/Header";
import Home from "../components/Home.tsx";

export default function HomePage() {
	return (
		<>
			<Navbar />
			<Header />
			<Home />
			<Footer />
		</>
	);
}
