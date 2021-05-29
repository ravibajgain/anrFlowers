package com.mits5502.anrflowers.service;

import java.util.List;

import com.mits5502.anrflowers.model.Cart;
import com.mits5502.anrflowers.model.CartList;

public interface CartListService {

	void create(CartList cartList);

	void update(CartList cartList);

	void deleteById(Long cartListId);

	CartList getCartListById(Long cartListId);

	void updateCart(Cart cart);

	List<CartList> listAllByCartId(Long cartId);

	CartList getCartByProductAndCartId(Long productId, Long cartId);

	void deleteAllFromCartList();

	void deleteAllFromCart();

}
