/*
 * Luis Perozo
 * This class defines the recipe object, which contains
 * all the information needed for one problem.
 */
package com.example.internationalmall;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;

public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;			// ID in Kitchen Monki API
	private Long recipe_id;		// ID in database
	private String name;
	private String cuisine;
	private JSONArray array;
	private Boolean solved;
	private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(Long recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public JSONArray getArray() {
		return array;
	}
	public void setArray(JSONArray array) {
		this.array = array;
	}
	public Boolean getSolved() {
		return solved;
	}
	public void setSolved(Boolean solved) {
		this.solved = solved;
	}
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
