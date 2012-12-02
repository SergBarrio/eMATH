/*
 * This activity serves as the engine for the tabs and receives the game configuration
 * from MainActivity after it is parsed.
 */

package com.measure.madness;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.TabActivity;
import android.view.Menu;
import android.widget.Button;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class activity2 extends TabActivity {
	Button buttonPlay;
	private ArrayList<ArrayList<Star>> gameConfig = new ArrayList<ArrayList<Star>>();
	
    @SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        
        TabHost tabHost = getTabHost();
        tabHost.setup();
        gameConfig = (ArrayList<ArrayList<Star>>)getIntent().getSerializableExtra("configuration");
        
        // Tab level 1
        TabSpec level1spec = tabHost.newTabSpec("Level 1");
        // setting Title and Icon for the Tab
        level1spec.setIndicator("Level 1", getResources().getDrawable(R.drawable.icon_level_tab));
        Intent level1Intent = new Intent(this, level_1.class);
        // pass game configuration
        
        level1Intent.putExtra("configuration", gameConfig);
        level1spec.setContent(level1Intent);
        
        // Tab level 2
        TabSpec level2spec = tabHost.newTabSpec("Level 2");
        // setting Title and Icon for the Tab
        level2spec.setIndicator("Level 2", getResources().getDrawable(R.drawable.icon_level_tab));
        Intent level2Intent = new Intent(this, level_2.class);
        // pass game configuration
        level2Intent.putExtra("configuration", gameConfig);
        level2spec.setContent(level2Intent);
        
        // Tab level 3
        TabSpec level3spec = tabHost.newTabSpec("Level 3");
        // setting Title and Icon for the Tab
        level3spec.setIndicator("Level 3", getResources().getDrawable(R.drawable.icon_level_tab));
        Intent level3Intent = new Intent(this, level_3.class);
        // pass game configuration
        level3Intent.putExtra("configuration", gameConfig);
        level3spec.setContent(level3Intent);
        
        // Tab level 4
        TabSpec level4spec = tabHost.newTabSpec("Level 4");
        // setting Title and Icon for the Tab
        level4spec.setIndicator("Level 4", getResources().getDrawable(R.drawable.icon_level_tab));
        Intent level4Intent = new Intent(this, level_4.class);
        // pass game configuration
        level4Intent.putExtra("configuration", gameConfig);
        level4spec.setContent(level4Intent);
        
        
        tabHost.addTab(level1spec);
        tabHost.addTab(level2spec);
        tabHost.addTab(level3spec);
        tabHost.addTab(level4spec);
        tabHost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_2, menu);
        return true;
    }
}