package com.helitonvieira.helisistema.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.helitonvieira.helisistema.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() { // metodo que busca usuario logado 
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
