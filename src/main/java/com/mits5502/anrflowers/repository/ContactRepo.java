package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.ContactDetails;

public interface ContactRepo extends JpaRepository<ContactDetails, Long> {
	ContactDetails findByUserContactId(Long contactUserId);

}
