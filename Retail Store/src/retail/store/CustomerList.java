package retail.store;

import android.app.Activity;
import android.content.Context;
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
	    
		BlockedList customer_list = 
				new BlockedList(this, android.R.layout.simple_list_item_1, customerArray);
		
		customer_screen.setAdapter(customer_list);
		
	}

public class BlockedList extends ArrayAdapter<String>{

	//use same constructor
	public BlockedList(Context context, int textViewResourceId,
			String[] customerArray) {
		super(context, textViewResourceId, customerArray);
	}
	
	//override these two functions to disable items
	public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int position) {
        // we want to always return false (regardless of position) so every item is disabled
    	return false;
    }
	
}

}
