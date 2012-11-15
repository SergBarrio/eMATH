<<<<<<< HEAD
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
=======
package com.example.internationalmall;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;


public class order_list extends Activity implements OnClickListener{
	static int recipe_pack = 0;	
	
	Button recipe_item_1;
	Button recipe_item_2;
	Button recipe_item_3;
	Button recipe_item_4;
	Button recipe_item_5;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list); 
        if(recipe_pack == 0){
        	recipe_item_1 = (Button)findViewById(R.id.recipe_item_1);
        	recipe_item_1.setOnClickListener(this);
        	recipe_item_1.setText("Beef Empanadas");
        	
        	recipe_item_2 = (Button)findViewById(R.id.recipe_item_2);
        	recipe_item_2.setOnClickListener(this);
        	recipe_item_2.setText("Rice");
        	
        	recipe_item_3 = (Button)findViewById(R.id.recipe_item_3);
        	recipe_item_3.setOnClickListener(this);
        	recipe_item_3.setText("Black Beans");
        	
        	recipe_item_4 = (Button)findViewById(R.id.recipe_item_4);
        	recipe_item_4.setOnClickListener(this);
        	recipe_item_4.setText("Salad");
        	
        	recipe_item_5 = (Button)findViewById(R.id.recipe_item_5);
        	recipe_item_5.setOnClickListener(this);
        	recipe_item_5.setText("Cafe con Leche");
        }
    }

	public void onClick(View v) {
		//opens up different page based on pack
		//only pack 1 included to initialize
		if (v == recipe_item_1 ||v == recipe_item_2 ||v == recipe_item_3 ||v == recipe_item_4 ||v == recipe_item_5 ) {
			//will need to change behavior of problem_screen based on recipe pack
			//right now, only recipe pack 0 named.
	        Intent start = new Intent(this, problem_screen.class);
	        startActivity(start);
		}
	}
	
}
>>>>>>> origin/retail
