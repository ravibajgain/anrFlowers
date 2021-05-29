package com.mits5502.anrflowers.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mits5502.anrflowers.model.CurrentLoggedInUser;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.repository.ContactRepo;
import com.mits5502.anrflowers.repository.PaymentInfoRepo;
import com.mits5502.anrflowers.service.CartListService;
import com.mits5502.anrflowers.service.OrderService;
import com.mits5502.anrflowers.service.UserService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private HttpSession session;

	@Autowired
	private CartListService cartListService;

	@Autowired
	private UserService userDataService;

	@Autowired
	private ContactRepo contactRepo;

	@Autowired
	private PaymentInfoRepo paymentRepo;

	private User getUser() {
		return userDataService
				.findUserByUserName(((CurrentLoggedInUser) session.getAttribute("currentLoggedInUser")).getUserName());
	}

	@GetMapping("checkout")
	public String placeOrderView(Model model) {

		model.addAttribute("orderItems",
				orderService.getOrdersByUserIdAndOrderStatus("NEW", this.getUser().getUserId()));
		model.addAttribute("contact", contactRepo.findByUserContactId(this.getUser().getUserId()));
		model.addAttribute("payment", paymentRepo.findByPaymentUserId(this.getUser().getUserId()));
		return "checkout";
	}

	@GetMapping("create")
	public String placeOrder(Model model, @RequestParam(name = "cid", required = false) Long cartId) {
		cartId = this.getUser().getCart().getCartId();
		orderService.createOrder(cartId);
		return "redirect:checkout";
	}

	@GetMapping("confirm")
	public String confirmOrder() {
		cartListService.deleteAllFromCart();
		cartListService.deleteAllFromCartList();
		orderService.updateOrderStatus(this.getUser().getUserId());
		((CurrentLoggedInUser) session.getAttribute("currentLoggedInUser")).getCart().setGrandTotal(0);
		((CurrentLoggedInUser) session.getAttribute("currentLoggedInUser")).getCart().setCartList(0);
		return "confirm";
	}

}
