package com.measure.madness;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

public class level_2 extends Activity implements OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_2);
        
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		
		Intent intent1 = new Intent(this,puzzle_screen.class);
		intent1.putExtra("text", "News for you!");
		startActivity(intent1);
	}
}