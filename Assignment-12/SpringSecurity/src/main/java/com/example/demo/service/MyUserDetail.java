package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.Myusers;

public class MyUserDetail implements UserDetails{
	
	Myusers user;

	
public MyUserDetail(Myusers user) {
	this.user=user;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return Arrays.stream(user.getRole().split(",")).map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	
}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}


//addUser

//BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
//String encryptedPwd=bcrypt.encode(user.getPassword());
//user.setPassword(encryptedPwd);
//save user.......

//Authenticate User

//now matching of encrypted pasw and normal pasw
//BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
//if bcrypt.matches(user.getPassword(),dbUser.getPassword())   return Authenticated user




