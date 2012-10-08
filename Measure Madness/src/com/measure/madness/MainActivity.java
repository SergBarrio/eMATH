/*
 * This activity is the title screen for the app. It reads the configuration file when the 
 * user chooses to play the game.
 */
package com.measure.madness;

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

public class MainActivity extends Activity implements OnClickListener {

	Button buttonPlay;
	Button button;
	MediaPlayer player;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonPlay = (Button)findViewById(R.id.button_play);
        buttonPlay.setOnClickListener(this);
        
        player = MediaPlayer.create(this, R.raw.battle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		
		if (v == buttonPlay) {
			player.start();
	        Intent playGame = new Intent(this, activity2.class);
	        ArrayList<ArrayList<Star>> gameConfiguration = callParser();
	        playGame.putExtra("configuration", gameConfiguration);
	        System.out.println(gameConfiguration.size());
			startActivityForResult(playGame, 10);		
		}
	}
	
	private ArrayList<ArrayList<Star>> callParser() {
		
		// Check if configuration file is available from SDCard
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
	                    MainActivity.this.finish();
	               }
	           })
	           .setNegativeButton("No", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	               }
	           });
	    //AlertDialog alert = builder.create();
	    
	    // If SD Card is available then open the config xml file and parse it
        if (mExternalStorageAvailable == 1) {
        	File directory = Environment.getExternalStorageDirectory();
        	
        	File file = new File(directory + "/test.xml");
        	
        	InputStream in;
        	try {
        		ConfigurationParser parser = new ConfigurationParser();
				in = new FileInputStream(file);
				ArrayList<ArrayList<Star>> gameConfiguration = parser.parse(in);
				
				return gameConfiguration;
			    
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
		return null;
	}
}
