
package com.mits5502.anrflowers.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mits5502.anrflowers.model.CurrentLoggedInUser;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.service.UserService;

@ControllerAdvice
public class MasterController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private UserService userDataService;

	private CurrentLoggedInUser newUser = null;

	@ModelAttribute("currentLoggedInUser")
	public CurrentLoggedInUser getUser() {

		if (httpSession.getAttribute("currentLoggedInUser") == null) {

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			User user = userDataService.findUserByUserName(auth.getName());
			if (user != null) {
				newUser = new CurrentLoggedInUser();
				newUser.setUserName(user.getUserName()).setFirstName(user.getFirstName())
						.setLastName(user.getLastName()).setEmail(user.getEmail()).setRole(user.getRole());
				if (newUser.getRole().toUpperCase().equals("CUSTOMER")) {
					newUser.setCart(user.getCart());
				}
				httpSession.setAttribute("currentLoggedInUser", newUser);
				return newUser;
			}
		}
		return (CurrentLoggedInUser) httpSession.getAttribute("currentLoggedInUser");

	}

}
