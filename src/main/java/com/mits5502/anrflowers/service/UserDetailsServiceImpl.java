package com.mits5502.anrflowers.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mits5502.anrflowers.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userDataService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbUser = userDataService.findUserByUserName(username);
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		grantedAuthority.add(new SimpleGrantedAuthority(dbUser.getRole()));
		org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(
				dbUser.getUserName(), dbUser.getUserPassword(), grantedAuthority);
		return authUser;

	}

}
