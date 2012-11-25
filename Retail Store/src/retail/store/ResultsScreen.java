package retail.store;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class ResultsScreen extends Activity implements OnClickListener{

	Button restart_button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);
        
        restart_button = (Button)findViewById(R.id.restart_button);
        restart_button.setOnClickListener(this);
        
        //retrieve extras from problem screen
        Bundle extras = getIntent().getExtras();
        
        //populate list
        ListView results = (ListView)findViewById(R.id.results);
        String[] values = new String[]{"Correct: " + extras.getInt("Correct")};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		  android.R.layout.simple_list_item_1, android.R.id.text1, values);
        results.setAdapter(adapter);
        
    }
    
	public void onClick(View v) {
		if(v == restart_button){
			Intent i = getBaseContext().getPackageManager()
		             .getLaunchIntentForPackage( getBaseContext().getPackageName() );
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
	}
}
