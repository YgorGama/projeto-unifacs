package Products;

public class Product {
	private int id;
	private String name;
	private String productType;
	private String marca;
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
	
	public void imprimir() {
		System.out.println("Nome: " + name);
		System.out.println("Tipo do produto: " + productType);
		System.out.println("Price: " + price);
		System.out.println();
	}
	
	public void imprimirAll() {
		System.out.println("Id: " + id);
		System.out.println("Nome: " + name);
		System.out.println("Tipo do produto: " + productType);
		System.out.println("Marca: " + marca);
		System.out.println("Price: " + price);
		System.out.println();
	}
	
	
	
}
