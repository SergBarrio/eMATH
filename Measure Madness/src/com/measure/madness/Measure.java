package com.measure.madness;

import java.util.Vector;

public class Measure {
	private class Note {
		private double duration;
		private int note;
		
		public double getDuration() {
			return duration;
		}
		public void setDuration(double duration) {
			this.duration = duration;
		}
		public int getNote() {
			return note;
		}
		public void setNote(int note) {
			this.note = note;
		}
	}
	
	private Vector<Note> measure;
	
	public void addNote(Note note) {
		measure.add(note);
	}

	public Vector<Note> getMeasure() {
		return measure;
	}
}
