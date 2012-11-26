/*
 * Cory Wolfe,
 * Modified version of Luis's Ingredient/Recipe
 * implementation
 */

package retail.store;

import java.io.Serializable;

public class Item {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String category;
	private double price;
	

	public Long getItem_id() {
		return id;
	}
	public void setItem_id(Long item_id) {
		this.id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
