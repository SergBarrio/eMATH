/*
 * Luis Perozo
 * September 2012
 * This class defines a parser for the Measure Madness
 * configuration file.
 */
package com.measure.madness;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.measure.madness.Measure.Note;
import com.measure.madness.Measure.Tsig;

import android.util.Xml;

public class ConfigurationParser {
	
	private static final String ns = null;
	
	// Parse the configuration file //
	public ArrayList<ArrayList<Star>> parse(InputStream config) throws XmlPullParserException, IOException {
		try {
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(config, null);
            parser.nextTag();
            return readConfig(parser);
		} finally {
			config.close();
		}
	}
	
	private ArrayList<ArrayList<Star>> readConfig(XmlPullParser parser) throws XmlPullParserException, IOException {
	    ArrayList<ArrayList<Star>> puzzles = new ArrayList<ArrayList<Star>>();

	    parser.require(XmlPullParser.START_TAG, ns, "config");
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        // Begin with the puzzle tag
	        if (name.equals("puzzle")) {
	            puzzles.add(readPuzzle(parser));
	        } else {
	            skip(parser);
	        }
	    }  
	    return puzzles;
	}
	
	// Process the puzzle tag //
	private ArrayList<Star> readPuzzle(XmlPullParser parser) throws XmlPullParserException, IOException {
		ArrayList<Star> stars = new ArrayList<Star>();
		
		parser.require(XmlPullParser.START_TAG, ns, "puzzle");
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        // Starts by looking for the question tag
	        if (name.equals("question")) {
	            stars.add(readQuestion(parser));
	        } else {
	            skip(parser);
	        }
	    }  
	    return stars;
	}
	
	// Process the method tag. Each tag within the question has its corresponding read method
	private Star readQuestion(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "question");
	    
	    Boolean active = false;
	    int questionType = -1;
	    Vector<Measure> music = new Vector<Measure>();
	    String question = "";
	    Vector<Note> musicAnswer = new Vector<Note>();
	    Vector<String> choices = new Vector<String>();
	    int answer = -1;
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("type")) {
	        	questionType = readType(parser);
	        } else if (name.equals("measure")) {
	            music.add(readMeasure(parser));
	        } else if (name.equals("text")) {
	        	question = readTextQuestion(parser);
	        } else if (name.equals("answer")) {
	        	if (questionType == 0) {
	        		musicAnswer = readMusicAnswer(parser);
	        	} else if (questionType == 1 || questionType == 2) {
	        		answer = readAnswer(parser);
	        	}
	        } else if (name.equals("choices")) {
	        	choices = readChoices(parser);
	        }	else {
	            skip(parser);
	        }
	    }
	    
	    // Return Star object based on type of question //
	    if (questionType == 0) {
	    	return new Star(active,questionType,music,musicAnswer);
	    } else if (questionType ==1) {
	    	return new Star(active,questionType,question,choices,answer);
	    } else if (questionType ==2) {
	    	return new Star(active,questionType,question,answer);
	    }
	    
	    return new Star();
	}
	
	// Process the type tag //
	private int readType(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "type");
	    int type = readInt(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "type");
	    return type;
	}
	
	// Process the measure tag //
	private Measure readMeasure(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "measure");
	    
	    Measure measure = new Measure();
	    Tsig timeSignature = measure.new Tsig();
	    Vector<Note> notes = new Vector<Note>();
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("tsig")) {
	        	timeSignature = readTsig(parser);
	        } else if (name.equals("note")) {
	        	notes.add(readNote(parser));
	        }	else {
	            skip(parser);
	        }
	    }
	    return new Measure(timeSignature, notes);
	}
	
	// Process the answer tag to music questions //
	private Vector<Note> readMusicAnswer(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "answer");
	    
	    Vector<Note> notes = new Vector<Note>();
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("note")) {
	        	notes.add(readNote(parser));
	        }
	    }
	    return notes;
	}
	
	// Process the text tag //
	private String readTextQuestion(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "text");
	    String question = readText(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "text");
	    return question;
	}
	
	// Process the choices tag //
	private Vector<String> readChoices(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "choices");

	    Vector<String> choices = new Vector<String>();
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("choice")) {
	        	choices.add(readChoice(parser));
	        }
	    }
	    
	    return choices;
	}
	
	// Process the answer tag for non-music questions //
	private int readAnswer(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "answer");
	    int answer = readInt(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "answer");
	    return answer;
	}
	
	// Process the tsig tag //
	private Tsig readTsig(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "tsig");
	    
	    int numerator = -1;
	    int denominator = -1;
	    Measure measure = new Measure();
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("numerator")) {
	        	numerator = readNumerator(parser);
	        } else if (name.equals("denominator")) {
	        	denominator = readDenominator(parser);
	        }	else {
	            skip(parser);
	        }
	    }
	    return measure.new Tsig(numerator,denominator);
	}
	
	// Process the time signature numerator //
	private int readNumerator(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "numerator");
	    int numerator = readInt(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "numerator");
	    return numerator;
	}
	
	// Process the time signature denominator //
	private int readDenominator(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "denominator");
	    int denominator = readInt(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "denominator");
	    return denominator;
	}
	
	// Process the note tag //
	private Note readNote(XmlPullParser parser) throws XmlPullParserException, IOException {
	    parser.require(XmlPullParser.START_TAG, ns, "note");
	    
	    int staffPosition = -1;
	    double duration = -1.0;
	    Measure measure = new Measure();
	    
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        if (name.equals("staffposition")) {
	        	staffPosition = readStaffPosition(parser);
	        } else if (name.equals("duration")) {
	        	duration = readDuration(parser);
	        }	else {
	            skip(parser);
	        }
	    }
	    return measure.new Note(staffPosition,duration);
	}
	
	// Process the note position //
	private int readStaffPosition(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "staffposition");
	    int position = readInt(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "staffposition");
	    return position;
	}
	
	// Process the note duration //
	private double readDuration(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "duration");
	    double duration = readDouble(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "duration");
	    return duration;
	}
	
	// Process an answer choice //
	private String readChoice(XmlPullParser parser) throws IOException, XmlPullParserException {
	    parser.require(XmlPullParser.START_TAG, ns, "choice");
	    String choice = readText(parser);
	    parser.require(XmlPullParser.END_TAG, ns, "choice");
	    return choice;
	}
	
	// Skip irrelevant tags //
	private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
	    if (parser.getEventType() != XmlPullParser.START_TAG) {
	        throw new IllegalStateException();
	    }
	    int depth = 1;
	    while (depth != 0) {
	        switch (parser.next()) {
	        case XmlPullParser.END_TAG:
	            depth--;
	            break;
	        case XmlPullParser.START_TAG:
	            depth++;
	            break;
	        }
	    }
	 }
	
	// Extract text values //
	private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
	    String result = "";
	    if (parser.next() == XmlPullParser.TEXT) {
	        result = parser.getText();
	        parser.nextTag();
	    }
	    return result;
	}
	
	// Extract number values //
	private int readInt(XmlPullParser parser) throws IOException, XmlPullParserException {
	    int result = -1;
	    if (parser.next() == XmlPullParser.TEXT) {
	        result = Integer.parseInt(parser.getText());
	        parser.nextTag();
	    }
	    return result;
	}
	
	private double readDouble(XmlPullParser parser) throws IOException, XmlPullParserException {
	    double result = -1.0;
	    if (parser.next() == XmlPullParser.TEXT) {
	        result = Double.parseDouble(parser.getText());
	        parser.nextTag();
	    }
	    return result;
	}
}
