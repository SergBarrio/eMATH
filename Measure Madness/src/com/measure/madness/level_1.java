package com.measure.madness;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class level_1 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_1);
    }
    
    public void onClickPuzzle1(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	startActivity(intent);
    }
    
    public void onClickPuzzle2(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	startActivity(intent);
    }
    
    public void onClickPuzzle3(View v) {
    	Intent intent = new Intent(this,puzzle_screen.class);
    	startActivity(intent);
    }
}
