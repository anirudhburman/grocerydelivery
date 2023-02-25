import React, { useState } from "react";
import {
	MDBBtn,
	MDBContainer,
	MDBCard,
	MDBCardBody,
	MDBCardImage,
	MDBRow,
	MDBCol,
	MDBIcon,
	MDBInput,
} from "mdb-react-ui-kit";
import userApi from "../api/userApi";
import FireImg from "./assets/images/fire.jpg";

export default function LoginForm() {
	const [user, setUser] = useState({
		userName: "",
		password: "",
	});

	function handleChange(event) {
		const { name, value } = event.target;
		setUser((prevUser) => {
			return {
				...prevUser,
				[name]: value,
			};
		});
	}

	async function handleSubmit(event) {
		event.preventDefault();
		console.log(user);
		await userApi
			.loginUser(user)
			.then((response) => console.log(response.data))
			.catch((error) => console.error(`Error adding user: ${error}`));
	}

	return (
		// <form onSubmit={handleSubmit}>
		// 	<input
		// 		onChange={handleChange}
		// 		type="text"
		// 		name="userName"
		// 		id="userName"
		// 		value={user.userName}
		// 		placeholder="Enter your UserName"
		// 	/>
		// 	<input
		// 		onChange={handleChange}
		// 		type="password"
		// 		name="password"
		// 		id="password"
		// 		value={user.password}
		// 		placeholder="Enter your Password"
		// 	/>
		// 	<button type="submit">Login</button>
		// </form>

		<MDBContainer className="my-5">
			<MDBCard>
				<MDBRow className="g-0">
					<MDBCol md="6">
						<MDBCardImage
							src={FireImg}
							height="550px"
							alt="login form"
							className="rounded-start w-100"
							style={{ objectFit: "cover" }}
						/>
					</MDBCol>

					<MDBCol md="6">
						<MDBCardBody className="d-flex flex-column">
							<div className="d-flex flex-row mt-2">
								<MDBIcon
									fas
									icon="fas fa-hiking fa-3x me-3"
									style={{ color: "#609966" }}
								/>
								<span className="h1 fw-bold mb-0">
									GreatOutdoors
								</span>
							</div>

							<h5
								className="fw-normal my-4 pb-3"
								style={{ letterSpacing: "1px" }}
							>
								Sign into your account
							</h5>

							<MDBInput
								wrapperClass="mb-4"
								onChange={handleChange}
								type="text"
								name="userName"
								id="userName"
								value={user.userName}
								label="Enter your UserName"
								size="lg"
							/>
							<MDBInput
								wrapperClass="mb-4"
								onChange={handleChange}
								type="password"
								name="password"
								id="password"
								value={user.password}
								label="Enter your Password"
								size="lg"
							/>

							<MDBBtn
								onClick={handleSubmit}
								className="mb-4 px-5"
								color="dark"
								size="lg"
								style={{
									backgroundColor: "#40513B",
								}}
							>
								Login
							</MDBBtn>
							<p
								className="mb-5 pb-lg-2"
								style={{ color: "#40513B" }}
							>
								Don't have an account?{" "}
								<a
									href="/register"
									style={{ color: "#40513B" }}
								>
									Register here
								</a>
							</p>

							<div className="d-flex flex-row justify-content-start">
								<a href="#!" className="small text-muted me-1">
									Terms of use.
								</a>
								<a href="#!" className="small text-muted">
									Privacy policy
								</a>
							</div>
						</MDBCardBody>
					</MDBCol>
				</MDBRow>
			</MDBCard>
		</MDBContainer>
	);
}
