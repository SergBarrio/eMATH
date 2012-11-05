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
