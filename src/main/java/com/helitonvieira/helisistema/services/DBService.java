package com.helitonvieira.helisistema.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helitonvieira.helisistema.domain.Cidade;
import com.helitonvieira.helisistema.domain.Endereco;
import com.helitonvieira.helisistema.domain.Estado;
import com.helitonvieira.helisistema.domain.Item;
import com.helitonvieira.helisistema.domain.ItemPedido;
import com.helitonvieira.helisistema.domain.Pedido;
import com.helitonvieira.helisistema.domain.Pessoa;
import com.helitonvieira.helisistema.domain.SubCategoria;
import com.helitonvieira.helisistema.domain.enums.EstadoPagamento;
import com.helitonvieira.helisistema.domain.enums.Perfil;
import com.helitonvieira.helisistema.domain.enums.TipoPessoa;
import com.helitonvieira.helisistema.repositories.CidadeRepository;
import com.helitonvieira.helisistema.repositories.EnderecoRepository;
import com.helitonvieira.helisistema.repositories.EstadoRepository;
import com.helitonvieira.helisistema.repositories.ItemPedidoRepository;
import com.helitonvieira.helisistema.repositories.ItemRepository;
import com.helitonvieira.helisistema.repositories.PedidoRepository;
import com.helitonvieira.helisistema.repositories.PessoaRepository;
import com.helitonvieira.helisistema.repositories.SubCategoriaRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	@Autowired
	private ItemRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		SubCategoria cat1 = new SubCategoria(null, "Informática");
		SubCategoria cat2 = new SubCategoria(null, "Escritório");
		SubCategoria cat3 = new SubCategoria(null, "Cama mesa e banho");
		SubCategoria cat4 = new SubCategoria(null, "Eletrônicos");
		SubCategoria cat5 = new SubCategoria(null, "Jardinagem");
		SubCategoria cat6 = new SubCategoria(null, "Decoração");
		SubCategoria cat7 = new SubCategoria(null, "Perfumaria");
		
		Item p1 = new Item(null, "Computador", 2000.00, 2000.00,"S",cat1);
		Item p2 = new Item(null, "Impressora", 800.00, 2000.00,"S",cat1);
		Item p3 = new Item(null, "Mouse", 80.00, 2000.00,"S",cat1);
		Item p4 = new Item(null, "Mesa de escritório", 300.00, 2000.00,"S",cat1);
		Item p5 = new Item(null, "Toalha", 50.00, 2000.00,"S",cat1);
		Item p6 = new Item(null, "Colcha", 200.00, 2000.00,"S",cat1);
		Item p7 = new Item(null, "TV true color", 1200.00, 2000.00,"S",cat1);
		Item p8 = new Item(null, "Roçadeira", 800.00, 2000.00,"S",cat1);
		Item p9 = new Item(null, "Abajour", 100.00, 2000.00,"S",cat1);
		Item p10 = new Item(null, "Pendente", 180.00, 2000.00,"S",cat1);
		Item p11 = new Item(null, "Shampoo", 90.00, 2000.00,"S",cat1);
		
		Item p12 = new Item(null, "Item 12", 10.00, 2000.00,"S",cat1);
		Item p13 = new Item(null, "Item 13", 10.00, 2000.00,"S",cat1);
		Item p14 = new Item(null, "Item 14", 10.00, 2000.00,"S",cat1);
		Item p15 = new Item(null, "Item 15", 10.00, 2000.00,"S",cat1);
		Item p16 = new Item(null, "Item 16", 10.00, 2000.00,"S",cat1);
		Item p17 = new Item(null, "Item 17", 10.00, 2000.00,"S",cat1);
		Item p18 = new Item(null, "Item 18", 10.00, 2000.00,"S",cat1);
		Item p19 = new Item(null, "Item 19", 10.00, 2000.00,"S",cat1);
		Item p20 = new Item(null, "Item 20", 10.00, 2000.00,"S",cat1);
		Item p21 = new Item(null, "Item 21", 10.00, 2000.00,"S",cat1);
		Item p22 = new Item(null, "Item 22", 10.00, 2000.00,"S",cat1);
		Item p23 = new Item(null, "Item 23", 10.00, 2000.00,"S",cat1);
		Item p24 = new Item(null, "Item 24", 10.00, 2000.00,"S",cat1);
		Item p25 = new Item(null, "Item 25", 10.00, 2000.00,"S",cat1);
		Item p26 = new Item(null, "Item 26", 10.00, 2000.00,"S",cat1);
		Item p27 = new Item(null, "Item 27", 10.00, 2000.00,"S",cat1);
		Item p28 = new Item(null, "Item 28", 10.00, 2000.00,"S",cat1);
		Item p29 = new Item(null, "Item 29", 10.00, 2000.00,"S",cat1);
		Item p30 = new Item(null, "Item 30", 10.00, 2000.00,"S",cat1);
		Item p31 = new Item(null, "Item 31", 10.00, 2000.00,"S",cat1);
		Item p32 = new Item(null, "Item 32", 10.00, 2000.00,"S",cat1);
		Item p33 = new Item(null, "Item 33", 10.00, 2000.00,"S",cat1);
		Item p34 = new Item(null, "Item 34", 10.00, 2000.00,"S",cat1);
		Item p35 = new Item(null, "Item 35", 10.00, 2000.00,"S",cat1);
		Item p36 = new Item(null, "Item 36", 10.00, 2000.00,"S",cat1);
		Item p37 = new Item(null, "Item 37", 10.00, 2000.00,"S",cat1);
		Item p38 = new Item(null, "Item 38", 10.00, 2000.00,"S",cat1);
		Item p39 = new Item(null, "Item 39", 10.00, 2000.00,"S",cat1);
		Item p40 = new Item(null, "Item 40", 10.00, 2000.00,"S",cat1);
		Item p41 = new Item(null, "Item 41", 10.00, 2000.00,"S",cat1);
		Item p42 = new Item(null, "Item 42", 10.00, 2000.00,"S",cat1);
		Item p43 = new Item(null, "Item 43", 10.00, 2000.00,"S",cat1);
		Item p44 = new Item(null, "Item 44", 10.00, 2000.00,"S",cat1);
		Item p45 = new Item(null, "Item 45", 10.00, 2000.00,"S",cat1);
		Item p46 = new Item(null, "Item 46", 10.00, 2000.00,"S",cat1);
		Item p47 = new Item(null, "Item 47", 10.00, 2000.00,"S",cat1);
		Item p48 = new Item(null, "Item 48", 10.00, 2000.00,"S",cat1);
		Item p49 = new Item(null, "Item 49", 10.00, 2000.00,"S",cat1);
		Item p50 = new Item(null, "Item 50", 10.00, 2000.00,"S",cat1);
		
		cat1.getItens().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
		p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
		p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		/*p12.getCod_subcategoria().add(cat1);
		p13.getCod_subcategoria().add(cat1);
		p14.getCod_subcategoria().add(cat1);
		p15.getCod_subcategoria().add(cat1);
		p16.getCod_subcategoria().add(cat1);
		p17.getCod_subcategoria().add(cat1);
		p18.getCod_subcategoria().add(cat1);
		p19.getCod_subcategoria().add(cat1);
		p20.getCod_subcategoria().add(cat1);
		p21.getSubcategorias().add(cat1);
		p22.getSubcategorias().add(cat1);
		p23.getSubcategorias().add(cat1);
		p24.getCod_subcategoria().add(cat1);
		p25.getCod_subcategoria().add(cat1);
		p26.getCod_subcategoria().add(cat1);
		p27.getCod_subcategoria().add(cat1);
		p28.getCod_subcategoria().add(cat1);
		p29.getCod_subcategoria().add(cat1);
		p30.getCod_subcategoria().add(cat1);
		p31.getCod_subcategoria().add(cat1);
		p32.getCod_subcategoria().add(cat1);
		p33.getCod_subcategoria().add(cat1);
		p34.getCod_subcategoria().add(cat1);
		p35.getCod_subcategoria().add(cat1);
		p36.getCod_subcategoria().add(cat1);
		p37.getCod_subcategoria().add(cat1);
		p38.getCod_subcategoria().add(cat1);
		p39.getCod_subcategoria().add(cat1);
		p40.getCod_subcategoria().add(cat1);
		p41.getCod_subcategoria().add(cat1);
		p42.getCod_subcategoria().add(cat1);
		p43.getCod_subcategoria().add(cat1);
		p44.getCod_subcategoria().add(cat1);
		p45.getCod_subcategoria().add(cat1);
		p46.getCod_subcategoria().add(cat1);
		p47.getCod_subcategoria().add(cat1);
		p48.getCod_subcategoria().add(cat1);
		p49.getCod_subcategoria().add(cat1);
		p50.getCod_subcategoria().add(cat1);	*/
		
		cat1.getItens().addAll(Arrays.asList(p1, p2, p3));
		cat2.getItens().addAll(Arrays.asList(p2, p4));
		cat3.getItens().addAll(Arrays.asList(p5, p6));
		cat4.getItens().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getItens().addAll(Arrays.asList(p8));
		cat6.getItens().addAll(Arrays.asList(p9, p10));
		cat7.getItens().addAll(Arrays.asList(p11));
		
		p1.getCod_subcategoria().addAll(Arrays.asList(cat1, cat4));
		p2.getCod_subcategoria().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCod_subcategoria().addAll(Arrays.asList(cat1, cat4));
		p4.getCod_subcategoria().addAll(Arrays.asList(cat2));
		p5.getCod_subcategoria().addAll(Arrays.asList(cat3));
		p6.getCod_subcategoria().addAll(Arrays.asList(cat3));
		p7.getCod_subcategoria().addAll(Arrays.asList(cat4));
		p8.getCod_subcategoria().addAll(Arrays.asList(cat5));
		p9.getCod_subcategoria().addAll(Arrays.asList(cat6));
		p10.getCod_subcategoria().addAll(Arrays.asList(cat6));
		p11.getCod_subcategoria().addAll(Arrays.asList(cat7));
				
		subCategoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
				p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38,
				p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Pessoa cli1 = new Pessoa(null, "Maria Silva", "nelio.cursos@gmail.com", "36378912377", TipoPessoa.PESSOAFISICA, pe.encode("123"));
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Pessoa cli2 = new Pessoa(null, "Ana Costa", "nelio.iftm@gmail.com", "31628382740", TipoPessoa.PESSOAFISICA, pe.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		pessoaRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));		
	}

}
