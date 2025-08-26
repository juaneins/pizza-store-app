package com.delivery.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.UserEntity;
import com.delivery.persistence.entity.UserRoleEntity;
import com.delivery.persistence.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public UserSecurityService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found"));
		
		String[] roles = userEntity.getRoles()
				.stream()
				.map(UserRoleEntity::getRole)
				.toArray(String[]::new);
				
		
		return User.builder()
				.username(userEntity.getUsername())
				.password(userEntity.getPassword())
				.roles(roles)
				.accountLocked(userEntity.getLocked())
				.disabled(userEntity.getDisabled())
				.build();
	}
	
}
