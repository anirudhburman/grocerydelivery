import React, { useState, useContext } from "react";
import {
	MDBBtn,
	MDBInput,
	MDBContainer,
	MDBRow,
	MDBCol,
	MDBCard,
	MDBCardBody,
	MDBCheckbox,
	MDBTypography,
} from "mdb-react-ui-kit";
import "./assets/styles/registerForm.css";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

function RegisterForm() {
	const navigate = useNavigate();
	const { register, isAuth, setCustomer } = useContext(AuthContext);
	const [user, setUser] = useState({
		userName: "",
		userPassword: "",
	});
	const [address, setAddress] = useState({
		buildingNo: "",
		areaName: "",
		city: "",
		state: "",
		zip: 0,
	});
	const [cust, setCust] = useState({
		customerName: "",
		mobileNo: "",
		email: "",
	});

	function handleCustChange(event) {
		const { name, value } = event.target;

		setCust((prevCust) => {
			return {
				...prevCust,
				[name]: value,
			};
		});
	}

	function handleAddressChange(event) {
		const { name, value } = event.target;

		setAddress((prevAdd) => {
			return {
				...prevAdd,
				[name]: value,
			};
		});
	}

	function handleUserChange(event) {
		const { name, value } = event.target;

		setUser((prevUser) => {
			return {
				...prevUser,
				[name]: value,
			};
		});
	}

	async function handleRegister(event) {
		event.preventDefault();
		await register(cust, address, user)
			.then((response) => {
				console.log(response.data);
				setCustomer(response.data);
			})
			.catch((error) => console.log(error.response.data));
	}

	if (isAuth) {
		navigate("/profile");
	}

	return (
		<MDBContainer fluid className="h-custom mb-10">
			<MDBRow className="d-flex justify-content-center align-items-center h-100">
				<MDBCol col="12" className="m-5">
					<div className="d-flex justify-content-between align-items-center mb-4">
						<MDBTypography
							style={{ color: "#40513B" }}
							tag="h3"
							className="fw-normal mb-0 text-black"
						>
							Create Account
						</MDBTypography>
					</div>
					<MDBCard
						className="card-registration card-registration-2"
						style={{ borderRadius: "15px" }}
					>
						<MDBCardBody className="p-0">
							<MDBRow>
								<MDBCol md="6" className="p-5 bg-white">
									<h3
										className="fw-normal mb-5"
										style={{ color: "#40513B" }}
									>
										General Infomation
									</h3>

									<MDBInput
										onChange={handleCustChange}
										name="customerName"
										wrapperClass="mb-4"
										label="Full Name*"
										size="lg"
										id="form1"
										type="text"
										value={cust.customerName}
										required
									/>

									<MDBInput
										onChange={handleCustChange}
										wrapperClass="mb-4"
										name="mobileNo"
										label="Mobile Number*"
										size="lg"
										id="form2"
										type="number"
										value={cust.mobileNo}
										required
									/>

									<MDBInput
										onChange={handleCustChange}
										name="email"
										wrapperClass="mb-4"
										label="Email ID*"
										size="lg"
										id="form3"
										type="email"
										value={cust.email}
										required
									/>

									<MDBInput
										onChange={handleUserChange}
										name="userName"
										wrapperClass="mb-4"
										label="Username*"
										size="lg"
										id="form4"
										type="text"
										value={user.userName}
										required
									/>

									<MDBInput
										onChange={handleUserChange}
										name="userPassword"
										wrapperClass="mb-4"
										label="Password*"
										size="lg"
										id="form5"
										type="password"
										value={user.userPassword}
										required
									/>
								</MDBCol>

								<MDBCol
									md="6"
									className="bg-indigo p-5 text-white"
								>
									<h3
										className="fw-normal mb-5 text-white"
										style={{ color: "#4835d4" }}
									>
										Address Details
									</h3>
									<MDBRow>
										<MDBCol md="5">
											<MDBInput
												style={{ color: "white" }}
												onChange={handleAddressChange}
												name="buildingNo"
												wrapperClass="mb-4"
												labelClass="text-white"
												label="Building No*"
												size="lg"
												id="form6"
												type="text"
												value={address.buildingNo}
												required
											/>
										</MDBCol>

										<MDBCol md="7">
											<MDBInput
												style={{ color: "white" }}
												onChange={handleAddressChange}
												name="zip"
												wrapperClass="mb-4"
												labelClass="text-white"
												label="Zip Code*"
												size="lg"
												id="form7"
												type="text"
												value={address.zip}
												required
											/>
										</MDBCol>
									</MDBRow>

									<MDBInput
										style={{ color: "white" }}
										onChange={handleAddressChange}
										name="areaName"
										wrapperClass="mb-4"
										labelClass="text-white"
										label="Area/Locality*"
										size="lg"
										id="form8"
										type="text"
										value={address.areaName}
										required
									/>

									<MDBInput
										style={{ color: "white" }}
										onChange={handleAddressChange}
										name="city"
										wrapperClass="mb-4"
										labelClass="text-white"
										label="City*"
										size="lg"
										id="form9"
										type="text"
										value={address.city}
										required
									/>

									<MDBInput
										style={{ color: "white" }}
										onChange={handleAddressChange}
										name="state"
										wrapperClass="mb-4"
										labelClass="text-white"
										label="State*"
										size="lg"
										id="form10"
										type="text"
										value={address.state}
										required
									/>

									<MDBCheckbox
										name="flexCheck"
										id="flexCheckDefault"
										labelClass="text-white mb-4"
										label="I do accept the Terms and Conditions of your site."
										required
									/>
									<MDBBtn
										onClick={handleRegister}
										style={{ backgroundColor: "#EDF1D6" }}
										size="lg"
										color="black"
									>
										Register
									</MDBBtn>
								</MDBCol>
							</MDBRow>
						</MDBCardBody>
					</MDBCard>
				</MDBCol>
			</MDBRow>
		</MDBContainer>
	);
}

export default RegisterForm;
