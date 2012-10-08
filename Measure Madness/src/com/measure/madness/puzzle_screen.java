/*
 * This activity is the template for all the puzzles. It gets the appropriate object and populates
 * the corresponding fields in the screen.
 */

package com.measure.madness;

import java.util.ArrayList;
import com.game.logic.GameMethods;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class puzzle_screen extends Activity {
	
	TextView text;
	GridView gridView;
	MediaPlayer player;
	private int solved = 0;
	private EditText userAnswer;
	private ArrayList<Star> puzzle = new ArrayList<Star>();
	private GameMethods game = new GameMethods();
	
	@SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_screen);
        
        // get the puzzle from the calling activity
        puzzle = (ArrayList<Star>)getIntent().getExtras().getSerializable("puzzle");
 
		gridView = (GridView) findViewById(R.id.gridView1);
		
		// set up the music representation with a GridView. Pass all the measures that make up
		// the music question to the MusicAdapter object, which populates the GridView.
		for (int i=0; i<puzzle.get(0).getSheetMusic().size(); i++) {
			gridView.setAdapter(new MusicAdapter(this, puzzle.get(0).getSheetMusic().get(i).getMeasure()));
		}
        
		// Media player for music sample
        player = MediaPlayer.create(this, R.raw.battle);
        
        // Question 1 text
        TextView question = (TextView)findViewById(R.id.question1);
        question.setText(puzzle.get(1).getQuestion());
        
        // Write appropriate answer choices
        ((RadioButton) findViewById(R.id.choice0)).setText(puzzle.get(1).getAnswerChoices().get(0));
        ((RadioButton) findViewById(R.id.choice1)).setText(puzzle.get(1).getAnswerChoices().get(1));
        ((RadioButton) findViewById(R.id.choice2)).setText(puzzle.get(1).getAnswerChoices().get(2));
        ((RadioButton) findViewById(R.id.choice3)).setText(puzzle.get(1).getAnswerChoices().get(3));
        
        // Question 2 text
        question = (TextView)findViewById(R.id.question2);
        question.setText(puzzle.get(2).getQuestion());
        
        // User answer from input field
        userAnswer = (EditText)findViewById(R.id.answer);
    }
	
	// Play music sample if play button is enabled
	public void onClickPlay(View v) {
		if (game.isPlayEnabled()) {
			player.start();
		}
		game.incrementPressedPlay();
	}

	public void onClickSubmit1(View v) {
		// TODO Auto-generated method stub
		
	}
	
	// Verify question 2 when user clicks submit
	public void onClickSubmit2(View v) {
		// TODO Auto-generated method stub
		boolean radio0 = ((RadioButton) findViewById(R.id.choice0)).isChecked();
		boolean radio1 = ((RadioButton) findViewById(R.id.choice1)).isChecked();
		boolean radio2 = ((RadioButton) findViewById(R.id.choice2)).isChecked();
		boolean radio3 = ((RadioButton) findViewById(R.id.choice3)).isChecked();
		
		boolean correct = false;
		
		if (radio0) {
			correct = GameMethods.validateQuestion(1,puzzle.get(1).getAnswer());
		} else if (radio1) {
			correct = GameMethods.validateQuestion(2,puzzle.get(1).getAnswer());
		} else if (radio2) {
			correct = GameMethods.validateQuestion(3,puzzle.get(1).getAnswer());
		} else if (radio3) {
			correct = GameMethods.validateQuestion(4,puzzle.get(1).getAnswer());
		}
		
		String string = String.valueOf(correct);
		Toast.makeText(v.getContext(),
		        string,
		        Toast.LENGTH_SHORT).show();
		
		if (correct) {
			solved += 1;
		}
	}
	
	// Verify question 3 when user clicks submit
	public void onClickSubmit3(View v) {
		// TODO Auto-generated method stub
		int correctAnswer = 12;
		boolean correct = false;
		if (correctAnswer == Integer.parseInt(userAnswer.getText().toString())) {
			correct = true;
			solved += 1;
			
		}
		Toast.makeText(v.getContext(),
		        String.valueOf(correct),
		        Toast.LENGTH_SHORT).show();
	}
	
	// I was trying to determine how to check when the active status should be changed.
	// I didn't finish this.
	private void checkSolved() {
		if (solved >= 3) {
			game.updateActiveState(puzzle.get(0));
		}
	}
}
