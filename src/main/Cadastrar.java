package main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Products.Product;

public class Cadastrar {
	public static void cadastrar(List<Product> products){
		Random random = new Random();
		Scanner snc = new Scanner(System.in);
		int id;
		boolean check;
		
		//Cria de forma automático um id não repetido no sistema
		do 
		{
			check = false;
			id = random.nextInt(1000);
			for(Product product : products) {
				if (product.getId() == id) {
					check = true;
				}
			}
		}while(check != false);
		
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
}
