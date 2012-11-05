package retail.store;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CustomerList extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_retail_customers);
	    
	    ListView customer_screen = (ListView) findViewById(R.id.customer_list);
	    
	    String[] customerArray = new String[4];
	    
	    // Hard coded for now
	    customerArray[0] = "Alice";
	    customerArray[1] = "Bob";
	    customerArray[2] = "Charlie";
	    customerArray[3] = "David";
	    
	    System.out.println("Element at index 0: "
                + customerArray[0]);
	    
		ArrayAdapter<String> customer_list = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, customerArray);
		
		customer_screen.setAdapter(customer_list);
	}

}
