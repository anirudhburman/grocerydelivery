import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RegisterPage from "./pages/RegisterPage";
import HomePage from "./pages/HomePage";
import ProfilePage from "./pages/ProfilePage";
import CartPage from "./pages/CartPage";
import WishlistPage from "./pages/WishListPage";
import ProductPage from "./pages/ProductsPage";
import AboutPage from "./pages/AboutPage";
import EditProfilePage from "./pages/EditProfilePage";
import LoginPage from "./pages/LoginPage";

function App() {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<HomePage />} />
				<Route path="/about" element={<AboutPage />} />
				<Route path="/login" element={<LoginPage />} />
				<Route path="/register" element={<RegisterPage />} />
				<Route path="/profile" element={<ProfilePage />} />
				<Route path="/edit-profile" element={<EditProfilePage />} />
				<Route path="/cart" element={<CartPage />} />
				<Route path="/wishlist" element={<WishlistPage />} />
				<Route path="/all-products" element={<ProductPage />} />
			</Routes>
		</Router>
	);
}

export default App;
