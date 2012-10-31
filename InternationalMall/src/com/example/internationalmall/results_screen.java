package com.example.internationalmall;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import java.util.*;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.Intent;


public class results_screen extends Activity implements OnClickListener{

	TextView time;
	Button button;
	//public List<long> alltimes = new ArrayList<long>();
	public static long[] alltime= new long[problem_screen.remaining_recipes];
	//TextView time;
	//time=(TextView)findViewById(R.id.time);
	//time.setText(eS);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);   
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
       
        alltime = (long[])getIntent().getExtras().getSerializable("alltime");
        
        long toltime = 0;
        String scen;
        String mint;
        for (int i = 0; i<alltime.length; i++)
        {
        	long temp = alltime[i];
        	toltime = toltime + temp;
        	
        }
        long min = toltime / 60;
        long sec = toltime % 60;
        if (sec < 10 ){
        	scen = Long.toString(sec);
        	scen = "0"+scen;
        }
        else 
        	scen = Long.toString(sec);
        
        if (min < 10 ){
        	mint = Long.toString(min);
        	mint = "0"+mint;
        }
        else 
        	mint = Long.toString(min);

        
        time=(TextView)findViewById(R.id.time);
        time.setText(mint + " : " + scen);
  
  
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		if (v == button) {
	        Intent start = new Intent(this, restaurant_main.class);
	        startActivity(start);
		}
	}
	
}
