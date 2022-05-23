package main;

import java.util.List;
import java.util.Scanner;

import Products.Product;

public class Buscar {

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
			if(product.getId() != id) {
				System.err.println("Id n�o encontrado");
				return;
			}
		}
		
		products.get(id).imprimirAll();

	}
}
