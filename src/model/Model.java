package model;

import java.util.ArrayList;
import java.util.List;

import Products.ProdutoAlimenticio;

//Classe responsavel por criar a lista de produto e depois retorna-la para ser usado no menu
public class Model {
	public static List<ProdutoAlimenticio> productList() {
		List<ProdutoAlimenticio> products = new ArrayList<>();
		products.add(new ProdutoAlimenticio(0, "Fini", "Doce", "Fini", 5.85, false, "04/13/2024"));
		products.add(new ProdutoAlimenticio(1, "Chocolate", "Doce", "Cacau Show",7.50, true,  "04/13/2024"));
		products.add(new ProdutoAlimenticio(2, "Feijão", "Semente", "Kikaldo", 5.85, true,  "04/13/2024"));
		products.add(new ProdutoAlimenticio(3, "Big Big", "Doce", "Arcor", 1, false,  "04/13/2024"));
		products.add(new ProdutoAlimenticio(4, "Negresco", "Doce", "Nestle", 2.85, false,  "04/13/2024"));
		products.add(new ProdutoAlimenticio(7, "Oreo", "Doce", "Lactea", 2.85, false,  "04/13/2024"));
		products.add(new ProdutoAlimenticio(6, "Banana", "Fruta", "Não possui", 5, false,  "04/13/2024"));
		
		return(products);
	}
}
