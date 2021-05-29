
package com.mits5502.anrflowers.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mits5502.anrflowers.model.Cart;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.service.UserService;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

	@Autowired
	private UserService userDataService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("register")
	public String registerUser(@ModelAttribute User user, Model model) {
		HashMap<String, String> errorMessage = new HashMap<>();
		if (user.getUserName().isEmpty()) {
			errorMessage.put("username", "Username cannot be empty. Please enter valid username");
		} else if (user.getUserPassword().isEmpty()) {
			errorMessage.put("emptyPass", "Password field cannot be empty. Please enter valid password");

		}
		if (user.getUserPassword().equals(user.getPasswordConf()) == false) {
			errorMessage.put("password", "Password do not match. Please enter matching password");
		}
		if (errorMessage.isEmpty() && userDataService.findUserByUserName(user.getUserName()) == null) {

			user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
			user.setRole("CUSTOMER");
			user.setEnabled(true);
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			userDataService.saveUser(user);
			return "login";

		} else {
			errorMessage.put("taken", "Username already taken. Please try with different username");
			model.addAttribute("errors", errorMessage);
			return "u_registration";
		}
	}

	@PostMapping("vendor_register")
	public String registerVendor(@ModelAttribute User user, Model model) {
		HashMap<String, String> errorMessage = new HashMap<>();
		if (user.getUserName().isEmpty()) {
			errorMessage.put("username", "Username cannot be empty. Please enter valid username");
		} else if (user.getUserPassword().isEmpty()) {
			errorMessage.put("emptyPass", "Password field cannot be empty. Please enter valid password");

		}
		if (user.getUserPassword().equals(user.getPasswordConf()) == false) {
			errorMessage.put("password", "Password do not match. Please enter matching password");
		}
		if (errorMessage.isEmpty() && userDataService.findUserByUserName(user.getUserName()) == null) {
			user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
			user.setRole("VENDOR");
			user.setEnabled(true);
			userDataService.saveUser(user);
			return "login";
		} else {
			errorMessage.put("taken", "Username already taken. Please try with different username");
			mZXs odel.addAttribute("errors", errorMessage);
			return "u_registration";
		}

	}

	@RequestMapping(value = "/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {

		if (error != null) {
			model.addAttribute("invalidLogin",
					"The username or password does not match. Please check your username or password");
			return "login";
		}

		return "login";
	}

	@GetMapping(value = "register")
	public String userRegisterGetView() {
		return "u_registration";

	}

	@RequestMapping(value = "vendor_register", method = RequestMethod.GET)
	public String vendorRegisterGetView() {
		return "v_registration";
	}

	@GetMapping("admin_register")
	public String adminRegisterView() {
		return "admin_register";
	}

	@PostMapping("admin_register")
	public String adminRegister(@ModelAttribute User user, Model model) {
		HashMap<String, String> errorMessage = new HashMap<>();
		if (user.getUserName().isEmpty()) {
			errorMessage.put("username", "Username cannot be empty. Please enter valid username");
		} else if (user.getUserPassword().isEmpty()) {
			errorMessage.put("emptyPass", "Password field cannot be empty. Please enter valid password");

		}
		if (user.getUserPassword().equals(user.getPasswordConf()) == false) {
			errorMessage.put("password", "Password do not match. Please enter matching password");
		}
		if (errorMessage.isEmpty() && userDataService.findUserByUserName(user.getUserName()) == null) {

			user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
			user.setRole("ADMIN");
			user.setEnabled(true);
			userDataService.saveUser(user);
			return "login";

		} else {
			errorMessage.put("taken", "Username already taken. Please try with different username");
			model.addAttribute("errors", errorMessage);
			return "admin_register";
		}
	}

}
