import React, { useState, useEffect } from "react";
import { MDBCol, MDBContainer, MDBRow, MDBTypography } from "mdb-react-ui-kit";
import ProductCard from "./common/ProductCard";
import { WishApi } from "../api/wishlistApi";

export default function WishList() {
	const [prods, setProds] = useState([]);
	let wishId = 31;

	useEffect(() => {
		// Call the API to get cart products when component mounts
		/** props.match.params.id */
		const fetch = async () => {
			await WishApi.getAllWishProducts(31)
				.then((response) => {
					console.log(response.data);
					setProds(response.data);
				})
				.catch((error) => console.log(error.response.data));
		};
		fetch();
		console.log(prods);
	}, [wishId]);
	// , [props.match.params.id]);

	if (!prods || prods.length === 0) {
		return (
			<div>
				<h1>
					WISHLIST EMPTY!! You must want something right? GO CHOOSE!!
				</h1>
			</div>
		);
	}

	return (
		<section className="h-100">
			<MDBContainer className="py-5 h-100">
				<MDBRow className="justify-content-center align-items-center h-100">
					<MDBCol md="10">
						<div className="d-flex justify-content-between align-items-center mb-4">
							<MDBTypography
								tag="h3"
								className="fw-normal mb-0 text-black"
							>
								Your Personal Wishlist
							</MDBTypography>
						</div>

						{prods?.map((prod) => {
							function handleAdd(p) {
								console.log("Add button clicked");
								const fetch = async (id) => {
									return await WishApi.addProductToWishlist(
										wishId,
										id
									)
										.then((res) => {
											console.log(res.data);
											setProds(res.data);
										})
										.catch((err) =>
											console.log(err.response.data)
										);
								};
								fetch(p.id);
								window.scrollTo(0, document.body.scrollHeight);
							}

							function handleDelete(p) {
								console.log("Delete button clicked");
								const fetch = async (id) => {
									return await WishApi.deleteProductFromWishlist(
										wishId,
										id
									)
										.then((res) => {
											console.log(res.data);
											setProds(res.data);
										})
										.catch((err) =>
											console.log(err.response.data)
										);
								};
								fetch(p.id);
							}

							return (
								<ProductCard
									// key={prod.productId}
									id={prod.productId}
									name={prod.productName}
									size={prod.dimension}
									color={prod.colour}
									category={prod.productCategory}
									price={prod.price}
									add={handleAdd}
									delete={handleDelete}
									showAddButton={false}
								/>
							);
						})}
					</MDBCol>
				</MDBRow>
			</MDBContainer>
		</section>
	);
}
