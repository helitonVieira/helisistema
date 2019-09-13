package com.helitonvieira.helisistema.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.helitonvieira.helisistema.domain.enums.TipoPessoa;
import com.helitonvieira.helisistema.dto.PessoaNewDTO;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.resources.exception.FieldMessage;
import com.helitonvieira.helisistema.services.validation.utils.BR;


public class PessoaInsertValidator implements ConstraintValidator<PessoaInsert, PessoaNewDTO> {

	@Autowired
	private PessoaRepository repo;
	
	@Override
	public void initialize(PessoaInsert ann) {
	}

	@Override
	public boolean isValid(PessoaNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getCod_tipo_pessoa().equals(TipoPessoa.PESSOAFISICA.getCod_tipo_pessoa()) && !BR.isValidCPF(objDto.getNum_cnpj_cpf())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getCod_tipo_pessoa().equals(TipoPessoa.PESSOAJURIDICA.getCod_tipo_pessoa()) && !BR.isValidCNPJ(objDto.getNum_cnpj_cpf())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}

		/*Pessoa aux = repo.findByEmail(objDto.getDes_email1());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		Pessoa aux = repo.findByEmail(objDto.getDes_email2());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		Pessoa aux = repo.findByEmail(objDto.getDes_email3());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}*/
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}


}
