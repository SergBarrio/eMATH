package retail.store;

import java.io.Serializable;
import java.util.ArrayList;

public class Problem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ArrayList<Item>> problem;
	
	public Problem () {

		ArrayList<Item> customer = new ArrayList<Item>();
		problem = new ArrayList<ArrayList<Item>>();
		
		for (int i=0;i<5;i++) {
			problem.add(customer);
		}
	}
	
	public void addItem(int customer, Item item) {
		problem.get(customer).add(item);
	}
	
	public ArrayList<ArrayList<Item>> getProblem() {
		return problem;
	}
}
