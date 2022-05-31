package main;

import java.util.List;
import java.util.Scanner;

import Products.Product;

public class Menu {
	public static void menu(List<Product> products) {
		int i = 0;
		do {
			Scanner snc = new Scanner(System.in);

			System.out.println("-------MENU-------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar");
			System.out.println("4 - Sair");
			String texto = snc.nextLine();
			
			//Confere se o valor colocado é mesmo um inteiro
			try{
				i = Integer.valueOf(texto);
			}catch(Exception err) {
				System.err.println("Ocorreu um erro: " + err);
			}			
			System.out.println();
			
			//Switch Case com todos os métodos
			switch (i) {
			case 1:
				Cadastrar.cadastrar(products);
				break;
			case 2:
				Imprimir.imprimirLista(products);
				break;
			case 3:
				Buscar.buscar(products);
				break;
			case 4:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Coloque uma opção válida!!!");
				break;
			}
		} while (i != 4);
	}
}
