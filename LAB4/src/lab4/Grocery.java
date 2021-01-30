package lab4;

public class Grocery implements StockInterface{
	private Product product;
	private int price;
	private int amount;
	
	public Grocery(Product product, int price, int amount) {
		
		this.product = product;
		this.price = price;
		this.amount = amount;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public void setStockAmount(int newAmount) {
		this.amount = newAmount;
	}

	@Override
	public String toString() {
		return "Grocery [product=" + product + ", price=" + price + ", amount=" + amount + "]";
	}

	@Override
	public void setStockPrice(int newPrice) {
		this.price = newPrice;
	}

	@Override
	public int getStockAmount() {
		return this.amount;
	}

	@Override
	public int getStockPrice() {
		return this.price;
	}
	
	
	
	
}
