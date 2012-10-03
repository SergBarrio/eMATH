package com.measure.madness;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class level_2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_2);
        
    }

	public void onClickButton(View v) {
		
		Intent intent = new Intent(this,puzzle_screen.class);
		intent.putExtra("text", "News for you!");
		startActivity(intent);
		
		/*
		int mExternalStorageAvailable = 0;
        int mExternalStorageWriteable = 0;
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // We can read and write the media
            mExternalStorageAvailable = mExternalStorageWriteable = 1;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            // We can only read the media
            mExternalStorageAvailable = 1;
            mExternalStorageWriteable = 0;
        } else {
            // Something else is wrong. It may be one of many other states, but all we need
            //  to know is we can neither read nor write
            mExternalStorageAvailable = mExternalStorageWriteable = 1;
        }
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage(String.valueOf(mExternalStorageAvailable))
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    level_2.this.finish();
	               }
	           })
	           .setNegativeButton("No", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	               }
	           });
	    AlertDialog alert = builder.create();
        
	    Star star = new Star();
	    
        if (mExternalStorageAvailable == 1) {
        	File directory = Environment.getExternalStorageDirectory();
        	
        	File file = new File(directory + "/test.xml");
        	
        	InputStream in;
        	try {
        		ConfigurationParser parser = new ConfigurationParser();
				in = new FileInputStream(file);
				List<List<Star>> list = parser.parse(in);
				List<Star> list2 = list.get(0);
				if (list2 != null) {
					star = list2.get(0);
				}
			    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (star != null) {
			Intent intent1 = new Intent(this,question2.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable("obj", star);
			intent1.putExtra("obj", bundle);
			startActivity(intent1);
        }
        */
	}
}