package com.example.internationalmall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class splash_screen extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);
	}
	
	public void onClick(View v) {
		Intent intent = new Intent(this,restaurant_main.class);
		startActivity(intent);
	}

}
