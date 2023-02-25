import React, { useState } from "react";
import { Link } from "react-router-dom";
import {
	MDBNavbar,
	MDBContainer,
	MDBIcon,
	MDBNavbarToggler,
	MDBCollapse,
	MDBBadge,
	MDBBtn,
} from "mdb-react-ui-kit";
import "../assets/styles/navbar.css";

export default function Navbar() {
	const [showAnimated3, setShowAnimated3] = useState(false);

	return (
		<>
			<MDBNavbar
				dark
				style={{ backgroundColor: "#609966" }}
				className="m-auto p-auto pt-3 pb-3"
			>
				<MDBContainer fluid>
					<Link className="text-white" to="/">
						<div className="text-white">
							<MDBIcon
								fas
								icon="fas fa-hiking fa-2x me-2"
								style={{ color: "#EDF1D6" }}
							/>
							GREAT OUTDOORS{" "}
						</div>
					</Link>
					<MDBNavbarToggler
						type="button"
						className="third-button"
						data-target="#navbarToggleExternalContent"
						aria-controls="navbarToggleExternalContent"
						aria-expanded="false"
						aria-label="Toggle navigation"
						onClick={() => setShowAnimated3(!showAnimated3)}
					>
						<div
							className={`animated-icon3 ${
								showAnimated3 && "open"
							}`}
						>
							<span></span>
							<span></span>
							<span></span>
						</div>
					</MDBNavbarToggler>
				</MDBContainer>
			</MDBNavbar>

			<MDBCollapse show={showAnimated3}>
				<div
					style={{ backgroundColor: "#609966" }}
					className="shadow-3 p-4"
				>
					<MDBBtn
						block
						className="border-bottom m-0"
						style={{ backgroundColor: "#609966" }}
					>
						<Link className="text-white" to="/">
							Home
						</Link>
					</MDBBtn>
					<MDBBtn
						block
						className="border-bottom m-0"
						style={{ backgroundColor: "#609966" }}
					>
						<Link className="text-white" to="/about">
							About us
						</Link>
					</MDBBtn>
					<MDBBtn
						block
						className="border-bottom m-0"
						style={{ backgroundColor: "#609966" }}
					>
						<Link className="text-white" to="/all-products">
							Browse Products
						</Link>
					</MDBBtn>
					<MDBBtn
						block
						className="border-bottom m-0"
						style={{ backgroundColor: "#609966" }}
					>
						<Link className="text-white" to="/profile">
							My Profile
						</Link>
					</MDBBtn>
					<MDBBtn
						block
						className="m-0"
						style={{ backgroundColor: "#609966" }}
					>
						<Link className="text-white" to="/cart">
							<MDBBadge pill color="danger">
								!
							</MDBBadge>
							<span>
								<MDBIcon fas icon="shopping-cart">
									{" "}
								</MDBIcon>
							</span>{" "}
							View Cart
						</Link>
					</MDBBtn>
				</div>
			</MDBCollapse>
		</>
		// </section>
	);
}
