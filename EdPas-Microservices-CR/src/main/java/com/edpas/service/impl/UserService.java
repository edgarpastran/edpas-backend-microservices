package com.edpas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edpas.repo.IUserRepo;

@Service
public class UserService /*implements UserDetailsService */{
	
	@Autowired
	private IUserRepo userRepo;

	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findOneByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User doesn't exists", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		user.getRoles().forEach(role -> {
			roles.add(new SimpleGrantedAuthority(role.getName()));
		});
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
		return userDetails;
	}
	*/

}
