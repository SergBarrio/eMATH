package com.example.internationalmall;

//http://stackoverflow.com/questions/5847422/table-layout-in-android-row-sizing
//http://android.programmerguru.com/android-tablelayout-example/
//go here for xml file help

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.math.fraction.Fraction;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class problem_screen extends Activity implements OnClickListener{
	
	// Button id's
	int submit = R.id.submit;
	int plus_cup1 = R.id.plus_cup1;
	int minus_cup1 = R.id.minus_cup1;
	int plus_cup2 = R.id.plus_cup2;
	int minus_cup2 = R.id.minus_cup2;
	int plus_cup3 = R.id.plus_cup3;
	int minus_cup3 = R.id.minus_cup3;
	int plus_cup4 = R.id.plus_cup4;
	int minus_cup4 = R.id.minus_cup4;
	
	TextView cup1_text, cup2_text, cup3_text, cup4_text;
	TextView cup1_size, cup2_size, cup3_size, cup4_size;
	TextView goal_total;
	TextView showtime;
	
	// Amount variables
	int whole_amount;
	Fraction fraction_amount = Fraction.ZERO;
	
	// Initialize background values of the cups and goal
    public static int numClick_cup1,numClick_cup2,numClick_cup3,numClick_cup4;
    
    private ArrayList<Recipe> order;
    private Ingredient problem;
    private Recipe recipe;
    private Score score;
    private int ingredient_num;
    private Fraction[] measurements = { 
    		Fraction.ONE,
    		Fraction.ONE,
    		Fraction.ONE,
    		Fraction.ONE };
    
    private Fraction result = Fraction.ZERO;
    
    // if easy == 3, if medium == 6, if hard == 9
    public static int remaining_recipes = 0; //default easy
    
	// Collin
	public static long[] times;
	
	long endTime;
	long startTime;
	long elapsedTime;
	long elapsedSecond;
	
	public class MyCount extends CountDownTimer{
		public MyCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}
		@Override
		public void onTick(long millisUntilFinished) {
			showtime=(TextView)findViewById(R.id.showtime);
			showtime.setText( String.valueOf(millisUntilFinished/1000) + " second remaining");
		}
		@Override
		public void onFinish() {
			showtime=(TextView)findViewById(R.id.showtime);
			showtime.setText(":(");
		}

	}
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        MyCount counter = new MyCount(21000,1000);
        counter.start();
        //Count down timer
        showtime = new TextView(this);
        this.setContentView(showtime);
        */
        setContentView(R.layout.problem_screen);
        
		order = (ArrayList<Recipe>)getIntent().getExtras().getSerializable("order");
        recipe = order.get((Integer)getIntent().getExtras().get("problem"));
        ingredient_num = (Integer)getIntent().getExtras().get("ingredient");
        problem = recipe.getIngredients().get(ingredient_num);
        remaining_recipes = (Integer)getIntent().getExtras().getInt("remaining_recipes");
        score = (Score)getIntent().getExtras().get("score");
        
        try {
        	whole_amount = 0;
        	double number = problem.getAmount();
        	while (number >= 1) {
        		number -= 1;
        		whole_amount++;
        	}

        	if (number < 1 && number > 0) {
        		if (number == 0.33) {
        			fraction_amount = new Fraction(0.3);
        		} else {
        			fraction_amount = Fraction.ONE_THIRD;
        		}
        	}

        	String problem_text = "";
        	if (whole_amount >= 1 && number != 0.0) {
        		problem_text = 
        				String.valueOf(whole_amount) + " " + 
						fraction_amount + " " + 
						problem.getUnit() + " of " + 
						problem.getName();
        	} else if (whole_amount >= 1 && number == 0.0) {
        		problem_text = String.valueOf(whole_amount) + " " +
        				problem.getUnit() + " of " +
        				problem.getName();
        	} else if (whole_amount == 0) {
        		problem_text = fraction_amount + " " +
        				problem.getUnit() + " of " +
        				problem.getName();
        	}
        	
        	startTime = System.currentTimeMillis();
        	
        	result = fraction_amount.add(whole_amount);
        	setMeasurements();
        	
        	goal_total=(TextView)findViewById(R.id.goal_total);
        	goal_total.setText(problem_text);

        	cup1_text=(TextView)findViewById(R.id.cup1_text);
        	cup2_text=(TextView)findViewById(R.id.cup2_text);
        	cup3_text=(TextView)findViewById(R.id.cup3_text);
        	cup4_text=(TextView)findViewById(R.id.cup4_text);

        	cup1_text.setText("0");
        	cup2_text.setText("0");
        	cup3_text.setText("0");
        	cup4_text.setText("0");

        	cup1_size=(TextView)findViewById(R.id.cup1_size);
        	cup2_size=(TextView)findViewById(R.id.cup2_size);
        	cup3_size=(TextView)findViewById(R.id.cup3_size);
        	cup4_size=(TextView)findViewById(R.id.cup4_size);

        	cup1_size.setText(measurements[0].toString() + " " + problem.getUnit());
        	cup2_size.setText(measurements[1].toString() + " " + problem.getUnit());
        	cup3_size.setText(measurements[2].toString() + " " + problem.getUnit());
        	cup4_size.setText(measurements[3].toString() + " " + problem.getUnit());
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    // This function selects the proper measurements to be used
    // based on the total amount.
    private void setMeasurements() {
    	
    	// If there is a fractional part to the total amount
    	// then randomly assign the different measures
    	if (fraction_amount != Fraction.ZERO) {
    		Random rand = new Random(System.currentTimeMillis());
    		int set = 0;
    		Fraction[] factors = { Fraction.ONE_HALF, Fraction.ONE_QUARTER, Fraction.TWO, Fraction.ONE };
    		while (set !=4) {
    			int index = rand.nextInt(4);
    			if (measurements[index] == Fraction.ONE) {
    				measurements[index] = fraction_amount.multiply(factors[index]);
    				set++;
    			}
    		}
    	} else {
    		measurements[0] = Fraction.ONE_FIFTH;
    		measurements[1] = Fraction.ONE_THIRD;
    		measurements[2] = Fraction.THREE_FIFTHS;
    		measurements[3] = Fraction.ONE_QUARTER;
    	}
    }
    
	public void onClick(View v) {
		int click_id = v.getId();
		
		if (click_id == submit){
			// Sergio - validating input here
			Boolean correct = false;
			
			Fraction frac_response = Fraction.ZERO;
			frac_response = frac_response.add(measurements[0].multiply(numClick_cup1));
			frac_response = frac_response.add(measurements[1].multiply(numClick_cup2));
			frac_response = frac_response.add(measurements[2].multiply(numClick_cup3));
			frac_response = frac_response.add(measurements[3].multiply(numClick_cup4));
			
			if (frac_response.equals(result)) { correct = true; }
			
			Toast.makeText(v.getContext(),
			        String.valueOf(correct),
			        Toast.LENGTH_LONG).show();
			
			if (correct) {
				score.setNumber_correct(score.getNumber_correct()+1);
			} else {
				score.setNumber_incorrect(score.getNumber_incorrect()+1);
			}
			
			int remaining_ingredients = recipe.getIngredients().size()-ingredient_num-1;
			
			// Continue game logic
			numClick_cup1=numClick_cup2=numClick_cup3=numClick_cup4=0;
			if (remaining_ingredients > 0 && remaining_recipes > 0){
				int problem = (Integer)getIntent().getExtras().get("problem");
				Intent start = new Intent(this, problem_screen.class);
				endTime = System.currentTimeMillis();
				elapsedTime =  endTime - startTime;
				elapsedSecond = elapsedTime / 1000;
				score.setTimes(elapsedSecond, problem);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				start.putExtra("remaining_recipes", remaining_recipes);
				start.putExtra("problem", problem);
				start.putExtra("ingredient", ++ingredient_num);
				start.putExtra("order", order);
				start.putExtra("score", score);
				startActivity(start);
			}
			else if (remaining_ingredients == 0 && remaining_recipes > 1){
				int problem = (Integer)getIntent().getExtras().get("problem");
				Intent start = new Intent(this, order_list.class);
				endTime = System.currentTimeMillis();
				elapsedTime = endTime - startTime;
				elapsedSecond = elapsedTime / 1000;
				score.setTimes(elapsedSecond, problem);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				start.putExtra("remaining_recipes", remaining_recipes);
				start.putExtra("problem", problem);
				start.putExtra("order", order);
				start.putExtra("score", score);
				startActivity(start);
			}
			else if (remaining_ingredients == 0 && remaining_recipes == 1){
				int problem = (Integer)getIntent().getExtras().get("problem");
				Intent start = new Intent(this, results_screen.class);
				endTime = System.currentTimeMillis();
				elapsedTime = endTime - startTime;
				elapsedSecond = elapsedTime / 1000;
				score.setTimes(elapsedSecond, problem);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				start.putExtra("score", score);
				startActivity(start);
			}
		}
		
		if (click_id == plus_cup1){
			//add cup1 size to total
			numClick_cup1++;
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		if (click_id == minus_cup1){
			//add cup1 size to total
			if(numClick_cup1 > 0) { numClick_cup1--; } //decrement								
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		
		if (click_id == plus_cup2){
			//add cup1 size to total
			numClick_cup2++;
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		if (click_id == minus_cup2){
			//add cup1 size to total
			if(numClick_cup2 > 0) { numClick_cup2--; } //decrement								
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		if (click_id == plus_cup3){
			//add cup1 size to total
			numClick_cup3++;
			cup3_text.setText(Integer.toString(numClick_cup3));
			
		}
		if (click_id == minus_cup3){
			//add cup1 size to total	
			if(numClick_cup3 > 0) { numClick_cup3--; } //decrement								
			cup3_text.setText(Integer.toString(numClick_cup3));
		}
		
		if (click_id == plus_cup4){
			//add cup1 size to total
			numClick_cup4++;
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
		if (click_id == minus_cup4){
			//add cup1 size to total	
			if(numClick_cup4 > 0) { numClick_cup4--; } //decrement								
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
	}
}