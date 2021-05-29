
package com.mits5502.anrflowers.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits5502.anrflowers.model.Cart;
import com.mits5502.anrflowers.model.CartList;
import com.mits5502.anrflowers.model.CurrentLoggedInUser;
import com.mits5502.anrflowers.model.Product;

@Service
public class CartService {

	@Autowired
	private CartListService cartListService;

	@Autowired
	private ProductService productService;

	@Autowired
	private HttpSession httpSession;

	private Cart getCart() {

		return ((CurrentLoggedInUser) httpSession.getAttribute("currentLoggedInUser")).getCart();
	}

	public List<CartList> getCarts() {

		return cartListService.listAllByCartId(this.getCart().getCartId());

	}

	public void addCartItem(Long productId) {
		Cart cart = this.getCart();
		CartList cartList = cartListService.getCartByProductAndCartId(productId, cart.getCartId());
		if (cartList == null) {
			CartList newCartList = new CartList();
			Product product = productService.getProductById(productId);
			newCartList.setCartId(cart.getCartId());
			newCartList.setCartProduct(product);
			newCartList.setCartPrice(product.getProductListingPrice());
			newCartList.setCartProductQty(1);
			newCartList.setCartTotal(product.getProductListingPrice());
			cartListService.create(newCartList);
			cart.setCartList(cart.getCartList() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + newCartList.getCartTotal());
			cartListService.updateCart(cart);
		}

	}

	public void updateCartInList(Long cartListId, int cartQty) {

		CartList cartList = cartListService.getCartListById(cartListId);
		cartList.setCartProductQty(cartQty);
		double prevGrandTotal = cartList.getCartTotal();
		cartList.setCartTotal(cartQty * cartList.getCartPrice());
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - prevGrandTotal + cartList.getCartTotal());
		cartListService.updateCart(cart);
		cartListService.update(cartList);

	}

	public void deleteCartList(Long id) {
		CartList cartList = cartListService.getCartListById(id);
		Cart cart = this.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - cartList.getCartTotal());
		cart.setCartList(cart.getCartList() - 1);
		cartListService.updateCart(cart);
		cartListService.deleteById(id);

	}

}
