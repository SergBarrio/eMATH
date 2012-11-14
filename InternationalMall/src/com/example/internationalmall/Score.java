package com.example.internationalmall;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Score implements Serializable {
	
	private int number_correct;
	private int number_incorrect;
	private ArrayList<ArrayList<Long> > times = new ArrayList<ArrayList<Long>>();

	public Score(int recipes) {
		this.number_correct = 0;
		this.number_incorrect = 0;
		ArrayList<Long> ingredients = new ArrayList<Long>();
		for (int i=0;i<recipes;i++) {
			this.times.add(ingredients);
		}
	}
	
	public int getNumber_correct() {
		return number_correct;
	}
	public void setNumber_correct(int number_correct) {
		this.number_correct = number_correct;
	}
	public int getNumber_incorrect() {
		return number_incorrect;
	}
	public void setNumber_incorrect(int number_incorrect) {
		this.number_incorrect = number_incorrect;
	}
	
	public ArrayList<ArrayList<Long>> getTimes() {
		return times;
	}

	public void setTimes(long time, int recipe) {
		this.times.get(recipe).add(time);
	}
}
