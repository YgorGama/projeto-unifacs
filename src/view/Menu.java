package view;

import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

import Products.Product;
import Products.ProdutoAlimenticio;
import controller.Controller;

//Classe resposavel por mostrar um menu que chama os metodos presentes na classe controller 
public class Menu {
	public static void menu(List<ProdutoAlimenticio> products) {
		int i = 0;
		do {
			Scanner snc = new Scanner(System.in);

			System.out.println("-------MENU-------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Buscar");
			System.out.println("4 - Remover");
			System.out.println("5 - Sair");
			String texto = snc.nextLine();
			
			//Confere se o valor colocado é mesmo um inteiro
			try{
				i = Integer.valueOf(texto);
			}catch(Exception err) {
				System.err.println("Ocorreu um erro: " + err);
				System.out.println("Insira um valor qualquer para continuar");
				snc.nextLine();
			}			
			System.out.println();
			
			//Switch Case com todos os métodos
			switch (i) {
			case 1:
				Controller.cadastrar(products);
				break;
			case 2:
				Controller.imprimirLista(products);
				break;
			case 3:
				Controller.buscar(products);
				break;
			case 4:
				Controller.remove(products);
				break;
			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Coloque uma opção válida!!!");
				System.exit(5);
				break;
			}
		} while (i != 5);

	}
	
}
