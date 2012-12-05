package retail.store;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProblemScreen extends Activity {

	Button submitbutton;
	ImageView customer1, customer2, customer3, customer4, customer5;
	private ArrayList<Item> items;
	private TextView item_tv;
	private int remaining_items = 0;
	private static int[] item_text_ids = {
		R.id.item1,
		R.id.item2,
		R.id.item3,
		R.id.item4,
		R.id.item5,
		R.id.item6 };
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.problem_screen);    
	    items = (ArrayList<Item>)getIntent().getExtras().getSerializable("purchases");
	    TextView item = (TextView)findViewById(R.id.item_name_cost);    
	    String item_ident = "Customer #...";    
	    item.setText(item_ident);
	    
	    for(int i=0; i<items.size(); i++){
	    	item_tv = (TextView)findViewById(item_text_ids[i]);
	    	item_tv.setText(items.get(i).getName(), null);
	    }
	    
	    //set items
	    /*
	    TextView item1 = (TextView)findViewById(R.id.item1);
	    TextView item2 = (TextView)findViewById(R.id.item2);
	    TextView item3 = (TextView)findViewById(R.id.item3);
	    TextView item4 = (TextView)findViewById(R.id.item4);
	    TextView item5 = (TextView)findViewById(R.id.item5);
	    TextView item6 = (TextView)findViewById(R.id.item6);
	    
	    item1.setText("Bannana", null);
	    item2.setText("Laptop", null);
	    item3.setText("Wallet", null);
	    item4.setText("Soda", null);
	    item5.setText("Gloves", null);
	    item6.setText("Apple", null);
	    */
	    
	    //set top drawable for items
	    //item4.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.water_small, 0, 0);
	    //item5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.shirt, 0, 0);
	    
	    //set customer queue
	    customer1 = (ImageView)findViewById(R.id.cust_image1);
	    customer2 = (ImageView)findViewById(R.id.cust_image2);
	    customer3 = (ImageView)findViewById(R.id.cust_image3);
	    customer4 = (ImageView)findViewById(R.id.cust_image4);
	    customer5 = (ImageView)findViewById(R.id.cust_image5);
	    
	    // right now there are 3 placeholder images in the layout
	    // I made it so that the linearlayout has a weightSum of 100
	    // to place items make sure the vertical linearLayout (rows not columns)
	    // have equal weight. So to find the weight for 6 items, 100/6 = 16.66 on each layout
	    
	    submitbutton = (Button)findViewById(R.id.submitbutton);
	    submitbutton.setOnClickListener(testQueue);
	    
	}
	
	 private OnClickListener testQueue = new OnClickListener(){
		public void onClick(View arg0) {
			if (customer1.getVisibility() == View.VISIBLE ){
				 customer1.setVisibility(View.GONE);
				 return;
			 }
			 if (customer2.getVisibility() == View.VISIBLE ){
				 customer2.setVisibility(View.GONE);
				 return;
			 }
		}
	 };
}
