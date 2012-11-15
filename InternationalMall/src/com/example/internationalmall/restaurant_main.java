/*
 * This activity is the title screen for the app. It reads the configuration file when the 
 * user chooses to play the game.
 */
package com.example.internationalmall;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class restaurant_main extends Activity implements OnClickListener{
	Button easy;
	Button medium;
	Button hard;
	static int difficulty;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_main);
        
        easy = (Button)findViewById(R.id.easy);
        easy.setOnClickListener(this);
        medium = (Button)findViewById(R.id.medium);
        medium.setOnClickListener(this);
        hard = (Button)findViewById(R.id.hard);
        hard.setOnClickListener(this);
        

        //ImageView image = (ImageView)findViewById(R.id.shazz_drawing);
        
        

        ImageView image = (ImageView)findViewById(R.id.shazz_drawing);               

    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


	public void onClick(View v) {
		
		if (v == easy) {
			Score score = new Score(3);
			GetOrder getOrder = new GetOrder(this,"easy");
	        Intent start = new Intent(this, order_list.class);	
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("difficulty", "easy");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		if (v == medium) {
			Score score = new Score(6);
			GetOrder getOrder = new GetOrder(this,"medium");
	        Intent start = new Intent(this, order_list.class);
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("difficulty", "medium");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		if (v == hard) {
			Score score = new Score(9);
			GetOrder getOrder = new GetOrder(this,"hard");
	        Intent start = new Intent(this, order_list.class);
	        start.putExtra("order", getOrder.getOrder());
	        start.putExtra("difficulty", "hard");
	        start.putExtra("score", score);
	        startActivity(start);
		}
		
	}
		
}

