package com.database.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.internationalmall.*;

public class IngredientsDataSource {

	// Database fields
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { SQLiteHelper.COLUMN_INGREDIENT_ID,
			SQLiteHelper.COLUMN_RECIPE_NAME, SQLiteHelper.COLUMN_CUISINE, SQLiteHelper.COLUMN_RECIPE_ID };

	public IngredientsDataSource(Context context) {
		dbHelper = new SQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Long createIngredient(String name, String unit, Double amount, Long recipe_id) {
		ContentValues values = new ContentValues();
		values.put(SQLiteHelper.COLUMN_INGREDIENT_NAME, name);
		values.put(SQLiteHelper.COLUMN_UNIT, unit);
		values.put(SQLiteHelper.COLUMN_AMOUNT, amount);
		values.put(SQLiteHelper.COLUMN_RECIPE_ID, recipe_id);
		long insertId = database.insert(SQLiteHelper.TABLE_INGREDIENTS, null,
				values);
		
		return insertId;
	}

	public void deleteIngredient(Ingredient ingredient) {
		long id = ingredient.getIngredient_id();
		System.out.println("Ingredient deleted with id: " + id);
		database.delete(SQLiteHelper.TABLE_INGREDIENTS, SQLiteHelper.COLUMN_INGREDIENT_ID
				+ " = " + id, null);
	}

	public List<Ingredient> getAllIngredients() {
		List<Ingredient> recipes = new ArrayList<Ingredient>();

		Cursor cursor = database.query(SQLiteHelper.TABLE_INGREDIENTS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Ingredient ingredient = cursorToIngredient(cursor);
			recipes.add(ingredient);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return recipes;
	}
	
	public ArrayList<Ingredient> getIngredients(Long recipe_id) {
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Cursor cursor = database.rawQuery("select * from ingredients where recipe_id = " + recipe_id + ";", null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Ingredient ingredient = cursorToIngredient(cursor);
			ingredients.add(ingredient);
			cursor.moveToNext();
		}
		
		cursor.close();
		return ingredients;
	}

	private Ingredient cursorToIngredient(Cursor cursor) {
		Ingredient ingredient = new Ingredient();
		ingredient.setIngredient_id(cursor.getLong(0));
		ingredient.setName(cursor.getString(1));
		ingredient.setUnit(cursor.getString(2));
		ingredient.setAmount(cursor.getDouble(3));
		ingredient.setRecipe_id(cursor.getLong(4));
		
		return ingredient;
	}

}
