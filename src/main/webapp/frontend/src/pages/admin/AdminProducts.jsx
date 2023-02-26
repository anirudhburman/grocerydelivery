import React, { useEffect, useState } from "react";
import productApi from "../../api/productApi";
import { ProductTableRow } from "./ProductsTable";
import "../../components/assets/styles/prodTable.css";
// import ProductTable from "./ProductsTable";

import {
	MDBTypography,
	MDBTable,
	MDBTableHead,
	MDBTableBody,
} from "mdb-react-ui-kit";

export default function AdminProducts() {
	const [products, setProducts] = useState([]);

	useEffect(() => {
		const fetch = async () => {
			return await productApi
				.getAllProducts()
				.then((res) => setProducts(res.data))
				.catch((err) => console.log(err.response.data));
		};
		fetch();
	}, []);

	return (
		<>
			<div style={{ margin: "5em" }}>
				<MDBTypography
					style={{ color: "#40513B" }}
					tag="h3"
					className="fw-normal mb-0 text-black"
				>
					Your Shopping Cart
				</MDBTypography>
			</div>
			<section className="prod-table">
				<MDBTable align="middle">
					<MDBTableHead dark>
						<tr>
							<th scope="col">Product#</th>
							<th scope="col">Name</th>
							<th scope="col">Brand</th>
							<th scope="col">Category</th>
							<th scope="col">Dimensions</th>
							<th scope="col">Colour</th>
							<th scope="col">Price</th>
							<th scope="col">Edit</th>
						</tr>
					</MDBTableHead>
					<MDBTableBody>
						{products?.map((prod) => (
							<ProductTableRow
								id={prod.productId}
								name={prod.productName}
								brand={prod.brand}
								category={prod.productCategory}
								dimensions={prod.dimension}
								color={prod.colour}
								price={prod.price}
							/>
						))}
					</MDBTableBody>
				</MDBTable>
			</section>
		</>
	);
}
