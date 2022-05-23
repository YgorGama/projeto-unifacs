package main;

import java.util.Comparator;
import java.util.List;

import Products.Product;

public class Imprimir {

	public static void imprimirLista(List<Product> products) {
		//Função responsavel por comparar ids
		Comparator<Product> comparaPeloId = Comparator.comparing(t -> t.getId());
		products.sort(comparaPeloId);
		for (Product product : products) {
			product.imprimir();
		}
	}
}
