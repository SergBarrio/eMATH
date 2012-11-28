package com.example.internationalmall;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Typeface;


public class results_screen extends Activity implements OnClickListener{

	private TextView time, pct_correct, options_used;
	private Button button;
	private String difficulty;
	private Score score;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);   
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        
        TextView txt = (TextView) findViewById(R.id.title);  
        Typeface font = Typeface.createFromAsset(getAssets(), "a_safe_place_to_fall.ttf");  
        txt.setTypeface(font);
       
        difficulty = getIntent().getExtras().getString("difficulty");
        
        score = (Score)getIntent().getExtras().get("score");
        ArrayList<ArrayList<Long>> times = score.getTimes();
        ArrayList<ArrayList<Integer>> options = score.getOptions();
        
        pct_correct = (TextView)findViewById(R.id.pct_correct);
        int total = score.getNumberCorrectRecipes()+score.getNumberIncorrectRecipes();
        pct_correct.setText(String.valueOf((double)score.getNumberCorrectRecipes()/(double)total) + "% correct.");
        
        double avg_options = 0.0;
        for (int i=0; i<options.size(); i++) {
        	for (int j=0; j<options.get(i).get(j); j++) {
        		avg_options += (double)options.get(i).get(j)/4.0;
        	}
        }
        
        options_used = (TextView)findViewById(R.id.options_used);
        options_used.setText(String.valueOf(avg_options) + "% options used");
        
        long toltime = 0;
        int num_of_problems = 0;
        for (int i=0; i<times.size(); i++) {
        	for (int j=0; j<times.get(i).size(); j++) {
        		long temp = times.get(i).get(j);
        		temp -= 5000;
        		if (temp < 0) {
        			temp = 0;
        		}
        		toltime += temp;
        		num_of_problems++;
        	}
        }
        
        long time_per_question = 0;
        if (difficulty.equalsIgnoreCase("easy")) {
        	time_per_question = 25000;
        } else if (difficulty.equalsIgnoreCase("medium")) {
        	time_per_question = 20000;
        } else {
        	time_per_question = 15000;
        }
        
        long max_time = time_per_question * num_of_problems;
        
        double pect_time = (double)toltime/(double)max_time;
        long avg_time = toltime/num_of_problems;
        
        String time_percent = Double.toString(pect_time);
        String average = Double.toString((double)avg_time/1000);
        
        time=(TextView)findViewById(R.id.time_solve);
        time.setText(time_percent + "% of time allowed.");
  
    }
    
    @Override
    public void onBackPressed() {
    }

	public void onClick(View v) {
		if (v == button) {
	        Intent start = new Intent(this, restaurant_main.class);
	        startActivity(start);
		}
	}
	
}
