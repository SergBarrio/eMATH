package retail.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Instruction extends Activity implements OnClickListener{

	Button back;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instruction);
		
		back = (Button)findViewById(R.id.button_back);
		back.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == back){
			Intent back_game = new Intent(this, Splash.class);
			startActivity(back_game);
		}

	}

}