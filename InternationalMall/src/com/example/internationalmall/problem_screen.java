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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.Intent;

public class problem_screen extends Activity implements OnClickListener{

	Button button, cup1, cup2, cup3, cup4;	
	Button plus_cup1, minus_cup1, plus_cup2, minus_cup2;
	Button plus_cup3, minus_cup3, plus_cup4, minus_cup4;	
	TextView cup1_text, cup2_text, cup3_text, cup4_text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_screen);  
        /*
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        */
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
        
        cup1_text=(TextView)findViewById(R.id.cup1_text);
        cup2_text=(TextView)findViewById(R.id.cup2_text);
        cup3_text=(TextView)findViewById(R.id.cup3_text);
        cup4_text=(TextView)findViewById(R.id.cup4_text);
        
        cup1_text.setText("0");
        cup2_text.setText("0");
        cup3_text.setText("0");
        cup4_text.setText("0");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public static int numClick_cup1,numClick_cup2,numClick_cup3,numClick_cup4;
    
	public void onClick(View v) {
		if (v == button) {
	        Intent start = new Intent(this, results_screen.class);
	        startActivity(start);
		}
		
		if(v == plus_cup1){
			//add cup1 size to total
			numClick_cup1++;
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		if(v == minus_cup1){
			//add cup1 size to total
			if(numClick_cup1==0) { } //do nothing
			else{ numClick_cup1--; } //decrement								
			cup1_text.setText(Integer.toString(numClick_cup1));
		}
		
		if(v == plus_cup2){
			//add cup1 size to total
			numClick_cup2++;
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		if(v == minus_cup2){
			//add cup1 size to total
			if(numClick_cup2==0) { } //do nothing
			else{ numClick_cup2--; } //decrement								
			cup2_text.setText(Integer.toString(numClick_cup2));
		}
		
		if(v == plus_cup3){
			//add cup1 size to total
			numClick_cup3++;
			cup3_text.setText(Integer.toString(numClick_cup3));
			
		}
		if(v == minus_cup3){
			//add cup1 size to total	
			if(numClick_cup3==0) { } //do nothing
			else{ numClick_cup3--; } //decrement								
			cup3_text.setText(Integer.toString(numClick_cup3));
		}
		
		if(v == plus_cup4){
			//add cup1 size to total
			numClick_cup4++;
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
		if(v == minus_cup4){
			//add cup1 size to total	
			if(numClick_cup4==0) { } //do nothing
			else{ numClick_cup4--; } //decrement								
			cup4_text.setText(Integer.toString(numClick_cup4));
		}
		
	}
			
	
}
