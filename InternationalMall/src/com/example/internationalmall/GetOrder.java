package com.example.internationalmall;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.SQLException;

import com.database.sqlite.IngredientsDataSource;
import com.database.sqlite.RecipesDataSource;

public class GetOrder {
	
	private Context context;
	private	String difficulty;
	private RecipesDataSource recipes_data_source;
	private IngredientsDataSource ingredients_data_source;
	
	public GetOrder(Context context, String difficulty) {
		this.difficulty = difficulty;
		this.context = context;
	}
	
	public ArrayList<Recipe> getOrder() {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes_data_source = new RecipesDataSource(context);
		ingredients_data_source = new IngredientsDataSource(context);
		
		try {
			recipes_data_source.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ingredients_data_source.open();
		
		if (difficulty.equalsIgnoreCase("easy")) {
			recipes = recipes_data_source.getRecipes(3);
			
			for (int i=0;i<recipes.size();i++) {
				recipes.get(i).setIngredients(ingredients_data_source.getIngredients(recipes.get(i).getRecipe_id()));
				recipes.get(i).setSolved(false);
			}
		} else if (difficulty.equalsIgnoreCase("medium")) {
			recipes = recipes_data_source.getRecipes(6);
			
			for (int i=0;i<recipes.size();i++) {
				recipes.get(i).setIngredients(ingredients_data_source.getIngredients(recipes.get(i).getRecipe_id()));
				recipes.get(i).setSolved(false);
			}
		} else if (difficulty.equalsIgnoreCase("hard")) {
			recipes = recipes_data_source.getRecipes(9);
			
			for (int i=0;i<recipes.size();i++) {
				recipes.get(i).setIngredients(ingredients_data_source.getIngredients(recipes.get(i).getRecipe_id()));
				recipes.get(i).setSolved(false);			
			}
		}
		
		recipes_data_source.close();
		ingredients_data_source.close();
		
		return recipes;
	}

}
