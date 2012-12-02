/*
 * This activity is the template for all the puzzles. It gets the appropriate object and populates
 * the corresponding fields in the screen.
 */

package com.measure.madness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.game.logic.GameMethods;
import com.measure.madness.Measure.Note;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;



public class puzzle_screen extends Activity implements OnClickListener{
	static int checkSubmit=0;
	int star =0;
	final String NAME = "name";
    final String IMAGE = "image";
	TextView text;
	LinearLayout linearLayout;
	Gallery galleryView;
	MediaPlayer player;
	public static int solved = 0;
	private EditText userAnswer;
	Spinner spinner;
	Button finish_button;
	private final double[] noteDurations = {1.0,0.5,-0.5,0.25,-0.25,0.75,
			-0.75,0.125,-0.125,0.375,0.0625,-0.0625,0.1875,0.03125,-0.03125,
			0.09375,0.015625,-0.015625,0.046875,0.15};
	public ArrayList<Star> puzzle = new ArrayList<Star>();
	private GameMethods game = new GameMethods();
	
	@SuppressWarnings("unchecked")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puzzle_screen);     
        
        
        final LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        		
        // get the puzzle from the calling activity
        puzzle = (ArrayList<Star>)getIntent().getExtras().getSerializable("puzzle");
        
        // Set up time signature
        linearLayout = (LinearLayout) findViewById(R.id.musiclayout);
        
        View view = findViewById(R.id.timesig);
        
        view = inflater.inflate(R.layout.time_signature_view, null);
        
        TextView timesig = (TextView) view.findViewById(R.id.numerator);
        timesig.setText(String.valueOf(puzzle.get(0).getSheetMusic().get(0).getTimeSignature().getNumerator()));
        timesig = (TextView) view.findViewById(R.id.denominator);
        timesig.setText(String.valueOf(puzzle.get(0).getSheetMusic().get(0).getTimeSignature().getDenominator()));
        
        linearLayout.addView(view, 0);
 
        // set up the music representation with a galleryView. Pass all the measures that make up
     	// the music question to the MusicAdapter object, which populates the galleryView.
		galleryView = (Gallery) findViewById(R.id.gallery1);
		
		finish_button = (Button) findViewById(R.id.finished);
		finish_button.setOnClickListener(this);
		
		for (int i=0; i<puzzle.get(0).getSheetMusic().size(); i++) {
			galleryView.setAdapter(new MusicAdapter(this, puzzle.get(0).getSheetMusic().get(i).getMeasure()));
		}
		
		addItemsOnSpinner();
		
		String midistring = puzzle.get(0).getMidiFileName();
		midistring = midistring.substring(0, midistring.length() - 4); //chop off ".mid"
		Uri midi = Uri.parse( "android.resource://" + getPackageName() + "/raw/" + midistring );
		// Media player for music sample
        player = MediaPlayer.create(this, midi);
        
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
        PopupWindow popUp;
        popUp = new PopupWindow(this);
        
        
    }
	
	// Determine which image to use, based on note duration
	public Object getImage(double note) {
		if (note == 1.0) {
			return R.drawable.note1;
		} else if (note == 0.5) {
			return R.drawable.note1_2;
		} else if (note == -0.5) {
			return R.drawable.rest1_2;
		} else if (note == 0.25) {
			return R.drawable.note1_4;
		} else if (note == -0.25) {
			return R.drawable.rest1_4;
		} else if (note == 0.75) {
			return R.drawable.note3_4;
		} else if (note == 0.125) {
			return R.drawable.note1_8;
		} else if (note == -0.125) {
			return R.drawable.rest1_8;
		} else if (note == 0.375) {
			return R.drawable.note3_8;
		} else if (note == 0.0625) {
			return R.drawable.note1_16;
		} else if (note == -0.0625) {
			return R.drawable.rest1_16;
		} else if (note == 0.1875) {
			return R.drawable.note3_16;
		} else if (note == 0.03125) {
			return R.drawable.note1_32;
		} else if (note == -0.03125) {
			return R.drawable.rest1_32;
		} else if (note == 0.09375) {
			return R.drawable.note3_32;
		} else if (note == 0.015625) {
			return R.drawable.note1_64;
		} else if (note == -0.015625) {
			return R.drawable.rest1_64;
		} else if (note == 0.046875) {
			return R.drawable.note3_64;
		} else if (note == 0.0) {
			return R.drawable.qnote;
		} //else if (note == 0.15) {
			//return R.drawable.n44;
		/*}*/ else {
			return R.drawable.ic_action_search;
		}
	}
	
	// add items into spinner dynamically
	  public void addItemsOnSpinner() {
	 

		spinner = (Spinner) findViewById(R.id.spinner1);
		List<String > list = new ArrayList<String>();
		list.add("Whole note");
		list.add("1/2");
		list.add("1/4");
		list.add("3/4");
		list.add("1/8");
		list.add("3/8");
		list.add("1/16");
		list.add("3/16");
		list.add("1/32");
		list.add("3/32");
		list.add("1/64");
		list.add("3/63");


		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);

		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     	spinner.setAdapter(dataAdapter);
		
	  }
	
	// Play music sample if play button is enabled
	public void onClickPlay(View v) {
		if (game.isPlayEnabled()) {
			player.start();
		}
		game.incrementPressedPlay();
	}
			
	// Verify question 1 when user clicks submit	
	public void onClickSubmit1(View v) {
		// TODO Auto-generated method stub
		boolean correct = false;
		Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
		String Text = mySpinner.getSelectedItem().toString();
		double useranswer = 0;
		if (Text == "1/2")
			useranswer = 0.5;
		else if (Text == "1/4")
			useranswer = 0.25;
		else if(Text == "3/4")
			useranswer = 0.75;
		else if (Text == "1/8")
			useranswer = 0.125;
		else if (Text == "3/8")
			useranswer = 0.375;
		else if (Text == "1/16")
			useranswer = 0.0625;
		else if (Text == "3/16")
			useranswer = 0.1875;
		else if (Text == "1/32")
			useranswer = 0.03125;
		else if (Text == "3/32")
			useranswer = 0.09375;
		else if (Text == "1/64")
			useranswer = 0.015625;
		else if(Text == "3/64")
			useranswer = 0.046875;
		
		double  correctAnswer = puzzle.get(0).getMusicAnswer().get(0).getDuration();
		
		if ( useranswer == correctAnswer)
		{
			correct = true;
			star = star + 1;
		}
		String string = String.valueOf(correct);
		Toast.makeText(v.getContext(),
		        string,
		        Toast.LENGTH_SHORT).show();
		Button myButton = (Button)findViewById(R.id.submit1);
		myButton.setEnabled(false);
		//checkSubmit++;
		//onClickFinish();
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
			star = star + 1;
		}
		Button myButton = (Button)findViewById(R.id.submit2);
		myButton.setEnabled(false);		
		//checkSubmit++;
		//onClickFinish();
	}
	
	// Verify question 3 when user clicks submit
	public void onClickSubmit3(View v) {
		// TODO Auto-generated method stub
		int correctAnswer = puzzle.get(2).getAnswer();
		boolean correct = false;
		if (correctAnswer == Integer.parseInt(userAnswer.getText().toString())) {
			correct = true;
			solved += 1;
			star = star + 1;
		}
		Toast.makeText(v.getContext(),
		        String.valueOf(correct),
		        Toast.LENGTH_SHORT).show();
		Button myButton = (Button)findViewById(R.id.submit3);
		myButton.setEnabled(false);
	}
	
	public void onClickHelp(View v)
	{
        Toast ImageToast = new Toast(getBaseContext());
        LinearLayout toastLayout = new LinearLayout(getBaseContext());
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView image = new ImageView(getBaseContext());
        TextView text = new TextView(getBaseContext());
        image.setImageResource(R.drawable.helper);
       // text.setText("Hello!");
        toastLayout.addView(image);
        toastLayout.addView(text);
        ImageToast.setView(toastLayout);
        ImageToast.setDuration(Toast.LENGTH_LONG);
        ImageToast.show();		
	}
	
	public void onClickFinish(View V)
	{		
		if(V == finish_button){
			Intent myIntent = new Intent(this, activity2.class);
			//myIntent.putExtra("star", star);
			startActivity(myIntent);
		}
	}
	
	// I was trying to determine how to check when the active status should be changed.
	// I didn't finish this.
	private void checkSolved() {
		if (solved >= 3) {
			game.updateActiveState(puzzle.get(0));
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == finish_button){
			Intent myIntent = new Intent(this, activity2.class);
			//myIntent.putExtra("star", star);
			startActivity(myIntent);
		}
	}
}
