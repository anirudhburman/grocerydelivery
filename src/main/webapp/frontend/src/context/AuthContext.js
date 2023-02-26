import { createContext, useState, useEffect } from "react";
import { addCustomer } from "../api/customerApi";
import userApi from "../api/userApi";

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
	const [currentUser, setCurrentUser] = useState({
		userId: 0,
		userName: "",
		userPassword: "",
		userType: "",
	});
	const [customer, setCustomer] = useState({
		customerId: 0,
		customerName: "",
		mobileNo: "",
		email: "",
		address: {},
		user: {},
		cart: { cartId: 0, products: [], quantity: 0 },
		wishlist: { wishlistId: 0, products: [], quantity: 0 },
		orders: [],
	});
	const [isAuth, setIsAuth] = useState(false);
	const [isAdmin, setIsAdmin] = useState(false);

	useEffect(() => {
		const storedUser = localStorage.getItem("currentUser");
		const storedCustomer = localStorage.getItem("customer");
		if (storedUser) {
			setCurrentUser(JSON.parse(storedUser));
			setIsAuth(true);
			const cookie = JSON.parse(storedUser);
			if (cookie.userType === "Admin") {
				setIsAdmin(true);
			}
		}
		if (storedCustomer) {
			setCustomer(JSON.parse(storedCustomer));
			// const cookie2 = JSON.parse(storedCustomer);
		}
	}, [isAuth, isAdmin]);

	const login = async (user) => {
		const response = await userApi.loginUser(user);
		if (response.data) {
			setCurrentUser(response.data);
			setIsAuth(true);
			if (response.data.userType === "admin") {
				setIsAdmin(true);
			}
			localStorage.setItem("currentUser", JSON.stringify(response.data));
		}
		return response;
	};

	if (currentUser.userType === "Customer") {
		const getCust = async (id) => {
			return await userApi
				.getCustomer(id)
				.then((res) => {
					setCustomer(res.data);
					localStorage.setItem("customer", JSON.stringify(res.data));
				})
				.catch((err) => console.log(err.response.data));
		};
		getCust(currentUser.userId);
	}

	const logout = () => {
		setCurrentUser({
			userId: 0,
			userName: "",
			userPassword: "",
			userType: "",
		});
		setCustomer({
			customerId: 0,
			customerName: "",
			mobileNo: "",
			email: "",
			address: {},
			user: {},
			cart: { cartId: 0, products: [], quantity: 0 },
			wishlist: { wishlistId: 0, products: [], quantity: 0 },
			orders: [],
		});
		setIsAuth(false);
		setIsAdmin(false);
		localStorage.removeItem("currentUser");
		localStorage.removeItem("customer");
	};

	const register = async (cust, address, user) => {
		const response = await addCustomer(cust, address, user);
		if (response.data) {
			setCustomer(response.data);
			setCurrentUser(response.data.user);
			setIsAuth(true);
			localStorage.setItem(
				"currentUser",
				JSON.stringify(response.data.user)
			);
			localStorage.setItem("customer", JSON.stringify(response.data));
		}
		return response;
	};

	return (
		<AuthContext.Provider
			value={{
				currentUser,
				customer,
				isAuth,
				login,
				logout,
				setCurrentUser,
				setCustomer,
				register,
				isAdmin,
			}}
		>
			{children}
		</AuthContext.Provider>
	);
};
