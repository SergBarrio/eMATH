/*
 * Luis Perozo
 * September 2012
 * This class defines the Measure object which
 * is made up of notes and a time signature.
 */
package com.measure.madness;

import java.io.Serializable;
import java.util.Vector;

public class Measure implements Serializable {
	
	/* Member classes */
	
	// This class defines a time signature //
	public class Tsig implements Serializable {
		// Member variables //
		private int numerator;
		private int denominator;
		
		// Constructors //
		public Tsig() {}
		
		public Tsig(int numerator, int denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}

		// Getters and Setter for member variables //
		public int getNumerator() {
			return numerator;
		}

		public void setNumerator(int numerator) {
			this.numerator = numerator;
		}

		public int getDenominator() {
			return denominator;
		}

		public void setDenominator(int denominator) {
			this.denominator = denominator;
		}
	}
	
	// This class defines a note object //
	public class Note implements Serializable {
		// Member variables //
		private double duration;
		private String note;
		
		// Constructor //
		public Note(String note, double duration) {
			this.duration = duration;
			this.note = note;
		}
		
		// Getters and Setters for member variables //
		public double getDuration() {
			return duration;
		}
		public void setDuration(double duration) {
			this.duration = duration;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
	}
	/* Member classes */
	
	// Member variables //
	private Tsig timeSignature;
	private Vector<Note> measure = new Vector<Note>();
	
	// Constructors //
	public Measure() {}
	
	public Measure (Tsig timeSignature, Vector<Note> measure) {
		this.timeSignature = timeSignature;
		this.measure = measure;
	}
	
	// Getters and Setters for member variables //

	public Tsig getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(Tsig timeSignature) {
		this.timeSignature = timeSignature;
	}

	public void setMeasure(Vector<Note> measure) {
		this.measure = measure;
	}

	public void addNote(Note note) {
		measure.add(note);
	}

	public Vector<Note> getMeasure() {
		return measure;
	}
}
