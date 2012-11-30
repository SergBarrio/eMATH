package retail.store;

import java.text.DecimalFormat;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProblemScreen extends Activity {

	Button submitbutton;
	ImageView customer1, customer2, customer3, customer4, customer5;
	TextView customer_num;
	Integer num_correct = 0;
	private int[] itemIDs = {R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5, R.id.item6};
	ArrayList<ArrayList<Item>> problemList;
	int problem_index;
	double curr_answer = 0;
	EditText answerbox;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.problem_screen);

	    customer_num = (TextView)findViewById(R.id.item_name_cost);
	    String customer_ident = "Customer #1";
	    customer_num.setText(customer_ident);
	    
	    //take problem that has been generated
	    Problem problem = (Problem)getIntent().getExtras().get("problem");
	    problemList = problem.getProblem();
	    problem_index = (Integer)getIntent().getExtras().get("index");
	    
	    curr_answer = makeProblem();
	    System.out.println(curr_answer);
	    
	    answerbox = (EditText)findViewById(R.id.answerbox);
	    
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
	
	 private double makeProblem() {
		ArrayList<Item> curr_problem = problemList.get(problem_index);
	    //format double to 2 decimal places
	    DecimalFormat df = new DecimalFormat("#.##");
	    double running_sum = 0;
	    
	    for (int h=0; h < itemIDs.length; h++){
	    	TextView item = (TextView)findViewById(itemIDs[h]);
	    	item.setVisibility(View.VISIBLE);
	    }
	    
	    for (int i=0; i < curr_problem.size()-1; i++){
	    	TextView item = (TextView)findViewById(itemIDs[i]);
	    	double price = Double.parseDouble(df.format(curr_problem.get(i).getPrice()));
	    	int quantity = curr_problem.get(i).getQuantity();
	    	
	    	item.setText(curr_problem.get(i).getName() 
	    	+ "\n$" + price 
	    	+ " x " + quantity);
	    	
	    	running_sum += (price * quantity);
	    }
	    
	    for (int j=curr_problem.size()-1; j < itemIDs.length; j++) {
	    	TextView item = (TextView)findViewById(itemIDs[j]);
	    	item.setVisibility(View.GONE);
	    }
		problem_index++;
		return running_sum;
	}
	 
	private void showToast(boolean answer_provided, boolean answer_correct){
		Context context = getApplicationContext();
		CharSequence text = "";
		if(answer_provided){
			if(answer_correct) { text = "Correct"; }
			else{ text = "Incorrect"; }
		}else{
			text = "Please supply an answer";
		}
		//this will always execute
		int duration = Toast.LENGTH_SHORT;
		
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	private OnClickListener submit_pressed = new OnClickListener(){
		public void onClick(View arg0) {
			
			String input_text = answerbox.getText().toString();
			
			// this eliminates customers, on the queue and changes the text
			// problem validation will probably go here
			if (customer1.getVisibility() == View.VISIBLE ){
				
				if( input_text != null && input_text.length() > 0 ){
					if (Double.parseDouble(input_text) == curr_answer){
						num_correct++;
						showToast(true, true);
					} else { showToast(true, false); }
				}else{
					//we want to give the user a chance to answer
					showToast(false, false);
					return;
				}
				
				customer1.setVisibility(View.GONE);
				
				customer_num.setText("Customer #2");
				curr_answer = makeProblem();
				System.out.println(curr_answer);
				return;
			}
			if (customer2.getVisibility() == View.VISIBLE ){
				
				if( input_text != null && input_text.length() > 0 ){
					if (Double.parseDouble(input_text) == curr_answer){
						num_correct++;
						showToast(true, true);
					} else { showToast(true, false); }
				}else{
					//we want to give the user a chance to answer
					showToast(false, false);
					return;
				}
				
				customer2.setVisibility(View.GONE);
				
				customer_num.setText("Customer #3");
				curr_answer = makeProblem();
				System.out.println(curr_answer);
				return;
			}
			if (customer3.getVisibility() == View.VISIBLE ){
				
				if( input_text != null && input_text.length() > 0 ){
					if (Double.parseDouble(input_text) == curr_answer){
						num_correct++;
						showToast(true, true);
					} else { showToast(true, false); }
				}else{
					//we want to give the user a chance to answer
					showToast(false, false);
					return;
				}
				
				customer3.setVisibility(View.GONE);
				
				customer_num.setText("Customer #4");
				curr_answer = makeProblem();
				System.out.println(curr_answer);
				return;
			}
			if (customer4.getVisibility() == View.VISIBLE ){
				
				if( input_text != null && input_text.length() > 0 ){
					if (Double.parseDouble(input_text) == curr_answer){
						num_correct++;
						showToast(true, true);
					} else { showToast(true, false); }
				}else{
					//we want to give the user a chance to answer
					showToast(false, false);
					return;
				}
				
				customer4.setVisibility(View.GONE);
				
				customer_num.setText("Customer #5");
				curr_answer = makeProblem();
				System.out.println(curr_answer);
				return;
			}
			
			if( input_text != null && input_text.length() > 0 ){
				if (Double.parseDouble(input_text) == curr_answer){
					num_correct++;
					showToast(true, true);
				} else { showToast(true, false); }
			}else{
				//we want to give the user a chance to answer
				showToast(false, false);
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
