import React from "react";
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
import { getRandomNumber } from "../../utils/helpers";

export default function ProductCard(prod) {
	return (
		<MDBCard
			style={{ backgroundColor: "#fcffeb" }}
			className="shadow-0 border rounded-3 mt-5 mb-3"
		>
			<MDBCardBody>
				<MDBRow>
					<MDBCol md="12" lg="3" className="mb-4 mb-lg-0">
						<MDBRipple
							rippleColor="dark"
							rippleTag="div"
							className="bg-image rounded hover-zoom hover-overlay"
						>
							<MDBCardImage
								src="https://www.wellplannedjourney.com/wp-content/uploads/Best-Outdoor-Products-Amazon.jpg"
								fluid
								className="w-100"
							/>
						</MDBRipple>
					</MDBCol>
					<MDBCol md="6">
						<h5>
							{prod.brand} {prod.name}
						</h5>
						<div className="d-flex flex-row">
							<div className="text-danger mb-1 me-2">
								<MDBIcon fas icon="star" />
								<MDBIcon fas icon="star" />
								<MDBIcon fas icon="star" />
								<MDBIcon fas icon="star" />
								<MDBIcon fas icon="star" />
							</div>
							<span>{getRandomNumber()}</span>
						</div>
						<div className="mt-1 mb-0 text-muted small">
							<span>{prod.size}</span>
							<span className="text-primary"> • </span>
							<span>{prod.color}</span>
							<span className="text-primary"> • </span>
							<span>
								{prod.category}
								<br />
							</span>
						</div>
						<div className="mb-2 text-muted small">
							<span>Unique design</span>
							<span className="text-primary"> • </span>
							<span>Best Quality</span>
							<span className="text-primary"> • </span>
							<span>
								Very Durable
								<br />
							</span>
						</div>
					</MDBCol>
					<MDBCol
						md="6"
						lg="3"
						className="border-sm-start-none border-start"
					>
						<div className="d-flex flex-row align-items-center mb-1">
							<h4 className="mb-1 me-1">₹{prod.price}</h4>
							<span className="text-danger">
								<s>₹{(prod.price * 1.1).toFixed(2)}</s>
							</span>
						</div>
						<h6 className="text-success">Free shipping</h6>
						<div className="d-flex flex-column mt-4">
							<MDBBtn
								onClick={() => prod.addToCart(prod.id)}
								color="success"
								size="sm"
							>
								Add to Cart
							</MDBBtn>
							<MDBBtn
								onClick={() => prod.addToWish(prod.id)}
								outline
								color="success"
								size="sm"
								className="mt-2"
							>
								Add to wish list
							</MDBBtn>
						</div>
					</MDBCol>
				</MDBRow>
			</MDBCardBody>
		</MDBCard>
	);
}
