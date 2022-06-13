package Products;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//Classe filha ela possui um override para modificar o metodo imprimirAll do classe Product nela tambem 4 variaveis, 3 delas para trabalhar com datas
public class ProdutoAlimenticio extends Product{
	//Retorna
	private boolean isNaoPerecivel;
	private Date dataValidade;
	private Locale brasil = new Locale("pt", "BR");
	private DateFormat formatarData = DateFormat.getDateInstance(DateFormat.FULL, brasil);
	private String textoNaoPerecivel;
			
	public ProdutoAlimenticio(int id, String name, String productType, String marca, double price, boolean isPerecivel, String dataFormatada) {
		super(id, name, productType, marca, price);
		this.isNaoPerecivel = isPerecivel;
		this.dataValidade = new Date(dataFormatada);
	}
	
	public String getTextoNaoPerecivel() {
		if(this.isNaoPerecivel) {
			return textoNaoPerecivel = "sim";
		}else {
			return textoNaoPerecivel = "não";
		}
	}
	
	@Override
	public void imprimirAll(){
		System.out.println("Id: " + this.getId());
		System.out.println("Nome: " + this.getName());
		System.out.println("Tipo do produto: " + this.getProductType());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Preço: " + this.getPrice());
		System.out.println("Produto perecivel: "+getTextoNaoPerecivel());
		System.out.println("Vencimento: "+ formatarData.format(dataValidade));
	}
}
