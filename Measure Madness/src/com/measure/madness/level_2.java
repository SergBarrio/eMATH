package com.measure.madness;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class level_2 extends Activity {
	
	private ArrayList<ArrayList<Star>> gameConfig = new ArrayList<ArrayList<Star>>();
	
    @SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_2);
        
        // Obtain game configuration from activity2
        gameConfig = (ArrayList<ArrayList<Star>>)getIntent().getSerializableExtra("configuration");
        //System.out.println(gameConfig.size());
    }
    
    /* Puzzle selection buttons. Redirect to puzzle screen with appropriate object */
    public void onClickPuzzle1(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(3));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle2(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(4));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle3(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(5));    		
    	}
    	startActivity(intent);
    }
}