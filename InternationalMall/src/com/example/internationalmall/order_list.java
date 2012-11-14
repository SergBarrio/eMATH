package com.example.internationalmall;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class order_list extends Activity implements OnClickListener{
	
	// ID's for recipe buttons
	private static int[] button_ids = { 
		R.id.recipe_item_1,
		R.id.recipe_item_2,
		R.id.recipe_item_3,
		R.id.recipe_item_4,
		R.id.recipe_item_5,
		R.id.recipe_item_6,
		R.id.recipe_item_7,
		R.id.recipe_item_8,
		R.id.recipe_item_9 };
	private ArrayList<Recipe> recipes;
	private int remaining_recipes = 0;
	private Button recipe_item;
	private Score score;
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);
        
        // Get recipes pulled from database
        recipes = (ArrayList<Recipe>)getIntent().getExtras().getSerializable("order");
        score = (Score)getIntent().getExtras().getSerializable("score");
        int solved = 0;
        for (int i=0; i<recipes.size(); i++) {
        	recipe_item = (Button)findViewById(button_ids[i]);
        	recipe_item.setOnClickListener(this);
        	recipe_item.setText(recipes.get(i).getName());
        	
        	if (recipes.get(i).getSolved()) {
        		solved++;
        		recipe_item.setEnabled(false);
        	}
        }
        
        remaining_recipes = recipes.size() - solved;
        
        int inactive_buttons = button_ids.length-recipes.size();
        for (int i=(button_ids.length-inactive_buttons); i<button_ids.length; i++) {
        	recipe_item = (Button)findViewById(button_ids[i]);
        	recipe_item.setVisibility(View.GONE);
        }
    }

	public void onClick(View v) {

		int button_id = v.getId();
        Intent start = new Intent(this, problem_screen.class);

        if (button_id == button_ids[0]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 0);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[1]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 1);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[2]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem",2);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[3]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 3);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[4]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 4);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[5]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 5);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[6]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 6);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[7]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 7);
        	start.putExtra("score", score);
        } else if (button_id == button_ids[8]) {
        	start.putExtra("order", recipes);
        	start.putExtra("ingredient", 0);
        	start.putExtra("remaining_recipes", remaining_recipes);
        	start.putExtra("problem", 8);
        	start.putExtra("score", score);
        }
		startActivity(start);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
		
}
