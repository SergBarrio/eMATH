package com.example.internationalmall;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Score implements Serializable {
	
	private int number_correct_ingredients;
	private int number_incorrect_ingredients;
	private int number_correct_recipes;
	private int number_incorrect_recipes;
	private double score;
	private ArrayList<ArrayList<Integer> > options = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Long> > times = new ArrayList<ArrayList<Long>>();

	public Score(int recipes) {
		this.number_correct_recipes = 0;
		this.number_incorrect_recipes = 0;
		this.number_correct_ingredients = 0;
		this.number_incorrect_ingredients = 0;
		this.score = 0.0;
		ArrayList<Long> ingredients = new ArrayList<Long>();
		ArrayList<Integer> option = new ArrayList<Integer>();
		for (int i=0;i<recipes;i++) {
			this.times.add(ingredients);
			this.options.add(option);
		}
	}
	
	public int getNumberCorrectIngredients() {
		return number_correct_ingredients;
	}
	public void setNumberCorrectIngredients(int number_correct_ingredients) {
		this.number_correct_ingredients = number_correct_ingredients;
	}
	public int getNumberIncorrectIngredients() {
		return number_incorrect_ingredients;
	}
	public void setNumberIncorrectIngredients(int number_incorrect_ingredients) {
		this.number_incorrect_ingredients = number_incorrect_ingredients;
	}
	
	public int getNumberCorrectRecipes() {
		return number_correct_recipes;
	}

	public int getNumberIncorrectRecipes() {
		return number_incorrect_recipes;
	}

	public void setNumberCorrectRecipes(int number_correct_recipes) {
		this.number_correct_recipes = number_correct_recipes;
	}

	public void setNumberIncorrectRecipes(int number_incorrect_recipes) {
		this.number_incorrect_recipes = number_incorrect_recipes;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public ArrayList<ArrayList<Long>> getTimes() {
		return times;
	}

	public void setTimes(long time, int recipe) {
		this.times.get(recipe).add(time);
	}
	
	public ArrayList<ArrayList<Integer>> getOptions() {
		return options;
	}

	public void setOptions(int usage, int recipe) {
		this.options.get(recipe).add(usage);
	}
}
