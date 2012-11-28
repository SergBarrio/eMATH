package retail.store;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.SQLException;

import com.database.sqlite.ItemDataSource;

public class GetProblem {
	
	private class Range {
		private double upper;
		private double lower;
		
		public Range(double upper, double lower) {
			this.upper = upper;
			this.lower = lower;
		}
		
		public double getUpper() {
			return upper;
		}
		public double getLower() {
			return lower;
		}
	}
	
	private ItemDataSource dataSource;
	private String difficulty = null;
	private HashMap<String,Range> ranges = new HashMap<String,Range>();
	
	public GetProblem(String difficulty, Context context) {
			this.dataSource = new ItemDataSource(context);
			this.difficulty = difficulty;
		
			ranges.put("Hardware", new Range(12.5,65.99));
			ranges.put("Fruit", new Range(0.5,6.5));
			ranges.put("Clothing", new Range(15.0,87.45));
			ranges.put("Accessories", new Range(10.5,40.25));
			ranges.put("Electronics", new Range(50.0,200.5));
			ranges.put("Food", new Range(5.5,18.75));
			ranges.put("School", new Range(5.0,20.0));
			ranges.put("Home", new Range(7.0,35.2));
			ranges.put("Pet", new Range(4.5,12.25));
			ranges.put("Sports", new Range(7.5,35.4));
			ranges.put("Vehicle", new Range(7.5,25.25));
		};
	
	private Item getEasyItem(Range range) {
		
		double num = (range.getLower() + (int)(Math.random() * ((range.getUpper() - range.getLower()) + 1)));
		int quantity = 1 + (int)(Math.random() * ((5 - 1) + 1));
		
		double price = 1;
		int method = (1 + (int)(Math.random() * ((2 - 1) + 1)));
		if (method == 2) {
			if (Math.IEEEremainder(price, 5.0) != 0) {
				int choice = (1 + (int)(Math.random() * ((4 - 1) + 1)));
				
				int i = 1;
				while (price <= choice) {
					price = i*5;
					++i;
				}
				if ((Math.IEEEremainder(choice, 2) == 0) && (price != 5)) {
					price -= 5;
				}
			}
		} else {
			price = num;
			quantity = 5;
		}
		price = Math.abs(price);
		
		return new Item(quantity, price);
	}
	
	private Item getMediumItem(Range range) {
		double price = (range.getLower() + (int)(Math.random() * ((range.getUpper() - range.getLower()) + 1)));
		int quantity = 1 + (int)(Math.random() * ((5 - 1) + 1));
		
		return new Item(quantity,price);
	}
	
	private Item getHardItem(Range range) {
		double price = (range.getLower() + (Math.random() * ((range.getUpper() - range.getLower()) + 1)));
		int quantity = 1 + (int)(Math.random() * ((5 - 1) + 1));
		
		return new Item(quantity,price);
	}
	
	public Problem getProblem() {
		int customer = 0;
		Problem problem = new Problem();
		try {
			dataSource.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Get 5 gategories from db
		ArrayList<String> categories = dataSource.getCategories(5);
		
		for (int i=0;i<categories.size();i++) {
			Range range = ranges.get(categories.get(i));
			int num = 1 + (int)(Math.random() *6);
			// Get a random number of items in category i
			ArrayList<String> itemsPurchased = dataSource.getItems(num, categories.get(i));
			ArrayList<Item> items = new ArrayList<Item>();
			
			for (int j=0;j<itemsPurchased.size();j++) {
				Item item = null;
				if (difficulty.equalsIgnoreCase("easy"))
					item = getEasyItem(range);
				else if (difficulty.equalsIgnoreCase("medium"))
					item = getMediumItem(range);
				else if (difficulty.equalsIgnoreCase("hard"))
					item = getHardItem(range);
				item.setName(itemsPurchased.get(j));
				items.add(item);
			}
			problem.getProblem().add(items);
		}
		
		dataSource.close();
		return problem;
	}
}
