import React, { useState, useEffect } from "react";
import {
	MDBBtn,
	MDBCard,
	MDBCardBody,
	MDBCol,
	MDBContainer,
	MDBRow,
	MDBTypography,
} from "mdb-react-ui-kit";
import {
	viewCart,
	addProdToCart,
	deleteProdFromCart,
	getCartProds,
} from "../api/cartApi";
import CartCard from "./common/CartCard";

export default function Cart() {
	const [prods, setProds] = useState([]);
	const totalPrice = prods.reduce((acc, curr) => acc + curr.price, 0);
	let cartId;

	useEffect(() => {
		// Call the API to get cart products when component mounts
		cartId = 31; /** props.match.params.id */
		const fetch = async () => {
			await getCartProds(cartId)
				.then((response) => {
					setProds(response.data);
				})
				.catch((error) => console.log(error.response.data));
		};
		fetch();
		console.log(prods);
	}, [cartId]);
	// , [props.match.params.id]);

	if (!prods || prods.length === 0) {
		return (
			<div>
				<h1>
					CART EMPTY!! Your shopping bag seems too light. Go buy
					something!!
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
								style={{ color: "#40513B" }}
								tag="h3"
								className="fw-normal mb-0 text-black"
							>
								Your Shopping Cart
							</MDBTypography>
						</div>

						{prods?.map((prod) => {
							function handleAddToCart(p) {
								console.log("Add button clicked");
								const fetch = async (id) => {
									return await addProdToCart(31, id)
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
									return await deleteProdFromCart(31, id)
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
								<CartCard
									// key={prod.productId}
									id={prod.productId}
									name={prod.productName}
									size={prod.dimension}
									color={prod.colour}
									category={prod.productCategory}
									price={prod.price}
									add={handleAddToCart}
									delete={handleDelete}
									showAddButton={true}
								/>
							);
						})}
						<MDBCard
							style={{ backgroundColor: "#EDF1D6" }}
							className="mb-4"
						>
							<MDBCardBody className="p-4 d-flex flex-row">
								{/* <MDBInput
									label="Discound code"
									wrapperClass="flex-fill"
									size="lg"
								/> */}
								<MDBTypography
									tag="h3"
									className="fw-normal mb-0 text-black"
								>
									Subtotal:
								</MDBTypography>
								<MDBTypography
									tag="h3"
									className="text-end fw-normal mb-0 text-black ms-auto"
								>
									₹{totalPrice}
								</MDBTypography>
							</MDBCardBody>
						</MDBCard>

						<MDBCard style={{ backgroundColor: "#EDF1D6" }}>
							<MDBCardBody>
								<MDBBtn
									className="m-auto"
									color="success"
									block
									size="lg"
								>
									Place Order
								</MDBBtn>
							</MDBCardBody>
						</MDBCard>
					</MDBCol>
				</MDBRow>
			</MDBContainer>
		</section>
	);
}
