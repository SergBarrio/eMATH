package com.measure.madness;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class level_3 extends Activity {
    
private ArrayList<ArrayList<Star>> gameConfig = new ArrayList<ArrayList<Star>>();
	
    @SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_3);
        
        // Obtain game configuration from activity2
        gameConfig = (ArrayList<ArrayList<Star>>)getIntent().getSerializableExtra("configuration");
        System.out.println(gameConfig.size());
    }
    
    /* Puzzle selection buttons. Redirect to puzzle screen with appropriate object */
    public void onClickPuzzle1(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(6));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle2(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(7));    		
    	}
    	startActivity(intent);
    }
    
    public void onClickPuzzle3(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	if (gameConfig != null) {
        	intent.putExtra("puzzle", gameConfig.get(8));    		
    	}
    	startActivity(intent);
    }
}