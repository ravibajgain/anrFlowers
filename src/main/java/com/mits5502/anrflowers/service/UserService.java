package com.mits5502.anrflowers.service;

import java.util.List;

import com.mits5502.anrflowers.model.ContactDetails;
import com.mits5502.anrflowers.model.PaymentInfo;
import com.mits5502.anrflowers.model.User;

public interface UserService {

	void saveUser(User user);

	void updateUser(User user);

	void deleteUser(Long userId);

	User getUserById(Long id);

	List<User> getAllUser();

	User findUserByUserName(String userName);

	void saveUserContact(ContactDetails contact);

	void updateUserContact(ContactDetails contact);

	void deleteUserContactByUserId(Long contactUserId);

	ContactDetails getContactByUserId(Long contactUserId);

	void savePaymentInfo(PaymentInfo payment);

	void updatePaymentInfo(PaymentInfo payment);

	void deletePaymentInfoByUserId(Long paymentUserId);

	PaymentInfo getPaymentInfoByUserId(Long paymentUserId);

}
