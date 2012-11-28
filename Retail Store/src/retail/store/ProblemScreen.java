package retail.store;

import java.util.ArrayList;

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
	private int[] itemIDs = {R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5, R.id.item6};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.problem_screen);

	    customer_num = (TextView)findViewById(R.id.item_name_cost);
	    String customer_ident = "Customer #1";
	    customer_num.setText(customer_ident);
	    
	    //take problem that has been generated
	    Problem problem = (Problem)getIntent().getExtras().get("problem");
	    ArrayList<ArrayList<Item>> problemList = problem.getProblem();
	    int problem_index = (Integer)getIntent().getExtras().get("index");
	    
	    ArrayList<Item> curr_problem = problemList.get(problem_index);
	    for (int i=0; i < curr_problem.size(); i++){
	    	//format double to 2 decimal places
	    	TextView item = (TextView)findViewById(itemIDs[i]);
	    	item.setText(curr_problem.get(i).getName() 
	    	+ "\n$" + curr_problem.get(i).getPrice() 
	    	+ " x " + curr_problem.get(i).getQuantity());
	    }
	    
	    for (int j=curr_problem.size()-1; j < itemIDs.length; j++) {
	    	TextView item = (TextView)findViewById(itemIDs[j]);
	    	item.setVisibility(View.GONE);
	    }
	    
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
