
package com.mits5502.anrflowers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mits5502.anrflowers.model.CartList;
import com.mits5502.anrflowers.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "view")
	public String viewProductCart(Model model) {
		List<CartList> carts = cartService.getCarts();
		model.addAttribute("carts", carts);
		return "view_cart";
	}

	@RequestMapping(value = "add")
	public String addCart(@RequestParam("id") Long productId) {
		cartService.addCartItem(productId);
		return "redirect:/home";
	}

	@RequestMapping(value = "delete")
	public String deletCart(@RequestParam("id") Long id) {
		cartService.deleteCartList(id);
		return "redirect:view";
	}

	@RequestMapping(value = "edit")
	public String editCart(@RequestParam("cartListId") Long cartListId, @RequestParam("cartQty") int cartQty) {
		cartService.updateCartInList(cartListId, cartQty);
		return "redirect:view";
	}

}
