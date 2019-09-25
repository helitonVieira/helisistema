package com.helitonvieira.helisistema.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helitonvieira.helisistema.dto.EmailDTO;
import com.helitonvieira.helisistema.security.JWTUtil;
import com.helitonvieira.helisistema.security.UserSS;
import com.helitonvieira.helisistema.services.AuthService;
import com.helitonvieira.helisistema.services.UserService;



@RestController
@RequestMapping(value = "/auth")     
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)  //metodo para validar o token  
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {   //quando ele esta perto de vencer
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)  //recuperando senha pelo email
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}

}
