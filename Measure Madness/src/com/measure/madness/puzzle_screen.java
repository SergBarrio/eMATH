package com.measure.madness;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class puzzle_screen extends Activity implements OnClickListener {
	
	TextView text;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_screen);
        
        String value1 = getIntent().getExtras().getString("text");
       	System.out.println(value1);
        text = (TextView)findViewById(R.id.textView1);
        text.setText(value1);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
