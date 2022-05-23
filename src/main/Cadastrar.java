package main;

import java.util.List;
import java.util.Scanner;

import Products.Product;

public class Cadastrar {
	public static void cadastrar(List<Product> products){
		Scanner snc = new Scanner(System.in);
		int id;
		System.out.print("Coloque aqui o id do produto: ");
		String texto = snc.nextLine();
		
		try{
			id = Integer.valueOf(texto);
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			return;
		}
		
		for (Product product : products) {
			if (product.getId() == id) {
				System.err.println("O id desse produto já consta no sistema, por favor insira um id diferente");
				return;
			}
		}

		System.out.print("Coloque aqui o nome do produto: ");
		String name = snc.nextLine();

		System.out.print("Coloque aqui o tipo de produto: ");
		String productType = snc.nextLine();

		System.out.print("Coloque aqui a marca do produto: ");
		String marca = snc.nextLine();

		System.out.print("Coloque aqui o preço do produto: ");
		texto = snc.nextLine();
		double preco;
		
		try{
			preco = Double.valueOf(texto);
		}catch(Exception err) {
			System.err.println("Ocorreu um erro: " + err);
			return;
		}
		
	
		products.add(new Product(id, name, productType, marca, preco));

	}
}
