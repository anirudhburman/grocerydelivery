import React, { useState, useEffect } from "react";
import {
	MDBContainer,
	MDBCardGroup,
	MDBRow,
	MDBTypography,
} from "mdb-react-ui-kit";
import { getOrdersByCustomerId } from "../api/customerApi";
import OrderCard from "./common/OrderCard";

export default function App() {
	const [orders, setOrders] = useState([]);
	let custId = 42;

	useEffect(() => {
		const fetch = async (id) => {
			return await getOrdersByCustomerId(id)
				.then((res) => setOrders(res.data))
				.catch((err) => console.log(err.response.data));
		};
		fetch(custId);
	});
	return (
		<MDBContainer fluid style={{ minHeight: "100vh" }}>
			<div
				className="d-flex justify-content-between align-items-center"
				style={{ margin: "2em 2em 0 2em" }}
			>
				<MDBTypography
					style={{ color: "#40513B" }}
					tag="h3"
					className="fw-normal mb-0 text-black"
				>
					Your Past Orders
				</MDBTypography>
			</div>
			<MDBRow className="justify-content-center mb-0">
				<MDBCardGroup className="mt-4">
					{orders?.map((order) => {
						return (
							<OrderCard
								key={order.orderId}
								id={order.orderId}
								quantity={order.totalQuantity}
								price={order.totalPrice}
								dispatch={order.orderDispatchDate}
								delivery={order.orderDeliveryDate}
							/>
						);
					})}
				</MDBCardGroup>
			</MDBRow>
		</MDBContainer>
	);
}
