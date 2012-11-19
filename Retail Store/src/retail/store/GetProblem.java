package retail.store;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	private String difficulty = null;
	private HashMap<String,Range> ranges = new HashMap<String,Range>();
	
	public GetProblem(String difficulty) {
			this.difficulty = difficulty;
		
			ranges.put("hardware", new Range(12.5,65.99));
			ranges.put("fruit", new Range(0.5,6.5));
			ranges.put("clothing", new Range(15.0,87.45));
			ranges.put("accessories", new Range(10.5,40.25));
			ranges.put("electronics", new Range(50.0,200.5));
			ranges.put("food", new Range(5.5,18.75));
			ranges.put("school", new Range(5.0,20.0));
			ranges.put("home", new Range(7.0,35.2));
			ranges.put("pet", new Range(4.5,12.25));
			ranges.put("sports", new Range(7.5,35.4));
			ranges.put("vehicle", new Range(7.5,25.25));
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
		
		// Get 5 gategories from db
		ArrayList<String> categories = new ArrayList<String>();
		
		for (int i=0;i<categories.size();i++) {
			Range range = ranges.get(categories.get(i));
			
			// Get a random number of items in category i
			ArrayList<String> itemsPurchased = new ArrayList<String>();
			
			for (int j=0;j<itemsPurchased.size();j++) {
				Item item = null;
				if (difficulty.equalsIgnoreCase("easy"))
					item = getEasyItem(range);
				else if (difficulty.equalsIgnoreCase("medium"))
					item = getMediumItem(range);
				else if (difficulty.equalsIgnoreCase("hard"))
					item = getHardItem(range);
				item.setName(itemsPurchased.get(j));
				problem.addItem(customer, item);
			}
			++customer;
		}
		return problem;
	}
}
