package com.measure.madness;

import com.game.logic.GameMethods;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class puzzle_screen extends Activity {
	
	TextView text;
	private EditText userAnswer;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_screen);
        
        //String value1 = getIntent().getExtras().getString("text");
       	//System.out.println(value1);
        //text = (TextView)findViewById(R.id.textView1);
        //text.setText(value1);
        TextView question = (TextView)findViewById(R.id.question1);
        question.setText("Who won?");
        
        ((RadioButton) findViewById(R.id.choice0)).setText("one");
        ((RadioButton) findViewById(R.id.choice1)).setText("two");
        ((RadioButton) findViewById(R.id.choice2)).setText("three");
        ((RadioButton) findViewById(R.id.choice3)).setText("four");
        
        question = (TextView)findViewById(R.id.question2);
        question.setText("How much");
        userAnswer = (EditText)findViewById(R.id.answer);
    }

	public void onClickSubmit1(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void onClickSubmit2(View v) {
		// TODO Auto-generated method stub
		boolean radio0 = ((RadioButton) findViewById(R.id.choice0)).isChecked();
		boolean radio1 = ((RadioButton) findViewById(R.id.choice1)).isChecked();
		boolean radio2 = ((RadioButton) findViewById(R.id.choice2)).isChecked();
		boolean radio3 = ((RadioButton) findViewById(R.id.choice3)).isChecked();
		
		boolean correct = false;
		
		if (radio0) {
			correct = GameMethods.validateQuestion(1,1);
		} else if (radio1) {
			correct = GameMethods.validateQuestion(2,1);
		} else if (radio2) {
			correct = GameMethods.validateQuestion(3,1);
		} else if (radio3) {
			correct = GameMethods.validateQuestion(4,1);
		}
		
		String string = String.valueOf(correct);
		Toast.makeText(v.getContext(),
		        string,
		        Toast.LENGTH_SHORT).show();
	}
	
	public void onClickSubmit3(View v) {
		// TODO Auto-generated method stub
		int correctAnswer = 12;
		boolean correct = false;
		if (correctAnswer == Integer.parseInt(userAnswer.getText().toString())) {
			correct = true;
		}
		Toast.makeText(v.getContext(),
		        String.valueOf(correct),
		        Toast.LENGTH_SHORT).show();
	}

}
