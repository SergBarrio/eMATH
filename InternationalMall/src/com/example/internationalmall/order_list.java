package com.example.internationalmall;

import java.util.ArrayList;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;

public class order_list extends Activity implements OnClickListener{
	
	// ID's for recipe buttons
	private static int[] button_ids = { 
		R.id.recipe_item_1,
		R.id.recipe_item_2,
		R.id.recipe_item_3,
		R.id.recipe_item_4,
		R.id.recipe_item_5,
		R.id.recipe_item_6, };
	private ArrayList<Recipe> recipes;
	private int remaining_recipes = 0;
	private TextView recipe_item;
	private Score score;
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order_list);
        
        TextView txt = (TextView) findViewById(R.id.textView1);  
        Typeface font = Typeface.createFromAsset(getAssets(), "colors_of_autumn.ttf");  
        txt.setTypeface(font);
        
        // Get recipes pulled from database
        recipes = (ArrayList<Recipe>)getIntent().getExtras().getSerializable("order");
        score = (Score)getIntent().getExtras().getSerializable("score");
        
        ArrayList<Long> times = (ArrayList<Long>)getIntent().getExtras().getSerializable("times");
        ArrayList<Integer> options = (ArrayList<Integer>)getIntent().getExtras().getSerializable("options");
        
        if (times.size() != 0) {
        	score.getTimes().add(times);
        }
        if (options.size() != 0) {
        	score.getOptions().add(options);
        }
        
        int solved = 0;
        for (int i=0; i<recipes.size(); i++) {
        	recipe_item = (TextView)findViewById(button_ids[i]);
        	recipe_item.setOnClickListener(this);
        	String number = String.valueOf(i+1);
        	recipe_item.setText(number + ". " + recipes.get(i).getName());
        	recipe_item.setTypeface(font);
        	
        	if (recipes.get(i).getSolved()) {
        		solved++;
        		int correct = (Integer)getIntent().getExtras().get("correct_ingredients");
        		if ((double)correct/((double)recipes.get(i).getIngredients().size()) > 0.5) {
        			score.setNumberCorrectRecipes(score.getNumberCorrectRecipes()+1);
        		} else {
        			score.setNumberIncorrectRecipes(score.getNumberIncorrectRecipes()+1);
        		}
        		recipe_item.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        	}
        }
        
        remaining_recipes = recipes.size() - solved;
    }

	public void onClick(View v) {

		int button_id = v.getId();
		String difficulty = (String)getIntent().getExtras().get("difficulty");
        Intent start = new Intent(this, problem_screen.class);
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        
        if (button_id == button_ids[0]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 0);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        } else if (button_id == button_ids[1]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 1);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        } else if (button_id == button_ids[2]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem",2);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        } else if (button_id == button_ids[3]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 3);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        } else if (button_id == button_ids[4]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 4);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        } else if (button_id == button_ids[5]) {
        	vibe.vibrate(50);
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 5);
        	start.putExtra("score", score);
        	start.putExtra("difficulty", difficulty);
        	start.putExtra("correct_ingredients", 0);
        }
    	start.putExtra("times", new ArrayList<ArrayList<Long>>());
    	start.putExtra("options", new ArrayList<ArrayList<Integer>>());
		startActivity(start);
	}
	
	@Override
	public void onBackPressed() {
	}
}

