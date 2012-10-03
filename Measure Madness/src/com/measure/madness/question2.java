package com.measure.madness;

import com.game.logic.*;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class question2 extends Activity implements OnClickListener {
	
	private Star star = new Star();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2);
        
        
        Bundle bundle = this.getIntent().getExtras();
        
        if (bundle != null) {
        	star = (Star) bundle.getSerializable("obj");
        }
        
        TextView question = (TextView)findViewById(R.id.textView1);
        question.setText(star.getTextQuestion());
        
        ((RadioButton) findViewById(R.id.radio0)).setText(star.getAnswerChoices().get(0));
        ((RadioButton) findViewById(R.id.radio1)).setText(star.getAnswerChoices().get(1));
        ((RadioButton) findViewById(R.id.radio2)).setText(star.getAnswerChoices().get(2));
        ((RadioButton) findViewById(R.id.radio3)).setText(star.getAnswerChoices().get(3));
    }
	
	public void onRadioButtonClick(View v) {
		RadioButton button = (RadioButton) v;
		int selection = button.getId();
		
		boolean radio0 = ((RadioButton) findViewById(R.id.radio0)).isChecked();
		boolean radio1 = ((RadioButton) findViewById(R.id.radio1)).isChecked();
		boolean radio2 = ((RadioButton) findViewById(R.id.radio2)).isChecked();
		boolean radio3 = ((RadioButton) findViewById(R.id.radio3)).isChecked();
		
		boolean correct = false;
		
		if (radio0) {
			correct = GameMethods.validateQuestion(1,star.getAnswer());
		} else if (radio1) {
			correct = GameMethods.validateQuestion(2,star.getAnswer());
		} else if (radio2) {
			correct = GameMethods.validateQuestion(3,star.getAnswer());
		} else if (radio3) {
			correct = GameMethods.validateQuestion(4,star.getAnswer());
		}
		
		String string = String.valueOf(correct);
		Toast.makeText(v.getContext(),
		        string,
		        Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
