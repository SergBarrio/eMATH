package com.measure.madness;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity2 extends Activity implements OnClickListener {

	Button buttonPlay;
	MediaPlayer player;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        
        buttonPlay = (Button)findViewById(R.id.play);
        buttonPlay.setOnClickListener(this);
        
        player = MediaPlayer.create(this, R.raw.battle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_2, menu);
        return true;
    }

	public void onClick(View v) {
		if (v == buttonPlay) {
			player.start();
		}
	}
}