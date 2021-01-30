package lab4;

public class Product {
	private  static int productNo = 0;
	private int product_id = 0;
	private String name;
	private String type;
	private int cost;
	
	public Product(String name, String type, int cost) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		productNo++;
		this.product_id = productNo;
	}
	
	public int getProductNo() {
		return this.product_id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product #" + this.product_id +": " + this.name+ " (" + this.type +") "  +  this.cost+"$";
	}
	
	
}
