package Products;
//Classe mãe nela vai ter o nome id do produto o nome o tipo a marca e o preço, vai existir tbm o método para imprimir até 3 atributos e o metodo para imprimir todos os atributos do produto 
public class Product {
	//variavel id responsavel pelo numero único do produto
	private int id;
	//variavel nome responsavel pelo nome do produto
	private String name;
	//variavel nome responsavel pelo nome do produto
	private String productType;
	//variavel nome responsavel pelo nome do produto
	private String marca;
	//variavel nome responsavel pelo nome do produto
	private double price;
	

	public Product(int id, String name, String productType, String marca, double price) {
		this.id = id;
		this.name = name;
		this.productType = productType;
		this.marca = marca;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productType=" + productType + ", marca=" + marca + ", price="
				+ price + "]";
	}
	
	//Imprime na tela 3 dados do produto
	public void imprimir() {
		System.out.println("Nome: " + name);
		System.out.println("Tipo do produto: " + productType);
		System.out.println("Id: " + id);
		System.out.println();
	}
	
	//Imprime na tela todos os dados do produto
	public void imprimirAll() {
		System.out.println("Id: " + id);
		System.out.println("Nome: " + name);
		System.out.println("Tipo do produto: " + productType);
		System.out.println("Marca: " + marca);
		System.out.println("Price: " + price);
		System.out.println();
	}
	
	
	
}
