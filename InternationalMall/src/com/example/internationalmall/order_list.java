package com.example.internationalmall;


import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import java.util.*;



public class order_list extends ListActivity implements OnItemClickListener{
			
	static int ps_difficulty = restaurant_main.difficulty;
	ArrayList<Ingredient> ingredientArray = new ArrayList<Ingredient>();
	Ingredient test1 = new Ingredient();
	Ingredient test2 = new Ingredient();
	Ingredient test3 = new Ingredient();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);  
        
        test1.setName("Cheese");
        test2.setName("Bread");
        test3.setName("Crackers");
        test1.setRecipe_id((long) 1);
        test2.setRecipe_id((long) 1);
        test3.setRecipe_id((long) 1);
        test1.setIngredient_id((long) 1);
        test2.setIngredient_id((long) 2);
        test3.setIngredient_id((long) 3);
        test1.setUnit("cup");
        test2.setUnit("lb");
        test3.setUnit("oz");
        test1.setAmount(2.5);
        test2.setAmount(2.75);
        test3.setAmount(3);
        ingredientArray.add(test1);
        ingredientArray.add(test2);
        ingredientArray.add(test3);
        
        String names[] = {test1.getName(), test2.getName(), test3.getName()};
        ListView lv = (ListView)findViewById(android.R.id.list);
        
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names));              
    }
    
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		/*String name = (String) getListAdapter().getItem(position);
		if(name.equals("Cheese")){
			Intent start = new Intent(this, problem_screen.class);
			start.putExtra("unit", test1.getUnit());
			start.putExtra("amount", test1.getAmount());
			startActivity(start);
			
		}
		if(name.equals("Bread")){
			Intent start = new Intent(this, problem_screen.class);
			start.putExtra("unit", test2.getUnit());
			start.putExtra("amount", test2.getAmount());
			startActivity(start);
		}
		if(name.equals("Crackers")){
			Intent start = new Intent(this, problem_screen.class);
			start.putExtra("unit", test3.getUnit());
			start.putExtra("amount", test3.getAmount());
			startActivity(start);
		}*/
		Intent start = new Intent(this, problem_screen.class);
		startActivity(start);

	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
		
}
