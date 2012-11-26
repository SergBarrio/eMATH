package retail.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class splash extends Activity implements OnClickListener{

	Button buttonPlay;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		buttonPlay = (Button)findViewById(R.id.button_play);
		buttonPlay.setOnClickListener(this);
		
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == buttonPlay){
			Intent playGame = new Intent(this, RetailMain.class);
			startActivity(playGame);
		}
	}

}
