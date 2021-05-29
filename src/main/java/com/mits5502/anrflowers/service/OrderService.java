package com.mits5502.anrflowers.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits5502.anrflowers.model.Cart;
import com.mits5502.anrflowers.model.CartList;
import com.mits5502.anrflowers.model.CurrentLoggedInUser;
import com.mits5502.anrflowers.model.FinalOrder;
import com.mits5502.anrflowers.model.OrderItem;
import com.mits5502.anrflowers.model.Product;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.repository.FinalOrderRepo;
import com.mits5502.anrflowers.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private CartListService cartListService;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private UserService userDataService;

	@Autowired
	private FinalOrderRepo finalOrderRepo;

	@Autowired
	private ProductService productService;

	private OrderItem order;

	private FinalOrder finalOrder;

	private User getUser() {

		String username = ((CurrentLoggedInUser) httpSession.getAttribute("currentLoggedInUser")).getUserName();
		return userDataService.findUserByUserName(username);
	}

	public void createOrder(Long cartId) {

		List<CartList> cartLists = cartListService.listAllByCartId(cartId);
		for (CartList cartList : cartLists) {
			order = new OrderItem();
			order.setOrderTotal(cartList.getCartTotal()).setProduct(cartList.getCartProduct())
					.setProductOrderQty(cartList.getCartProductQty()).setProductPrice(cartList.getCartPrice())
					.setUserId(this.getUser().getUserId()).setOrderStatus("NEW");
			orderRepo.save(order);

		}
		Cart cart = this.getUser().getCart();
		finalOrder = new FinalOrder();
		try {
			finalOrder.setUserId(this.getUser().getUserId()).setGrandTotal(cart.getGrandTotal())
					.setTotalItems(cart.getCartList())
					.setContactId(userDataService.getContactByUserId(this.getUser().getUserId()).getContactId())
					.setPaymentId(userDataService.getPaymentInfoByUserId(this.getUser().getUserId()).getPaymentId());
			finalOrderRepo.save(finalOrder);
		} catch (Exception ex) {

		}

	}


	public List<OrderItem> getOrdersByUserId(Long userId) {
		return orderRepo.findAllByUserId(userId);

	}

	public List<OrderItem> getOrdersByUserIdAndOrderStatus(String orderStatus, Long userId) {
		return orderRepo.findAllByOrderStatusAndUserId(orderStatus, userId);
	}

	public void updateOrderStatus(Long userId) {
		List<OrderItem> orders = orderRepo.findAllByUserId(userId);
		orders.forEach(order -> {

			Product product = productService.getProductById(order.getProduct().getProductId());
			if (order.getOrderStatus().equals("NEW")) {
				product.setProductQty(product.getProductQty() - order.getProductOrderQty());
			}

			if (product.getProductQty() == 0) {
				product.setProductStatus("OFS");
			}
			order.setOrderStatus("Ready for Delivery");
			productService.saveProduct(product);
			orderRepo.save(order);
		});

	}

}
