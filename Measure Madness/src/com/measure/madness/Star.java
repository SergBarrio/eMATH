/* 
 * Luis Perozo
 * September 2012
 * This class defines the Star object which is made up
 * of a question type, an active marker, a question, and
 * an answer.
 */

package com.measure.madness;

import java.io.Serializable;
import java.util.Vector;

import com.measure.madness.Measure.Note;

@SuppressWarnings("serial")
public class Star implements Serializable {
	
	// Member variables //
	private Boolean active;
	private int questionType;
	private String question;
	private Vector<String> answerChoices = new Vector<String>();
	private int answer;
	private Vector<Measure> sheetMusic = new Vector<Measure>();
	private Vector<Note> musicAnswer = new Vector<Note>();
	
	// Constructors //
	public Star() {}
	
	public Star(Boolean active, int questionType, Vector<Measure> sheetMusic, Vector<Note> musicAnswer) {
		this.active = active;
		this.questionType = questionType;
		this.sheetMusic = sheetMusic;
		this.musicAnswer = musicAnswer;
	}
	
	public Star(Boolean active, int questionType, String question, Vector<String> answerChoices, int answer) {
		this.active = active;
		this.questionType = questionType;
		this.answerChoices = answerChoices;
		this.answer = answer;
	}
	
	public Star(Boolean active, int questionType, String question, int answer) {
		this.active = active;
		this.questionType = questionType;
		this.answer = answer;
	}
	
	// Getters and Setters for member variables //
	public Vector<Measure> getSheetMusic() {
		return sheetMusic;
	}
	public void setSheetMusic(Vector<Measure> sheetMusic) {
		this.sheetMusic = sheetMusic;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public int getTextQuestion() {
		return questionType;
	}
	public void setTextQuestion(int type) {
		this.questionType = type;
	}
	public Vector<Note> getMusicAnswer() {
		return musicAnswer;
	}
	public void setMusicAnswer(Vector<Note> musicAnswer) {
		this.musicAnswer = musicAnswer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Vector<String> getAnswerChoices() {
		return answerChoices;
	}
	public void setAnswerChoices(Vector<String> answerChoices) {
		this.answerChoices = answerChoices;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
}
