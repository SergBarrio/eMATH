package retail.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CustomerList extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_retail_customers);
	    
	    //first set up list
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
		
		//set start button
		Button start_button;
		start_button = (Button)findViewById(R.id.startbutton);
		start_button.setOnClickListener(this);
		
	}
	
	public void onClick(View v) {
		//only one button, so we don't need any if statements
		Intent start_problems = new Intent(this, ProblemScreen.class);
		startActivity(start_problems);
	}

	//extended class allows us to customize the list
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
