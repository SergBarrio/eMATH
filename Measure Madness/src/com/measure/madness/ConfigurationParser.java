package com.measure.madness;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class ConfigurationParser {
	
	private static final String ns = null;
	
	public List parse(InputStream config) throws XmlPullParserException, IOException {
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
	
	private List readConfig(XmlPullParser parser) throws XmlPullParserException, IOException {
	    List entries = new ArrayList();

	    parser.require(XmlPullParser.START_TAG, ns, "puzzles");
	    while (parser.next() != XmlPullParser.END_TAG) {
	        if (parser.getEventType() != XmlPullParser.START_TAG) {
	            continue;
	        }
	        String name = parser.getName();
	        // Starts by looking for the entry tag
	        if (name.equals("puzzle")) {
	            //entries.add(readEntry(parser));
	        } else {
	            //skip(parser);
	        }
	    }  
	    return entries;
	}
}
