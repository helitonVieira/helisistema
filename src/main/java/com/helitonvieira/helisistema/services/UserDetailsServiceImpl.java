package com.helitonvieira.helisistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PessoaRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getCod_pessoa(), cli.getDes_email(), cli.getSenha(), cli.getPerfis());
	}

}
