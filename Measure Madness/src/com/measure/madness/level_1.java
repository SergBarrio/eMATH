package com.measure.madness;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class level_1 extends Activity {
	
	private ArrayList<ArrayList<Star>> gameConfig = new ArrayList<ArrayList<Star>>();
	RatingBar bar1;
	
    @SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_1);
              
        // Obtain game configuration from activity2
        gameConfig = (ArrayList<ArrayList<Star>>)getIntent().getSerializableExtra("configuration");
        System.out.println(gameConfig.size());
        //bar1.setRating(puzzle_screen.solved);
    }
    
    /* Puzzle selection buttons. Redirect to puzzle screen with appropriate object */
    public void onClickPuzzle1(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(0));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle2(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(1));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle3(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(2));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle4(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(3));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle5(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(4));    		
    	}
    	startActivity(intent);
    }
    
}
