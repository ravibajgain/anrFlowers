package com.mits5502.anrflowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mits5502.anrflowers.model.ContactDetails;
import com.mits5502.anrflowers.model.PaymentInfo;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.service.ProductService;
import com.mits5502.anrflowers.service.UserService;

/* 

Returns controller for /account

*/






@Controller
@RequestMapping("/account")
public class AccountManager {

	@Autowired
	private UserService userDataService;

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/")

	public String getUserProfile(@RequestParam("u") String username, Model model) {
/* 
@params username to get current logged in user and to create or update user contact or payment methods. 
*/
		User user = userDataService.findUserByUserName(username);
		try {
			model.addAttribute("contact", userDataService.getContactByUserId(user.getUserId()));
			model.addAttribute("payment", userDataService.getPaymentInfoByUserId(user.getUserId()));
			return "account";
		} catch (Exception ex) {
			return "account";
		}

	}

	@PostMapping(value = "updatecontact")
	public String updateContact(@RequestParam("u") String username, @ModelAttribute ContactDetails contactDetails) {
		User user = userDataService.findUserByUserName(username);
		contactDetails.setUserContactId(user.getUserId());
		userDataService.saveUserContact(contactDetails);

		return "account";
	}

	@PostMapping(value = "updatepayment")
	public String updatePaymentInfo(@RequestParam("u") String username, @ModelAttribute PaymentInfo payment) {
		User user = userDataService.findUserByUserName(username);
		payment.setPaymentUserId(user.getUserId());
		userDataService.savePaymentInfo(payment);
		return "account";
	}

	@GetMapping("delete")
	public String deleteUser(@RequestParam("id") String userName) {
             String redirect = "";
		User user = userDataService.findUserByUserName(userName);
                System.out.println(user.getRole());
		if (user != null && user.getRole().equals("ADMIN")) {
			redirect = "redirect:admin/manage";
		} else {
			redirect = "redirect:/logout";}
		userDataService.deleteUser(user.getUserId());
		return redirect;
	}

	@GetMapping("/admin/manage")
	public String adminManage(Model model) {
		model.addAttribute("users", userDataService.getAllUser());
		model.addAttribute("products", productService.getAllProducts());
		return "admin";
	}

}
