package com.example.internationalmall;

//http://stackoverflow.com/questions/5847422/table-layout-in-android-row-sizing
//http://android.programmerguru.com/android-tablelayout-example/
//go here for xml file help

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;

public class problem_screen extends Activity implements OnClickListener{

	Button button;
	Button cup1;
	Button cup2;
	Button cup3;
	Button cup4;
	
	Button plus_cup1;
	Button minus_cup1;
	Button plus_cup2;
	Button minus_cup2;
	Button plus_cup3;
	Button minus_cup3;
	Button plus_cup4;
	Button minus_cup4;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_screen);  
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        
        cup1 = (Button)findViewById(R.id.cup1);
        cup1.setOnClickListener(this);
        
        cup2 = (Button)findViewById(R.id.cup2);
        cup2.setOnClickListener(this);
        
        cup3 = (Button)findViewById(R.id.cup3);
        cup3.setOnClickListener(this);
        
        cup4 = (Button)findViewById(R.id.cup4);
        cup4.setOnClickListener(this);
        
        plus_cup1 = (Button)findViewById(R.id.plus_cup1);
        plus_cup1.setOnClickListener(this);
        minus_cup1 = (Button)findViewById(R.id.minus_cup1);
        minus_cup1.setOnClickListener(this);
        
        plus_cup2 = (Button)findViewById(R.id.plus_cup2);
        plus_cup2.setOnClickListener(this);
        minus_cup2 = (Button)findViewById(R.id.minus_cup2);
        minus_cup2.setOnClickListener(this);
        
        plus_cup3 = (Button)findViewById(R.id.plus_cup3);
        plus_cup3.setOnClickListener(this);
        minus_cup3 = (Button)findViewById(R.id.minus_cup3);
        minus_cup3.setOnClickListener(this);
        
        plus_cup4 = (Button)findViewById(R.id.plus_cup4);
        plus_cup4.setOnClickListener(this);
        minus_cup4 = (Button)findViewById(R.id.minus_cup4);
        minus_cup4.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		if (v == button) {
	        Intent start = new Intent(this, results_screen.class);
	        startActivity(start);
		}
		
		if(v == cup1){
			//add cup1 size to total	
		}
		
		if(v == cup2){
			//add cup1 size to total	
		}
		
		if(v == cup3){
			//add cup1 size to total	
		}
		
		if(v == cup4){
			//add cup1 size to total	
		}
		
	}
			
	
}
