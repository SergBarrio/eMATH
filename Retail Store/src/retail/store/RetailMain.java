package retail.store;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class RetailMain extends Activity implements OnClickListener{

	Button easy_button, medium_button, hard_button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retail_main);
        
        easy_button = (Button)findViewById(R.id.easy_button);
        easy_button.setOnClickListener(this);
        medium_button = (Button)findViewById(R.id.medium_button);
        medium_button.setOnClickListener(this);
        hard_button = (Button)findViewById(R.id.hard_button);
        hard_button.setOnClickListener(this);
    }
    

	public void onClick(View v) {
		if (v == easy_button){
			GetPurchases getPurchases = new GetPurchases(this,"easy");
			Intent problemStart = new Intent(this, ProblemScreen.class);			
			problemStart.putExtra("purchases", getPurchases.getPurchases());
			problemStart.putExtra("difficulty", "easy");
			startActivity(problemStart);
		}
		if (v == medium_button){
			GetPurchases getPurchases = new GetPurchases(this,"medium");
			Intent problemStart = new Intent(this, ProblemScreen.class);			
			problemStart.putExtra("purchases", getPurchases.getPurchases());
			problemStart.putExtra("difficulty", "medium");
			startActivity(problemStart);
		}
		if (v == hard_button){
			GetPurchases getPurchases = new GetPurchases(this,"hard");
			Intent problemStart = new Intent(this, ProblemScreen.class);		
			problemStart.putExtra("purchases", getPurchases.getPurchases());
			problemStart.putExtra("difficulty", "hard");
			startActivity(problemStart);
		}

	}
}
