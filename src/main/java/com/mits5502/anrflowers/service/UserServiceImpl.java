package com.mits5502.anrflowers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mits5502.anrflowers.model.ContactDetails;
import com.mits5502.anrflowers.model.PaymentInfo;
import com.mits5502.anrflowers.model.User;
import com.mits5502.anrflowers.repository.ContactRepo;
import com.mits5502.anrflowers.repository.PaymentInfoRepo;
import com.mits5502.anrflowers.repository.UserDataRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDataRepo userDataRepo;
	@Autowired
	private ContactRepo contactRepo;

	@Autowired
	private PaymentInfoRepo paymentRepo;

	@Override
	public void saveUser(User user) {

		userDataRepo.save(user);

	}

	@Override
	public void updateUser(User user) {
		userDataRepo.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userDataRepo.deleteById(userId);
	}

	@Override
	public User getUserById(Long id) {
		return (User) userDataRepo.findById(id).get();

	}

	@Override
	public List<User> getAllUser() {
		return userDataRepo.findAll();
	}

	@Override
	public User findUserByUserName(String userName) {
		try {
			return (User) userDataRepo.findByUserName(userName);
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public void saveUserContact(ContactDetails contact) {
		contactRepo.save(contact);

	}

	@Override
	public void updateUserContact(ContactDetails contact) {
		contactRepo.save(contact);

	}

	@Override
	public void deleteUserContactByUserId(Long contactUserId) {
		ContactDetails contact = contactRepo.findByUserContactId(contactUserId);
		contactRepo.delete(contact);

	}

	@Override
	public ContactDetails getContactByUserId(Long contactUserId) {
		return contactRepo.findByUserContactId(contactUserId);
	}

	@Override
	public void savePaymentInfo(PaymentInfo payment) {
		paymentRepo.save(payment);

	}

	@Override
	public void updatePaymentInfo(PaymentInfo payment) {
		paymentRepo.save(payment);

	}

	@Override
	public void deletePaymentInfoByUserId(Long paymentUserId) {
		PaymentInfo payment = paymentRepo.findByPaymentUserId(paymentUserId);
		paymentRepo.delete(payment);

	}

	@Override
	public PaymentInfo getPaymentInfoByUserId(Long paymentUserId) {
		return paymentRepo.findByPaymentUserId(paymentUserId);
	}

}
