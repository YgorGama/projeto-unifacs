package controller;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Products.Product;

public class Controller {
	

	public static void cadastrar(List<Product> products){
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
			return;
		}
		
		//Adiciona o novo produto criado
		products.add(new Product(id, name, productType, marca, preco));

	}
	
	
	public static void imprimirLista(List<Product> products) {
		//Função responsavel por comparar ids
		Comparator<Product> comparaPeloId = Comparator.comparing(t -> t.getId());
		//Metodo que organiza a lista por ids 
		products.sort(comparaPeloId);
		for (Product product : products) {
			product.imprimir();
		}
	}
	
	
	public static void buscar(List<Product> products) {
		
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
		
		for(Product product : products) {
			if(id == product.getId()) {
				product.imprimirAll();
				return;
			}
		}

		System.err.println("Id não encotrado");
		return;
	}
	
	public static void remove(Collection<Product> products) {
		Iterator<Product> iterator = products.iterator();
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
				iterator.remove();
				isErro = false;
				return;
			}
		}
		
		if(isErro) {
			System.err.println("Id informado não existe");
		}
	}
	
}
