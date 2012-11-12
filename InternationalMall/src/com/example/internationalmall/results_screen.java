package com.example.internationalmall;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


public class results_screen extends Activity implements OnClickListener{

	private TextView time, correct, incorrect;
	private Button button;
	private Score score;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);   
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
       
        score = (Score)getIntent().getExtras().get("score");
        ArrayList<ArrayList<Long>> times = score.getTimes();
        
        correct = (TextView)findViewById(R.id.num_correct);
        correct.setText(String.valueOf(score.getNumber_correct()));
        
        incorrect = (TextView)findViewById(R.id.num_incorrect);
        incorrect.setText(String.valueOf(score.getNumber_incorrect()));
        
        long toltime = 0;
        String secn;
        String mint;
        
        for (int i = 0; i<times.size(); i++) {
        	for (int j=0; j<times.get(i).size(); j++) {
        		long temp = times.get(i).get(j);
        		toltime = toltime + temp;
        	}
        }
        long min = toltime / 60;
        long sec = toltime % 60;
        if (sec < 10 ){
        	secn = Long.toString(sec);
        	secn = "0"+secn;
        }
        else 
        	secn = Long.toString(sec);
        
        if (min < 10 ){
        	mint = Long.toString(min);
        	mint = "0"+mint;
        }
        else 
        	mint = Long.toString(min);

        
        time=(TextView)findViewById(R.id.time_solve);
        time.setText(mint + " : " + secn);
  
    }

	public void onClick(View v) {
		if (v == button) {
	        Intent start = new Intent(this, restaurant_main.class);
	        startActivity(start);
		}
	}
	
}
