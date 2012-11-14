package com.database.sqlite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.internationalmall.Recipe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RecipesDataSource {
	
	// Database fields
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { SQLiteHelper.COLUMN_RECIPE_ID,
			SQLiteHelper.COLUMN_RECIPE_NAME, SQLiteHelper.COLUMN_CUISINE };

	public RecipesDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}

	public void open() throws SQLException, IOException {
		try {

			dbHelper.createDatabase();
			dbHelper.openDataBase();
			database = dbHelper.getReadableDatabase();

		} catch(SQLException sqle) {

			throw sqle;
		}
	}

	public void close() {
		dbHelper.close();
	}
	
	public boolean exists() {
		Cursor cursor = database.rawQuery("SELECT count(*) FROM recipes;", null);
		cursor.moveToFirst();
		Long num = cursor.getLong(0);
		if (num == 0) {
			return false;
		}
		
		return true;
	}

	public Long createRecipe(String name, String cuisine) {
		ContentValues values = new ContentValues();
		values.put(SQLiteHelper.COLUMN_RECIPE_NAME, name);
		values.put(SQLiteHelper.COLUMN_CUISINE, cuisine);
		long insertId = database.insert(SQLiteHelper.TABLE_RECIPES, null,
				values);

		return insertId;
	}

	public void deleteRecipe(Recipe recipe) {
		long id = recipe.getRecipe_id();
		System.out.println("Recipe deleted with id: " + id);
		database.delete(SQLiteHelper.TABLE_RECIPES, SQLiteHelper.COLUMN_RECIPE_ID
				+ " = " + id, null);
	}

	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();

		Cursor cursor = database.query(SQLiteHelper.TABLE_RECIPES,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Recipe recipe = cursorToRecipe(cursor);
			recipes.add(recipe);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return recipes;
	}
	
	public ArrayList<Recipe> getRecipes(int number) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		Cursor cursor = database.rawQuery("select * from recipes order by random() limit " + number + ";", null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Recipe recipe = cursorToRecipe(cursor);
			recipes.add(recipe);
			cursor.moveToNext();
		}
		
		cursor.close();
		return recipes;
	}

	private Recipe cursorToRecipe(Cursor cursor) {
		Recipe recipe = new Recipe();
		recipe.setRecipe_id(cursor.getLong(0));
		recipe.setName(cursor.getString(1));
		recipe.setCuisine(cursor.getString(2));
		return recipe;
	}

}
