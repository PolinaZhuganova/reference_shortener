/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.reference_shortener.security;

import com.example.reference_shortener.model.AUser;
import com.example.reference_shortener.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * Класс UserDetailsServiceImpl
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		AUser user = userRepository.findByName(name).orElseThrow(()->
			new UsernameNotFoundException("User doesn't exist"));
		return SecurityUser.fromUser(user);
	}
}