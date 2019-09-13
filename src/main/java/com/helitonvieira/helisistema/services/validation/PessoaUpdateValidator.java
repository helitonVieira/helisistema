package com.helitonvieira.helisistema.services.validation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.helitonvieira.helisistema.dto.PessoaDTO;
import com.helitonvieira.helisistema.repositories.PessoaRepository;

public class PessoaUpdateValidator implements ConstraintValidator<PessoaUpdate, PessoaDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private PessoaRepository repo;

	@Override
	public void initialize(PessoaUpdate ann) {
	}

	@Override
	public boolean isValid(PessoaDTO value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	/*	@Override
	public boolean isValid(PessoaDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

	List<FieldMessage> list = new ArrayList<>();
     
		
		Pessoa aux = repo.findByDes_email(objDto.getDes_email1(),objDto.getDes_email2(),objDto.getDes_email3());
		if (aux != null && !aux.getCod_pessoa().equals(uriId)) {	
			list.add(new FieldMessage("email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	*/}  


