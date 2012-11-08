/*
 * Luis Perozo
 * This class defines the ingredient object.
 * The attributes of the ingredient object are used
 * to populate fields in the problem screen.
 */
package com.example.internationalmall;

import java.io.Serializable;

public class Ingredient implements Serializable {
	
	private Long recipe_id;
	private Long ingredient_id;
	private String name;
	private String unit;
	private double amount;
	

	public Long getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}
	public Long getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(Long ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
