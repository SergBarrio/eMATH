/*
 * This class inserts the proper attributes to the view within the GridView.
 */

package com.measure.madness;

import java.util.Vector;

import com.measure.madness.Measure.Note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {
	private Context context;
	private final Vector<Note> noteValues;
	
	// Constructor for the adapter
	public MusicAdapter(Context context, Vector<Note> noteValues) {
		this.context = context;
		this.noteValues = noteValues;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View view;
	 
			if (convertView == null) {
	 
				view = new View(context);
	 
				// get layout from music_view.xml
				view = inflater.inflate(R.layout.music_view, null);
				ImageView imageView;
				Note note;
				
				// set note into textview
				TextView textView = (TextView) view
						.findViewById(R.id.note);
				textView.setText(String.valueOf(noteValues.get(position).getNote()));
	 
				// set image based on proper note
				imageView = (ImageView) view
						.findViewById(R.id.noteImage);
				note = noteValues.get(position);
				setImage(imageView,note);

	 
			} else {
				view = (View) convertView;
			}
	 
			return view;
	}
	
	// Determine which image to use, based on note duration
	public static void setImage(ImageView imageView, Note note) {
		if (note.getDuration() == 1.0) {
			imageView.setImageResource(R.drawable.note1);
		} else if (note.getDuration() == 0.5) {
			imageView.setImageResource(R.drawable.note1_2);
		} else if (note.getDuration() == -0.5) {
			imageView.setImageResource(R.drawable.rest1_2);
		} else if (note.getDuration() == 0.25) {
			imageView.setImageResource(R.drawable.note1_4);
		} else if (note.getDuration() == -0.25) {
			imageView.setImageResource(R.drawable.rest1_4);
		} else if (note.getDuration() == 0.75) {
			imageView.setImageResource(R.drawable.note3_4);
		} else if (note.getDuration() == 0.125) {
			imageView.setImageResource(R.drawable.note1_8);
		} else if (note.getDuration() == -0.125) {
			imageView.setImageResource(R.drawable.rest1_8);
		} else if (note.getDuration() == 0.375) {
			imageView.setImageResource(R.drawable.note3_8);
		} else if (note.getDuration() == 0.0625) {
			imageView.setImageResource(R.drawable.note1_16);
		} else if (note.getDuration() == -0.0625) {
			imageView.setImageResource(R.drawable.rest1_16);
		} else if (note.getDuration() == 0.1875) {
			imageView.setImageResource(R.drawable.note3_16);
		} else if (note.getDuration() == 0.03125) {
			imageView.setImageResource(R.drawable.note1_32);
		} else if (note.getDuration() == -0.03125) {
			imageView.setImageResource(R.drawable.rest1_32);
		} else if (note.getDuration() == 0.09375) {
			imageView.setImageResource(R.drawable.note3_32);
		} else if (note.getDuration() == 0.015625) {
			imageView.setImageResource(R.drawable.note1_64);
		} else if (note.getDuration() == -0.015625) {
			imageView.setImageResource(R.drawable.rest1_64);
		} else if (note.getDuration() == 0.046875) {
			imageView.setImageResource(R.drawable.note3_64);
		} else if (note.getDuration() == 0.0) {
			imageView.setImageResource(R.drawable.ic_action_search);
		} else {
			imageView.setImageResource(R.drawable.ic_launcher);
		}
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return noteValues.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
