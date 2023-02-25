import React, { useState, useEffect } from "react";
import {
	MDBContainer,
	MDBRow,
	MDBCol,
	MDBCard,
	MDBCardBody,
	MDBCardImage,
	MDBIcon,
	MDBRipple,
	MDBBtn,
} from "mdb-react-ui-kit";
import productApi from "../api/productApi";
import { addProdToCart } from "../api/cartApi";
import { WishApi } from "../api/wishlistApi";
import ProductCard from "./common/ProductCard";

export default function AllProducts() {
	const [prods, setProds] = useState([]);

	useEffect(() => {
		const fetch = async () => {
			await productApi
				.getAllProducts()
				.then((response) => {
					setProds(response.data);
				})
				.catch((error) => console.log(error.response.data));
		};
		fetch();
	}, []);

	console.log(prods);

	function handleAddToCart(pid) {
		console.log("Adding to cart");
		const fetch = async (id) => {
			return await addProdToCart(31, id)
				.then((res) => {
					console.log(res.data);
				})
				.catch((err) => console.log(err.response.data));
		};
		fetch(pid);
	}

	function handleAddToWish(pid) {
		console.log("Adding to Wishlist");
		const fetch = async (id) => {
			return await WishApi.addProductToWishlist(31, id)
				.then((res) => {
					console.log(res.data);
				})
				.catch((err) => console.log(err.response.data));
		};
		fetch(pid);
	}

	return (
		<MDBContainer fluid>
			<MDBRow className="justify-content-center mb-0">
				<MDBCol md="12" xl="10">
					{prods?.map((prod) => {
						return (
							<ProductCard
								key={prod.productId}
								id={prod.productId}
								brand={prod.brand}
								name={prod.productName}
								size={prod.dimension}
								color={prod.colour}
								category={prod.productCategory}
								price={prod.price}
								addToCart={handleAddToCart}
								addToWish={handleAddToWish}
							/>
						);
					})}
				</MDBCol>
			</MDBRow>
		</MDBContainer>
	);
}
