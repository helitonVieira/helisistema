package com.helitonvieira.helisistema;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.helitonvieira.helisistema.domain.Cidade;
import com.helitonvieira.helisistema.domain.Endereco;
import com.helitonvieira.helisistema.domain.Estado;
import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.domain.PagamentoBoleto;
import com.helitonvieira.helisistema.domain.PagamentoCartao;
import com.helitonvieira.helisistema.domain.PagamentoPedido;
import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;
import com.helitonvieira.helisistema.domain.enums.TipoPessoa;
import com.helitonvieira.helisistema.repositories.CidadeRepository;
import com.helitonvieira.helisistema.repositories.EnderecoRepository;
import com.helitonvieira.helisistema.repositories.EstadoRepository;
import com.helitonvieira.helisistema.repositories.ItemRepository;
import com.helitonvieira.helisistema.repositories.PagamentoPedidoRepository;
import com.helitonvieira.helisistema.repositories.PedidoRepository;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;

@SpringBootApplication
public class HelisistemaApplication implements CommandLineRunner {

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoPedidoRepository pagamentoPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelisistemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SubCategoria cat1 = new SubCategoria(null, "Refrigerante");
		SubCategoria cat2 = new SubCategoria(null, "Cerveja");

		Item p1 = new Item(null, "Skol", 4.5, 2.2, "S",cat2);
		Item p2 = new Item(null, "Coca lata", 14.5, 6.2, "S",cat1);
		Item p3 = new Item(null, "Fanta Laranja", 24.5, 22.2, "S",cat1);

		cat1.getItens().addAll(Arrays.asList(p3, p2));
		cat2.getItens().addAll(Arrays.asList(p1));


		subCategoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		itemRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais", "MG", "Brasil");
		Estado est2 = new Estado(null, "São Paulo", "SP", "Brasil");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Guarulhos", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Pessoa cli1 = new Pessoa(null,"Heliton Vieira","Gugu","064.146.847-22","MG11586.757","02/05/1983","Nilda","teste obs","01/01/2019","S","S","S","S",TipoPessoa.PESSOAFISICA);
		cli1.getNum_fone().addAll(Arrays.asList("996451318","88142535"));
		cli1.getDes_email().addAll(Arrays.asList("helitondba@gmail.com","heli.ton@hotmail.com"));
		Endereco e1 = new Endereco(null,"Bento Gonçalves","851","casa1","Nossa Shra das Graças","38401-002",cli1,c1);
		Endereco e2 = new Endereco(null,"Dr Munir Tanus","201","ap304","Gavea Sul","38401-002",cli1,c1);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		Pessoa cli2 = new Pessoa(null,"Juliana","juju","064.146.847-22","MG11586.757","02/05/1983","Nilda","teste obs","01/01/2019","S","S","S","N",TipoPessoa.PESSOAJURIDICA);
		cli2.getNum_fone().addAll(Arrays.asList("91008341","88142535"));
		cli2.getDes_email().addAll(Arrays.asList("juju@gmail.com","jujuxpd@hotmail.com"));
		Endereco e3 = new Endereco(null,"Artesanato","851","casa1","Planalto","38401-002",cli2,c2);
		Endereco e4 = new Endereco(null,"Dr Munir Tanus","201","ap304","Gavea Sul","38401-002",cli2,c2);
		cli1.getEnderecos().addAll(Arrays.asList(e3,e4));
		
		pessoaRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3,e4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		 
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1,cli2, e1); 
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1,cli2, e2);    
		
		cli1.getCod_pessoa_cliente().addAll(Arrays.asList(ped1, ped2)); 
		cli2.getCod_pessoa_vendedor().addAll(Arrays.asList(ped1, ped2)); 
		  
		PagamentoPedido pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6); 
		ped1.setPagamento(pagto1);    
		PagamentoPedido pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null); 
		ped2.setPagamento(pagto2); 
		 
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2)); 
		pagamentoPedidoRepository.saveAll(Arrays.asList(pagto1, pagto2)); 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
