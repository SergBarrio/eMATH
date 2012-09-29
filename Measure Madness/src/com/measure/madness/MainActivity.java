package com.measure.madness;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener {

	Button buttonPlay;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonPlay = (Button)findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
        Intent myIntent = new Intent(this, activity2.class);
		if (v == buttonPlay) {
			startActivityForResult(myIntent, 10);		
		}
	}
}
