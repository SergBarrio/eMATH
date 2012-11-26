package com.database.sqlite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retail.store.*;

import retail.store.Item;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ItemDataSource {
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { SQLiteHelper.ITEM_ID,
			SQLiteHelper.ITEM, SQLiteHelper.ITEM_CATEGORY, SQLiteHelper.ITEM_PRICE };
	
	public ItemDataSource(Context context){
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
		Cursor cursor = database.rawQuery("SELECT count(*) FROM items;", null);
		cursor.moveToFirst();
		Long num = cursor.getLong(0);
		if (num == 0) {
			return false;
		}
		
		return true;
	}

	public Long createItem(String name, String category, Double price, int id) {
		ContentValues values = new ContentValues();
		values.put(SQLiteHelper.ITEM, name);
		values.put(SQLiteHelper.ITEM_CATEGORY, category);
		long insertId = database.insert(SQLiteHelper.TABLE_ITEMS, null,values);

		return insertId;
	}

	public void deleteItem(Item item) {
		long id =item.getItem_id();
		System.out.println("Item deleted with id: " + id);
		database.delete(SQLiteHelper.TABLE_ITEMS, SQLiteHelper.ITEM_ID
				+ " = " + id, null);
	}

	/*
	public List<Items> getAllItems() {
		List<item> items = new ArrayList<item>();

		Cursor cursor = database.query(SQLiteHelper.TABLE_itemS,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			item item = cursorToitem(cursor);
			items.add(item);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return items;
	}*/
	
	public ArrayList<Item> getItems(int number) {
		ArrayList<Item> items = new ArrayList<Item>();
		Cursor cursor = database.rawQuery("select * from items order by random() limit " + number + ";", null);
		
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Item item = cursorToItem(cursor);
			items.add(item);
			cursor.moveToNext();
		}
		
		cursor.close();
		return items;
	}

	private Item cursorToItem(Cursor cursor) {
		Item item = new Item();
		item.setItem_id(cursor.getLong(0));
		item.setName(cursor.getString(1));
		item.setCategory(cursor.getString(2));
		return item;
	}
	
	
}
