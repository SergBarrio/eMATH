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
	    // to center all the items we just have to divide the number of items by 100 (3/100 = 33.33)
	    // then set the images to all have that weight
	}
}
