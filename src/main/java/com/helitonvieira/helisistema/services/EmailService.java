package com.helitonvieira.helisistema.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.domain.Pessoa;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
		
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Pessoa pessoa, String newPass);	

}
