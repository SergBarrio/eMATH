package retail.store;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProblemScreen extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.problem_screen);
	    
	    TextView item = (TextView)findViewById(R.id.item_name_cost);
	    
	    String item_ident = "Item Name - Item Cost";
	    
	    item.setText(item_ident);
	    
	    // right now there are 3 placeholder images in the layout
	    // I made it so that the linearlayout has a weightSum of 100
	    // to place items make sure the vertical linearLayout (rows not columns)
	    // have equal weight. So to find the weight for 6 items, 100/6 = 16.66 on each layout
	    
	}
}
