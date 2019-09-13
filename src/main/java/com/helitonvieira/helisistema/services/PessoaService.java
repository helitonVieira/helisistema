package com.helitonvieira.helisistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helitonvieira.helisistema.domain.Cidade;
import com.helitonvieira.helisistema.domain.Endereco;
import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.domain.enums.TipoPessoa;
import com.helitonvieira.helisistema.dto.PessoaDTO;
import com.helitonvieira.helisistema.dto.PessoaNewDTO;
import com.helitonvieira.helisistema.repositories.EnderecoRepository;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.services.exceptions.DataIntegrityException;
import com.helitonvieira.helisistema.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	// @Autowired
	// private BCryptPasswordEncoder pe;

	@Autowired
	private EnderecoRepository enderecoRepository;

	/*
	 * @Autowired private S3Service s3Service;
	 * 
	 * @Autowired private ImageService imageService;
	 * 
	 * @Value("${img.prefix.client.profile}") private String prefix;
	 * 
	 * @Value("${img.profile.size}") private Integer size;
	 */

	public Pessoa find(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Codigo: " + id + ", Tipo: = " + Pessoa.class.getName()));
	}

	/*
	 * public Cliente find(Integer id) {
	 * 
	 * UserSS user = UserService.authenticated(); if (user == null ||
	 * !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) { throw new
	 * AuthorizationException("Acesso negado"); }
	 * 
	 * Pessoa obj = repo.findOne(id); if (obj == null) { throw new
	 * ObjectNotFoundException( "Objeto não encontrado! Id: " + id + ", Tipo: " +
	 * Pessoa.class.getName()); } return obj; }
	 */
	@Transactional
	public Pessoa insert(Pessoa obj) {
		obj.setCod_pessoa(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getCod_pessoa());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esta Pessoa");
		}
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(objDto.getCod_pessoa(), objDto.getNom_pessoa(), objDto.getNom_fantasia(),
				objDto.getNum_cnpj_cpf(), objDto.getNum_ie_rg(), objDto.getDta_nascimento(),
				objDto.getNom_responsavel(), objDto.getDes_observacao(), objDto.getDta_cadastro(),
				objDto.getInd_cliente(), objDto.getInd_fornecedor(), objDto.getInd_funcionario(), objDto.getInd_ativo(),
				TipoPessoa.toEnum(objDto.getCod_pessoa()));
	}

	public Pessoa fromDTO(PessoaNewDTO objDto) {
		Pessoa cli = new Pessoa(null, objDto.getNom_pessoa(), objDto.getNom_fantasia(), objDto.getNum_cnpj_cpf(),
				objDto.getNum_ie_rg(), objDto.getDta_nascimento(), objDto.getNom_responsavel(),
				objDto.getDes_observacao(), objDto.getDta_cadastro(), objDto.getInd_cliente(),
				objDto.getInd_fornecedor(), objDto.getInd_funcionario(), objDto.getInd_ativo(),
				TipoPessoa.toEnum(objDto.getCod_tipo_pessoa())); // pe.encode(objDto.getSenha()));

		Cidade cid = new Cidade(objDto.getCod_cidade(), null, null);

		Endereco end = new Endereco(null, objDto.getDes_logradouro(), objDto.getDes_num_logradouro(),
				objDto.getDes_complemento(), objDto.getDes_bairro(), objDto.getNum_cep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getNum_fone().add(objDto.getNum_fone1());
		if (objDto.getNum_fone2() != null) {
			cli.getNum_fone().add(objDto.getNum_fone2());
		}
		if (objDto.getNum_fone3() != null) {
			cli.getNum_fone().add(objDto.getNum_fone3());
		}

		cli.getDes_email().add(objDto.getDes_email1());
		if (objDto.getDes_email2() != null) {
			cli.getDes_email().add(objDto.getDes_email2());
		}
		if (objDto.getDes_email3() != null) {
			cli.getDes_email().add(objDto.getDes_email3());
		}
		return cli;
	}

	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNom_pessoa(obj.getNom_pessoa());
		newObj.setNom_fantasia(obj.getNom_fantasia());
		newObj.setNum_cnpj_cpf(obj.getNum_cnpj_cpf());
		newObj.setNum_ie_rg(obj.getNum_ie_rg());
		newObj.setDta_nascimento(obj.getDta_nascimento());
		newObj.setNom_responsavel(obj.getNom_responsavel());
		newObj.setDes_observacao(obj.getDes_observacao());
		newObj.setDta_cadastro(obj.getDta_cadastro());
		newObj.setInd_cliente(obj.getInd_cliente());
		newObj.setInd_fornecedor(obj.getInd_fornecedor());
		newObj.setInd_funcionario(obj.getInd_funcionario());
		newObj.setInd_ativo(obj.getInd_ativo());
	}

	/*
	 * public Pessoa findByEmail(String email) {
	 * 
	 * UserSS user = UserService.authenticated(); if (user == null ||
	 * !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) { throw new
	 * AuthorizationException("Acesso negado"); }
	 * 
	 * Pessoa obj = repo.findByEmail(email); if (obj == null) { throw new
	 * ObjectNotFoundException( "Objeto não encontrado! Id: " + user.getId() +
	 * ", Tipo: " + Pessoa.class.getName()); } return obj; }
	 * 
	 * 
	 * 
	 * 
	 * public URI uploadProfilePicture(MultipartFile multipartFile) {
	 * 
	 * UserSS user = UserService.authenticated(); if (user == null) { throw new
	 * AuthorizationException("Acesso negado"); }
	 * 
	 * BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
	 * jpgImage = imageService.cropSquare(jpgImage); jpgImage =
	 * imageService.resize(jpgImage, size);
	 * 
	 * String fileName = prefix + user.getId() + ".jpg";
	 * 
	 * return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"),
	 * fileName, "image");
	 */
}
