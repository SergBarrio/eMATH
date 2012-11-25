package retail.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProblemScreen extends Activity {

	Button submitbutton;
	ImageView customer1, customer2, customer3, customer4, customer5;
	TextView customer_num;
	Integer num_correct = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.problem_screen);
	    
	    customer_num = (TextView)findViewById(R.id.item_name_cost);
	    String customer_ident = "Customer #1";
	    customer_num.setText(customer_ident);
	    
	    //set items
	    TextView item1 = (TextView)findViewById(R.id.item1);
	    TextView item2 = (TextView)findViewById(R.id.item2);
	    TextView item3 = (TextView)findViewById(R.id.item3);
	    TextView item4 = (TextView)findViewById(R.id.item4);
	    TextView item5 = (TextView)findViewById(R.id.item5);
	    TextView item6 = (TextView)findViewById(R.id.item6);
	    
	    item1.setText("Bannana - $5", null);
	    item2.setText("Laptop - $5", null);
	    item3.setText("Wallet - $5", null);
	    item4.setText("Soda - $5", null);
	    item5.setText("Gloves - $5", null);
	    item6.setText("Apple - $5", null);
	    
	    //set top drawable for items
	    item4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icons_7, 0, 0);
	    item5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icons_1, 0, 0);
	    
	    //set customer queue
	    customer1 = (ImageView)findViewById(R.id.cust_image1);
	    customer2 = (ImageView)findViewById(R.id.cust_image2);
	    customer3 = (ImageView)findViewById(R.id.cust_image3);
	    customer4 = (ImageView)findViewById(R.id.cust_image4);
	    customer5 = (ImageView)findViewById(R.id.cust_image5);
	    
	    // right now there are 3 placeholder images in the layout
	    // I made it so that the linearlayout has a weightSum of 100
	    // to place items make sure the vertical linearLayout (rows not columns)
	    // have equal weight. So to find the weight for 6 items, 100/6 = 16.66 on each layout
	    
	    submitbutton = (Button)findViewById(R.id.submitbutton);
	    submitbutton.setOnClickListener(submit_pressed);
	    
	}
	
	 private OnClickListener submit_pressed = new OnClickListener(){
		public void onClick(View arg0) {
			// this eliminates customers, on the queue and changes the text
			// problem validation will probably go here
			if (customer1.getVisibility() == View.VISIBLE ){
				customer1.setVisibility(View.GONE);
				
				customer_num.setText("Customer #2");
				return;
			}
			if (customer2.getVisibility() == View.VISIBLE ){
				customer2.setVisibility(View.GONE);
				
				customer_num.setText("Customer #3");
				return;
			}
			if (customer3.getVisibility() == View.VISIBLE ){
				customer3.setVisibility(View.GONE);
				
				customer_num.setText("Customer #4");
				return;
			}
			if (customer4.getVisibility() == View.VISIBLE ){
				customer4.setVisibility(View.GONE);
				
				customer_num.setText("Customer #5");
				return;
			}
			Bundle extras = new Bundle();
			extras.putInt("Correct", num_correct);
			
			Intent resultsScreen = new Intent(ProblemScreen.this, ResultsScreen.class);
			resultsScreen.putExtras(extras);
			startActivity(resultsScreen);
			
		}
	 };
}
