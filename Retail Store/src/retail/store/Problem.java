package retail.store;

import java.io.Serializable;
import java.util.ArrayList;

public class Problem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ArrayList<Item>> problem;
	
	public Problem () {

		problem = new ArrayList<ArrayList<Item>>();
	}
	
	public void addItem(int customer, Item item) {
		ArrayList<Item> curr_customer = new ArrayList<Item>();
		problem.get(customer);
		curr_customer.add(item);
	}
	
	public ArrayList<ArrayList<Item>> getProblem() {
		return problem;
	}
}
