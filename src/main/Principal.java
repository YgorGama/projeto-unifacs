package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Products.Product;

public class Principal {
	public static void main(String[]args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(0,"Fini", "Doce", "Fini", 5.85));
		products.add(new Product(1,"Chocolate", "Doce", "Cacau Show", 7.50));
		products.add(new Product(2,"Feijão", "Semente", "Kikaldo", 5.85));
		products.add(new Product(3,"Big Big", "Doce", "Arcor", 1));
		products.add(new Product(4,"Negresco", "Doce", "Nestle", 2.85));
		products.add(new Product(7,"Oreo", "Doce", "Lactea", 2.85));
		products.add(new Product(6,"Banana", "Fruta", "Não possui", 5));
		
	
		
		int i = 0;
		Scanner snc = new Scanner(System.in);
		do {
			System.out.println("---------------------");
			
			System.out.println("Menu mercadinho%n");
			
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("2 - Buscar");
			System.out.println("4 - Sair");
			System.out.println("---------------------");
			i = snc.nextInt();			

			switch(i) {
				case 1:
					System.out.print("Coloque aqui o id do produto: ");
					int id = snc.nextInt();
					break;
				case 2:
					imprimirLista(products);
					break;
				case 3:
					System.out.print("Coloque aqui o id do produto: ");
					id = snc.nextInt();
					buscar(id, products);
					break;
				case 4:
					break;
			}
		}while(i != 4);
		
	}
	
	public static void imprimirLista(List<Product> products) {
		Comparator<Product> comparaPeloId = Comparator.comparing(t -> t.getId());
		products.sort(comparaPeloId);
		for(Product product: products) {
			product.imprimir();
		}
	}
	
	public static void buscar(int id, List<Product> products) {
		products.get(id).imprimirAll();
	}
	
	public static void cadastrar(List<Product> products, int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return;
			}
		}
		
	}
}
