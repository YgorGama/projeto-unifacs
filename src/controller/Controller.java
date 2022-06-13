package controller;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Products.Product;
import Products.ProdutoAlimenticio;
//Classe que possui todos os métodos da aplicação sendo responsavel por cadastrar, buscar, remover e listar produtos dentro da aplicação
public class Controller {
	
	//Metodo responsavel por cadastrar produtos dentro da aplicação (caso ocorra algum erro a aplicação vai ser redirecionado ao menu principal)
	public static void cadastrar(List<ProdutoAlimenticio> products){
		Scanner snc = new Scanner(System.in);
		int id;
		int maiorId = 0;
		
		//Cria de forma automático um id não repetido no sistema
		for(Product product : products) {
			int idAtual = product.getId();
			if(idAtual > maiorId) {
				maiorId = idAtual;
			}
		}
		
		id = maiorId + 1;
		
		System.out.print("Coloque aqui o nome do produto: ");
		String name = snc.nextLine();

		System.out.print("Coloque aqui o tipo de produto: ");
		String productType = snc.nextLine();

		System.out.print("Coloque aqui a marca do produto: ");
		String marca = snc.nextLine();
		
		String texto;
		System.out.print("Coloque aqui o preço do produto: ");
		texto = snc.nextLine();
		double preco;
		
		//Testa se o valor colocado é um double
		try{
			preco = Double.valueOf(texto);
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		boolean isNaoPerecivel;;
		System.out.print("O produtro alimenticio é perecivel? (sim/não): ");
		String texto2 = snc.nextLine();
		
		switch(texto2) {
			case "sim":
				isNaoPerecivel = true;
				break;
			case "não":
				isNaoPerecivel = false;
				break;
			default:
				System.err.println("Coloque somente sim ou não");
				return;
		}
		
		int ano = 0;
		int mes = 0;
		int dia = 0;
		
		System.out.println("Coloque aqui o ano de vencimento (Maior que 2022): ");
		texto = snc.nextLine();
		
		if(texto.length() < 4 || texto.length() > 4) {
			System.err.println("Insira um ano válido");
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		
		try{
			ano = Integer.valueOf(texto);
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		if(ano < 2022) {
			if(mes == 0) {
				System.err.println("Insira um ano válido");
				System.out.println("Aperte qualquer tecla para continuar");
				snc.nextLine();
				return;
			}
		}
		
		System.out.println("Coloque aqui o mes de vencimento: ");
		texto = snc.nextLine();
		
		
		
		
		try{
			if(Integer.valueOf(texto) > 0 && Integer.valueOf(texto) <= 12) {
				mes = Integer.valueOf(texto);
			}
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		if(mes == 0) {
			System.err.println("Insira um mês válido");
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		
		System.out.println("Coloque aqui o dia de vencimento: ");
		texto = snc.nextLine();
		
		

		try{
			if(Integer.valueOf(texto) > 0 && Integer.valueOf(texto) <= 31) {
				dia = Integer.valueOf(texto);
			}
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
				
		if(dia == 0) {
			System.err.println("Insira um dia válido");
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}
		
		//Junta o mes, o dia e o ano para formar a data
		String dataFormatada = mes+ "/"+ dia + "/" + ano;
		
		//Adiciona o novo produto criado
		try {
			products.add(new ProdutoAlimenticio(id, name, productType, marca, preco, isNaoPerecivel, dataFormatada));
		} catch (Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			System.out.println("Aperte qualquer tecla para continuar");
			snc.nextLine();
			return;
		}

	}
	
	//Metodo responsavel por imprimir 3 atributos de todos os produtos presentes na lista
	public static void imprimirLista(List<ProdutoAlimenticio> products) {
		//Função responsavel por comparar ids
		Comparator<ProdutoAlimenticio> comparaPeloId = Comparator.comparing(t -> t.getId());
		//Metodo que organiza a lista por ids 
		products.sort(comparaPeloId);
		for (ProdutoAlimenticio product : products) {
			product.imprimir();
		}
	}
	
	//Metodo rensponsavel por buscar um produto dentro da lista pelo ID e imprimir todos os se atributos 
	public static void buscar(List<ProdutoAlimenticio> products) {
		
		Scanner snc = new Scanner(System.in);
		System.out.print("Coloque aqui o id do produto: ");
		String texto = snc.nextLine();
		int id;
		try{
			id = Integer.valueOf(texto);
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			return;
		}
		
		for(ProdutoAlimenticio product : products) {
			if(id == product.getId()) {
				product.imprimirAll();
				System.out.println("Insira qualquer valor para continuar");
				snc.nextLine();
				return;
			}
		}

		System.err.println("Id não encotrado");
		System.out.println("Insira qualquer valor para continuar");
		snc.nextLine();
		
		return;
	}
	
	//Metodo para remover um prodotuo da lista pelo id
	public static void remove(Collection<ProdutoAlimenticio> products) {
		Iterator<ProdutoAlimenticio> iterator = products.iterator();
		Scanner snc = new Scanner(System.in);
		String texto;
		System.out.print("Digite o id do produto que você deseja excluir: ");
		texto = snc.nextLine();
		boolean isErro = true;
		int id;
		try {
			id = Integer.valueOf(texto);
		} catch (Exception err) {
			System.out.println("Ocorreu um erro: " + err);
			return;
		}
		
		while(iterator.hasNext()) {
			int idIterator = iterator.next().getId();
			if(id == idIterator) {
				System.out.print("Tem certeza que quer excluir esse produto? (sim/não): ");
				texto = snc.nextLine();
				switch(texto) {
					case "sim":
						iterator.remove();
						isErro = false;
						System.out.println("Produto excluido");
						System.out.println("Insira qualquer valor para continuar");
						snc.nextLine();
	
						return;
					case "não":
						isErro = false;
						System.out.println("Produto não excluido");
						System.out.println("Insira qualquer valor para continuar");
						snc.nextLine();
						return;
					}
				}
			if(isErro == false) {
				return;
			}

		}
		
		if(isErro) {
			System.err.println("Id informado não existe ou valor inserido na confirmação invalido");
			System.out.println("Insira qualquer valor para continuar");
			snc.nextLine();
			return;
		}
		return;
	}
	
	
}
