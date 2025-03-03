package com.camiran.first_project_spring;

import com.camiran.first_project_spring.domain.Categoria;
import com.camiran.first_project_spring.domain.Cidade;
import com.camiran.first_project_spring.domain.Cliente;
import com.camiran.first_project_spring.domain.Estado;
import com.camiran.first_project_spring.domain.Pagamento;
import com.camiran.first_project_spring.domain.PagamentoComBoleto;
import com.camiran.first_project_spring.domain.PagamentoComCartao;
import com.camiran.first_project_spring.domain.Produto;
import com.camiran.first_project_spring.repositories.CategoriaRepository;
import com.camiran.first_project_spring.repositories.ProdutoRepository;
import com.camiran.first_project_spring.repositories.EstadoRepository;
import com.camiran.first_project_spring.repositories.CidadeRepository;
import com.camiran.first_project_spring.domain.enums.EstadoPagamento;
import com.camiran.first_project_spring.domain.enums.TipoCliente;
import com.camiran.first_project_spring.domain.Endereco;
import com.camiran.first_project_spring.repositories.ClienteRepository;
import com.camiran.first_project_spring.repositories.EnderecoRepository;
import com.camiran.first_project_spring.domain.Pedido;
import com.camiran.first_project_spring.repositories.PedidoRepository;
import com.camiran.first_project_spring.repositories.PagamentoRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.camiran.first_project_spring.domain")
public class FirstProjectSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;


	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "Mato Grosso");

		Cidade c1 = new Cidade(null, "Medianeira", est1);
		Cidade c2 = new Cidade(null, "Sinop", est2);
		Cidade c3 = new Cidade(null, "Cuiabá", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "João da Silva", 
										"joaosilva@gmail.com", 
										"59338214172", 
										TipoCliente.PESSOAFISICA);	
		cli1.getTelefones().addAll(Arrays.asList("27123323", "13738244"));
		
		Endereco e1 = new Endereco(null, "Rua Bahia", "300", "Sala 114", "Jardim", "14720324", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Sibipirunas", "105", "Apto 201", "Centro", "52717314", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("28/07/2022 15:30"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("30/07/2022 10:00"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, ped1, 7);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("30/07/2022 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

	}

}
