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
		products.add(new Product(2,"Feij�o", "Semente", "Kikaldo", 5.85));
		products.add(new Product(3,"Big Big", "Doce", "Arcor", 1));
		products.add(new Product(4,"Negresco", "Doce", "Nestle", 2.85));
		products.add(new Product(7,"Oreo", "Doce", "Lactea", 2.85));
		products.add(new Product(6,"Banana", "Fruta", "N�o possui", 5));
		
	
		
		int i = 0;
		do {
			Scanner snc = new Scanner(System.in);

			System.out.println("-------MENU-------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar");
			System.out.println("4 - Sair");
			i = snc.nextInt();
			System.out.println();

			switch(i) {
				case 1:
					cadastrar(products);
					break;
				case 2:
					imprimirLista(products);
					break;
				case 3:
					buscar(products);
					break;
				case 4:
					System.out.println("Saindo...");;
					break;
				default:
					System.out.println("Coloque uma opção válida!!!");
					break;
			}
		}while(i != 5);	
		System.exit(i);
	}
	
	public static void imprimirLista(List<Product> products) {
		Comparator<Product> comparaPeloId = Comparator.comparing(t -> t.getId());
		products.sort(comparaPeloId);
		for(Product product: products) {
			product.imprimir();
		}
	}
	
	public static void buscar(List<Product> products) {
		Scanner snc = new Scanner(System.in);
		System.out.print("Coloque aqui o id do produto: ");
		int id = snc.nextInt();
		System.out.println();
		
		if(products.get(id) == null) {
			System.out.println("Produto não encontrado");
			return;
		}
		
		products.get(id).imprimirAll();

	}
	
	
	public static void cadastrar(List<Product> products) {
		Scanner snc = new Scanner(System.in);

		System.out.print("Coloque aqui o id do produto: ");
		int id = snc.nextInt();
		
		for(Product product : products) {
			if(product.getId() == id) {
				System.out.println("O id desse produto já consta no sistema, por favor insira um id diferente");
				return;
			}
		}
		
		System.out.print("Coloque aqui o nome do produto: ");
		snc.nextLine();
		String name = snc.nextLine(); 
		
		System.out.print("Coloque aqui o tipo de produto: ");
		String productType = snc.nextLine();
		
		System.out.print("Coloque aqui a marca do produto: ");
		String marca = snc.nextLine();
		
		System.out.print("Coloque aqui o preço do produto: ");
		double preco = snc.nextDouble();


		products.add(new Product(id, name, productType, marca, preco));
		
	}
	

}
