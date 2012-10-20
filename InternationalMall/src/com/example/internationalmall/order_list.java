package com.example.internationalmall;

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

public class order_list extends Activity implements OnClickListener{
	
	Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);   
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

	public void onClick(View v) {
		if (v == button) {
	        Intent playGame = new Intent(this, problem_screen.class);
		}
	}
	
}