package retail.store;

public class Item {
	private String name = "";
	private int quantity = 0;
	private double price = 0.0;
	
	public Item(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}
}
