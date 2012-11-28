package retail.store;

import java.io.IOException;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;

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
			Intent problemStart = new Intent(this, ProblemScreen.class);

			GetProblem getProblem = new GetProblem("easy", this);
			Problem problem;
			problem = getProblem.getProblem();
			problemStart.putExtra("problem", problem);
			problemStart.putExtra("index", 0);
			startActivity(problemStart);

		}
		if (v == medium_button){
			Intent problemStart = new Intent(this, ProblemScreen.class);
			
			GetProblem getProblem = new GetProblem("medium", this);
			Problem problem;

			problem = getProblem.getProblem();
			problemStart.putExtra("problem", problem);
			
			problemStart.putExtra("index", 0);
			startActivity(problemStart);
		}
		if (v == hard_button){
			Intent problemStart = new Intent(this, ProblemScreen.class);
			
			GetProblem getProblem = new GetProblem("hard", this);
			Problem problem;

			problem = getProblem.getProblem();
			problemStart.putExtra("problem", problem);

			problemStart.putExtra("index", 0);
			startActivity(problemStart);
		}

	}
}
