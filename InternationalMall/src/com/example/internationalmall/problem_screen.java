package com.example.internationalmall;

//http://stackoverflow.com/questions/5847422/table-layout-in-android-row-sizing
//http://android.programmerguru.com/android-tablelayout-example/
//go here for xml file help

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.math.fraction.*;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class problem_screen extends Activity implements OnClickListener{
	
	// Button id's
	int submit = R.id.submit;
	int[] plus_minus = {
			R.id.plus_cup1,
			R.id.minus_cup1,
			R.id.plus_cup2,
			R.id.minus_cup2,
			R.id.plus_cup3,
			R.id.minus_cup3,
			R.id.plus_cup4,
			R.id.minus_cup4
	};
	
	TextView cup1_text, cup2_text, cup3_text, cup4_text;
	TextView cup1_size, cup2_size, cup3_size, cup4_size;
	TextView goal_total;
	TextView showtime;
	
	// Amount variables
	int whole_amount;
	Fraction fraction_amount = Fraction.ZERO;
	
	// Initialize background values of the cups and goal
    public static int numClick_cup1,numClick_cup2,numClick_cup3,numClick_cup4;
    
    private String difficulty;
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
    private Fraction[] fraction_options = {
    		Fraction.ONE_HALF,
    		Fraction.ONE_THIRD,
    		Fraction.ONE_QUARTER,
    		Fraction.ONE_FIFTH,
    		Fraction.ONE_HALF.multiply(Fraction.ONE_THIRD),
    		Fraction.ONE_HALF.multiply(Fraction.ONE_QUARTER),
    		Fraction.TWO_THIRDS,
    		Fraction.TWO_FIFTHS,
    		Fraction.THREE_QUARTERS,
    		Fraction.THREE_FIFTHS,
    		Fraction.FOUR_FIFTHS
    };
    
    private Fraction result = Fraction.ZERO;
    
    // if easy == 3, if medium == 6, if hard == 9
    public static int remaining_recipes = 0; //default easy
    
	// Collin
	public static long[] times;
	
	long endTime;
	long startTime;
	long elapsedTime;
	long elapsedSecond;
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.problem_screen);  
		startTime = System.currentTimeMillis();
		
		order = (ArrayList<Recipe>)getIntent().getExtras().getSerializable("order");
        recipe = order.get((Integer)getIntent().getExtras().get("problem"));
        ingredient_num = (Integer)getIntent().getExtras().get("ingredient");
        problem = recipe.getIngredients().get(ingredient_num);
        remaining_recipes = (Integer)getIntent().getExtras().getInt("remaining_recipes");
        score = (Score)getIntent().getExtras().get("score");
        difficulty = (String)getIntent().getExtras().getString("difficulty");
        
        try {
        	whole_amount = 0;
        	double number = problem.getAmount();
        	while (number >= 1) {
        		number -= 1;
        		whole_amount++;
        	}

        	if (number < 1 && number > 0) {
        		if (number == 0.33) {
        			fraction_amount = Fraction.ONE_THIRD;
        		} else {
        			fraction_amount = new Fraction(number);
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
        	
        	long s = System.currentTimeMillis();
        	setMeasurements();
        	System.out.println(System.currentTimeMillis()-s);
        	
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
        	
    		showtime = (TextView)findViewById(R.id.showtime);
        	
        	if (difficulty.equalsIgnoreCase("easy")) {
    			new CountDownTimer(25000, 1000) {
    	
    			     public void onTick(long millisUntilFinished) {
    			    	 if ((millisUntilFinished / 1000) <= 5) {
    			    		 showtime.setTextColor(Color.RED);
    			    	 }
    			         showtime.setText(String.valueOf(millisUntilFinished / 1000));
    			     }
    	
    			     public void onFinish() {
    			         showtime.setText("0");
    			         TextView next = (TextView)findViewById(submit);
    			         next.setText("Next");
    			         for (int i=0;i<plus_minus.length;i++) {
    			        	 Button button = (Button)findViewById(plus_minus[i]);
    			        	 button.setEnabled(false);
    			         }
    			     }
    			  }.start();
    		} else if (difficulty.equalsIgnoreCase("medium")) {
    			new CountDownTimer(20000, 1000) {
    				
    			     public void onTick(long millisUntilFinished) {
    			    	 if ((millisUntilFinished / 1000) <= 5) {
    			    		 showtime.setTextColor(Color.RED);
    			    	 }
    			         showtime.setText(String.valueOf(millisUntilFinished / 1000));
    			     }
    	
    			     public void onFinish() {
    			         showtime.setText("0");
    			         TextView next = (TextView)findViewById(submit);
    			         next.setText("Next");
    			         for (int i=0;i<plus_minus.length;i++) {
    			        	 Button button = (Button)findViewById(plus_minus[i]);
    			        	 button.setEnabled(false);
    			         }
    			     }
    			  }.start();
    		} else if (difficulty.equalsIgnoreCase("hard")) {
    			new CountDownTimer(15000, 1000) {
    				
    			     public void onTick(long millisUntilFinished) {
    			    	 if ((millisUntilFinished / 1000) <= 5) {
    			    		 showtime.setTextColor(Color.RED);
    			    	 }
    			         showtime.setText(String.valueOf(millisUntilFinished / 1000));
    			     }
    	
    			     public void onFinish() {
    			         showtime.setText("0");
    			         TextView next = (TextView)findViewById(submit);
    			         next.setText("Next");
    			         for (int i=0;i<plus_minus.length;i++) {
    			        	 Button button = (Button)findViewById(plus_minus[i]);
    			        	 button.setEnabled(false);
    			         }
    			     }
    			  }.start();
    		}
        	
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    // This function selects the proper measurements to be used
    // based on the total amount.
    private void setMeasurements() {
    	
    	if (difficulty.equalsIgnoreCase("easy")) {
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
	    		HashSet<Integer> set = new HashSet<Integer>();
	    		Random rand = new Random(System.currentTimeMillis());
	    		while (set.size() < 4) {
	    			int index = rand.nextInt(4);
	    			if (!set.contains(index)) {
	    				set.add(index);
	    			}
	    		}
	    		Iterator<Integer> it = set.iterator();
    			int count = 0;
    			while (it.hasNext()) {
    				measurements[count] = fraction_options[it.next()];
    				count++;
    			}
	    	}
    	} else if (difficulty.equalsIgnoreCase("medium")) {
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
	    		HashSet<Integer> set = new HashSet<Integer>();
	    		Random rand = new Random(System.currentTimeMillis());
	    		while (set.size() < 4) {
	    			int index = rand.nextInt(fraction_options.length);
	    			if (!set.contains(index)) {
	    				set.add(index);
	    			}
	    		}
	    		Iterator<Integer> it = set.iterator();
    			int count = 0;
    			while (it.hasNext()) {
    				measurements[count] = fraction_options[it.next()];
    				count++;
    			}
	    	}
    	} else if (difficulty.equalsIgnoreCase("hard")) {
    		if (fraction_amount != Fraction.ZERO) {
    			Fraction f = fraction_amount.multiply(Fraction.ONE_HALF);
    			
    			HashSet<Fraction> numerator = new HashSet<Fraction>();
    			Fraction one = new Fraction(1,f.getDenominator());
    			numerator.add(one);
    			while (numerator.size() < 4) {
    				int num = 2 + (int)(Math.random()*5);
    				if (!f.multiply(num).equals(fraction_amount) && (num != 2) && !numerator.contains(num) && (num != f.getDenominator())) {
    					numerator.add(f.multiply(num));
    				}
    			}
    			Iterator<Fraction> it = numerator.iterator();
    			int count = 0;
    			while (it.hasNext()) {
    				measurements[count] = it.next();
    				count++;
    			}
    		}
    		else {
    			HashSet<Integer> set = new HashSet<Integer>();
	    		Random rand = new Random(System.currentTimeMillis());
	    		while (set.size() < 4) {
	    			int index = rand.nextInt(fraction_options.length);
	    			if (!set.contains(index)) {
	    				set.add(index);
	    			}
	    		}
	    		Iterator<Integer> it = set.iterator();
    			int count = 0;
    			while (it.hasNext()) {
    				measurements[count] = fraction_options[it.next()];
    				count++;
    			}
    		}
    	}
    }
    
    private int calculateUsage(boolean correct) {
    	
    	int options_used = 0;
    	
    	if (!correct) {
    		return options_used;
    	}
    	
    	if (numClick_cup1 != 0) {
    		options_used++;
    	}
    	if (numClick_cup2 != 0) {
    		options_used++;
    	}
    	if (numClick_cup3 != 0) {
    		options_used++;
    	}
    	if (numClick_cup4 != 0) {
    		options_used++;
    	}
    	
    	return options_used;
    }
    
	public void onClick(View v) {
		int click_id = v.getId();
		Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		if (click_id == submit){
			// Sergio - validating input here
			Boolean correct = false;
			
			Fraction frac_response = Fraction.ZERO;
			frac_response = frac_response.add(measurements[0].multiply(numClick_cup1));
			frac_response = frac_response.add(measurements[1].multiply(numClick_cup2));
			frac_response = frac_response.add(measurements[2].multiply(numClick_cup3));
			frac_response = frac_response.add(measurements[3].multiply(numClick_cup4));
			
			if (frac_response.equals(result)) { correct = true; }
			
			int correct_ingredients = getIntent().getExtras().getInt("correct_ingredients");
			
			Toast.makeText(getApplicationContext(), String.valueOf(correct), Toast.LENGTH_SHORT).show();
			
			if (correct) {
				score.setNumberCorrectIngredients(score.getNumberCorrectIngredients()+1);
				correct_ingredients++;
			} else {
				score.setNumberIncorrectIngredients(score.getNumberIncorrectIngredients()+1);
			}
			
			int remaining_ingredients = recipe.getIngredients().size()-ingredient_num-1;
			
			ArrayList<Long> times = (ArrayList<Long>)getIntent().getExtras().getSerializable("times");
			ArrayList<Integer> options = (ArrayList<Integer>)getIntent().getExtras().getSerializable("options");
			int usage = calculateUsage(correct);
			
			// Continue game logic
			numClick_cup1=numClick_cup2=numClick_cup3=numClick_cup4=0;
			if (remaining_ingredients > 0 && remaining_recipes > 0){
				int problem = (Integer)getIntent().getExtras().get("problem");
				Intent start = new Intent(this, problem_screen.class);
				endTime = System.currentTimeMillis();
				elapsedTime =  endTime - startTime;
				elapsedSecond = elapsedTime / 1000;
				times.add(elapsedSecond);
				options.add(usage);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				start.putExtra("times", times);
				start.putExtra("options", options);
				start.putExtra("correct_ingredients", correct_ingredients);
				start.putExtra("difficulty", difficulty);
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
				times.add(elapsedSecond);
				options.add(usage);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				start.putExtra("times", times);
				start.putExtra("options", options);
				start.putExtra("correct_ingredients", correct_ingredients);
				start.putExtra("difficulty", difficulty);
				start.putExtra("remaining_recipes", remaining_recipes);
				start.putExtra("problem", problem);
				start.putExtra("order", order);
				start.putExtra("score", score);
				startActivity(start);
			}
			else if (remaining_ingredients == 0 && remaining_recipes == 1){
				Intent start = new Intent(this, results_screen.class);
				endTime = System.currentTimeMillis();
				elapsedTime = endTime - startTime;
				elapsedSecond = elapsedTime / 1000;
				times.add(elapsedSecond);
				options.add(usage);
				order.get((Integer)getIntent().getExtras().get("problem")).setSolved(true);
				score.getTimes().add(times);
				score.getOptions().add(options);
				start.putExtra("difficulty", difficulty);
				start.putExtra("score", score);
				startActivity(start);
			}
		}
		else if (click_id == plus_minus[0]){
			vibe.vibrate(50);
			//add cup1 size to total
			numClick_cup1++;
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		else if (click_id == plus_minus[1]){
			vibe.vibrate(50);
			//add cup1 size to total
			if(!difficulty.equalsIgnoreCase("hard")) {
				if (numClick_cup1 > 0) { numClick_cup1--; } //decrement
			} else {
				numClick_cup1--;
			}
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		else if (click_id == plus_minus[2]){
			vibe.vibrate(50);
			//add cup1 size to total
			numClick_cup2++;
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		else if (click_id == plus_minus[3]){
			vibe.vibrate(50);
			//add cup1 size to total
			if(!difficulty.equalsIgnoreCase("hard")) {
				if (numClick_cup2 > 0) { numClick_cup2--; } //decrement
			} else {
				numClick_cup2--;
			}
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		else if (click_id == plus_minus[4]){
			vibe.vibrate(50);
			//add cup1 size to total
			numClick_cup3++;
			cup3_text.setText(Integer.toString(numClick_cup3));
		}
		else if (click_id == plus_minus[5]){
			vibe.vibrate(50);
			//add cup1 size to total	
			if(!difficulty.equalsIgnoreCase("hard")) {
				if (numClick_cup3 > 0) { numClick_cup3--; } //decrement
			} else {
				numClick_cup3--;
			}
			cup3_text.setText(Integer.toString(numClick_cup3));
		}
		else if (click_id == plus_minus[6]){
			vibe.vibrate(50);
			//add cup1 size to total
			numClick_cup4++;
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
		else if (click_id == plus_minus[7]){
			vibe.vibrate(50);
			//add cup1 size to total	
			if(!difficulty.equalsIgnoreCase("hard")) {
				if (numClick_cup4 > 0) { numClick_cup4--; } //decrement
			} else {
				numClick_cup4--;
			}
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
	}
	
	@Override
	public void onBackPressed() {
	}
}