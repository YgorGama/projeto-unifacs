package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Products.Product;

public class Principal {

	public static void main(String[] args) {
		
		//Criação da lista e adicionando novos objetos a ela
		List<Product> products = new ArrayList<>();
		products.add(new Product(0, "Fini", "Doce", "Fini", 5.85));
		products.add(new Product(1, "Chocolate", "Doce", "Cacau Show", 7.50));
		products.add(new Product(2, "Feijão", "Semente", "Kikaldo", 5.85));
		products.add(new Product(3, "Big Big", "Doce", "Arcor", 1));
		products.add(new Product(4, "Negresco", "Doce", "Nestle", 2.85));
		products.add(new Product(7, "Oreo", "Doce", "Lactea", 2.85));
		products.add(new Product(6, "Banana", "Fruta", "Não possui", 5));
		
		//Chama o menu
		Menu.menu(products);

	}

}