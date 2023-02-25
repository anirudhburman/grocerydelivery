import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import {
	MDBCol,
	MDBContainer,
	MDBRow,
	MDBCard,
	MDBCardText,
	MDBCardBody,
	MDBCardImage,
	MDBBtn,
	MDBBreadcrumb,
	MDBBreadcrumbItem,
	MDBTypography,
} from "mdb-react-ui-kit";
import { getCustomerById, deleteCustomerById } from "../api/customerApi";
import OrderImg from "./assets/images/order.jpg";
import WishImg from "./assets/images/wish.jpg";

export default function Profile() {
	const navigate = useNavigate();
	const [user, setUser] = useState({
		userId: 0,
		userName: "",
		userPassword: "",
	});
	const [address, setAddress] = useState({
		addressId: 0,
		buildingNo: "",
		areaName: "",
		city: "",
		state: "",
		zip: 0,
	});
	const [cust, setCust] = useState({
		customerId: 0,
		customerName: "",
		mobileNo: "",
		email: "",
	});
	let custId;

	useEffect(() => {
		// Call the API to get cart products when component mounts
		custId = 9; /** props.match.params.id */
		const fetch = async () => {
			await getCustomerById(custId)
				.then((res) => {
					console.log(res.data);
					setCust({
						customerId: res.data.customerId,
						customerName: res.data.customerName,
						mobileNo: res.data.mobileNo,
						email: res.data.email,
					});
					setAddress({
						addressId: res.data.address.addressId,
						buildingNo: res.data.address.buildingNo,
						areaName: res.data.address.areaName,
						city: res.data.address.city,
						state: res.data.address.state,
						zip: res.data.address.zip,
					});
					setUser({
						userId: res.data.user.userId,
						userName: res.data.user.userName,
						userPassword: res.data.user.userPassword,
					});
				})
				.catch((error) => console.log(error.response.data));
		};
		fetch();
	}, [custId]);

	function goToWishlist() {
		console.log("Going to Wishlist page");
		navigate("/wishlist");
	}

	function goToOrders() {
		console.log("Going to view Orders");
	}

	function handleDelete() {
		const result = window.confirm(
			"Are you sure you want to delete your account? It is not recoverable once done!"
		);
		if (result) {
			console.log("User clicked OK");
			const fetch = async (id) => {
				await deleteCustomerById(id)
					.then((res) => alert(res.data))
					.catch((error) => console.log(error.response.data));
			};
			fetch(cust.customerId);
			// Redirect to Home from here.
		} else {
			console.log("User clicked Cancel");
		}
	}

	function handleEdit() {
		console.log("editing");
		navigate("/edit-profile");
	}

	return (
		<section>
			<MDBContainer className="py-5">
				<MDBRow>
					<MDBCol>
						<MDBBreadcrumb
							style={{ backgroundColor: "#fbffe5" }}
							className="rounded-3 p-3 mb-4"
						>
							<MDBBreadcrumbItem>
								<a href="/">Home</a>
							</MDBBreadcrumbItem>
							<MDBBreadcrumbItem active>
								{cust.customerName}'s Profile
							</MDBBreadcrumbItem>
						</MDBBreadcrumb>
					</MDBCol>
				</MDBRow>

				<MDBRow>
					<MDBCol lg="4">
						<MDBCard
							style={{ backgroundColor: "#fbffe5" }}
							className="mb-4"
						>
							<MDBCardBody className="text-center">
								<MDBCardImage
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
									alt="avatar"
									className="rounded-circle"
									style={{ width: "150px" }}
									fluid
								/>
								<br />
								<br />
								<p className="text-muted mb-1">
									Esteemed Customer
								</p>
								<p className="text-muted mb-4">
									{address.city}, {address.state}
								</p>
								<div className="d-flex justify-content-center mb-2">
									<MDBBtn
										color="success"
										onClick={handleEdit}
									>
										<i className="fas fa-pen"></i> Edit
									</MDBBtn>
									<MDBBtn
										onClick={handleDelete}
										outline
										className="ms-1"
										color="danger"
									>
										<i
											style={{ color: "red" }}
											className="far fa-trash-alt"
										></i>{" "}
										Delete
									</MDBBtn>
								</div>
							</MDBCardBody>
						</MDBCard>
					</MDBCol>
					<MDBCol lg="8">
						<MDBCard
							style={{ backgroundColor: "#fbffe5" }}
							className="mb-4"
						>
							<MDBCardBody>
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>Full Name</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											{cust.customerName}
										</MDBCardText>
									</MDBCol>
								</MDBRow>
								<hr />
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>UserName</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											{user.userName}
										</MDBCardText>
									</MDBCol>
								</MDBRow>
								<hr />
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>Email</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											{cust.email}
										</MDBCardText>
									</MDBCol>
								</MDBRow>
								<hr />
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>Phone</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											(+91) {cust.mobileNo}
										</MDBCardText>
									</MDBCol>
								</MDBRow>
								{/* <hr />
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>Mobile</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											(098) 765-4321
										</MDBCardText>
									</MDBCol>
								</MDBRow> */}
								<hr />
								<MDBRow>
									<MDBCol sm="3">
										<MDBCardText>Address</MDBCardText>
									</MDBCol>
									<MDBCol sm="9">
										<MDBCardText className="text-muted">
											{address.buildingNo},{" "}
											{address.areaName}, {address.city},{" "}
											{address.state}, {address.zip}
										</MDBCardText>
									</MDBCol>
								</MDBRow>
							</MDBCardBody>
						</MDBCard>

						<MDBRow>
							<MDBCol md="6">
								<MDBCard
									onClick={goToOrders}
									className="mb-4 mb-md-0 card-wrapper"
									style={{
										backgroundImage: `linear-gradient(to bottom, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url(${OrderImg})`,
										backgroundSize: "cover",
										backgroundPosition: "center",
										position: "relative",
									}}
								>
									<MDBCardBody>
										<MDBCardText>
											<MDBTypography
												tag="h3"
												className="fw-normal mb-0 text-white"
											>
												Your Past Orders
											</MDBTypography>
										</MDBCardText>
									</MDBCardBody>
								</MDBCard>
							</MDBCol>

							<MDBCol md="6">
								<MDBCard
									onClick={goToWishlist}
									className="mb-4 mb-md-0 card-wrapper"
									style={{
										backgroundImage: `linear-gradient(to bottom, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url(${WishImg})`,
										backgroundSize: "cover",
										backgroundPosition: "center",
										position: "relative",
									}}
								>
									<MDBCardBody>
										<MDBCardText>
											<MDBTypography
												tag="h3"
												className="fw-normal mb-0 text-white"
											>
												Your Wishlist
											</MDBTypography>
										</MDBCardText>
									</MDBCardBody>
								</MDBCard>
							</MDBCol>
						</MDBRow>
					</MDBCol>
				</MDBRow>
			</MDBContainer>
		</section>
	);
}
