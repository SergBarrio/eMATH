/*
 * This activity is the title screen for the app. It reads the configuration file when the 
 * user chooses to play the game.
 */
package com.example.internationalmall;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class restaurant_main extends Activity implements OnClickListener{
	Button easy;
	Button medium;
	Button hard;
	static int difficulty;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.restaurant_main);
        
        easy = (Button)findViewById(R.id.easy);
        easy.setOnClickListener(this);
        medium = (Button)findViewById(R.id.medium);
        medium.setOnClickListener(this);
        hard = (Button)findViewById(R.id.hard);
        hard.setOnClickListener(this);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
    }
    
	public void onClick(View v) {
		
		if (v == easy) {
			Score score = new Score(3);
			GetOrder getOrder = new GetOrder(this);
	        Intent start = new Intent(this, order_list.class);
	        start.putExtra("times", new ArrayList<ArrayList<Long>>());
	    	start.putExtra("options", new ArrayList<ArrayList<Integer>>());
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("correct_ingredients", 0);
	        start.putExtra("difficulty", "easy");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		if (v == medium) {
			Score score = new Score(3);
			GetOrder getOrder = new GetOrder(this);
	        Intent start = new Intent(this, order_list.class);
	        start.putExtra("times", new ArrayList<ArrayList<Long>>());
	    	start.putExtra("options", new ArrayList<ArrayList<Integer>>());
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("correct_ingredients", 0);
	        start.putExtra("difficulty", "medium");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		if (v == hard) {
			Score score = new Score(3);
			GetOrder getOrder = new GetOrder(this);
	        Intent start = new Intent(this, order_list.class);
	        start.putExtra("times", new ArrayList<ArrayList<Long>>());
	    	start.putExtra("options", new ArrayList<ArrayList<Integer>>());
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("correct_ingredients", 0);
	        start.putExtra("difficulty", "hard");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		
	}
		
}

