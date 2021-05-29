package com.mits5502.anrflowers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mits5502.anrflowers.model.Cart;
import com.mits5502.anrflowers.model.CartList;
import com.mits5502.anrflowers.repository.CartListRepo;
import com.mits5502.anrflowers.repository.CartRepo;

@Service
@Transactional
public class CartListServiceImpl implements CartListService {

	@Autowired
	private CartListRepo cartListRepo;

	@Autowired
	private CartRepo cartRepo;

	@Override
	public void create(CartList cartList) {
		cartListRepo.save(cartList);
	}

	@Override
	public void update(CartList cartList) {
		cartListRepo.save(cartList);

	}

	@Override
	public void deleteById(Long cartListId) {
		cartListRepo.deleteById(cartListId);

	}

	@Override
	public List<CartList> listAllByCartId(Long cartId) {
		return cartListRepo.findAllByCartId(cartId);
	}

	@Override
	public CartList getCartByProductAndCartId(Long productId, Long cartId) {
		return cartListRepo.findByCartProductProductIdAndCartId(productId, cartId);

	}

	@Override
	public CartList getCartListById(Long cartListId) {
		return cartListRepo.findById(cartListId).get();
	}

	@Override
	public void updateCart(Cart cart) {
		cartRepo.save(cart);

	}

	@Override
	public void deleteAllFromCartList() {
		cartListRepo.deleteAll();

	}

	@Override
	public void deleteAllFromCart() {
		cartRepo.deleteAll();

	}

}
