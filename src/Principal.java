import view.Menu; 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Products.Product;
import model.Model;
public class Principal {

	public static void main(String[] args) {
		
		//Criação da lista e adicionando novos objetos a ela

		
		//Chama o menu
		Menu.menu(Model.productList());

	}

}