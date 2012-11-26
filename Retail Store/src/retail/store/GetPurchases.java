package retail.store;

import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.database.SQLException;

import com.database.sqlite.*;

public class GetPurchases {
	
	private Context context;
	private	String difficulty;
	private ItemDataSource items_data_source;
	
	public GetPurchases(Context context, String difficulty) {
		this.difficulty = difficulty;
		this.context = context;
	}
	
	public ArrayList<Item> getPurchases() {
		ArrayList<Item> items = new ArrayList<Item>();
		items_data_source = new ItemDataSource(context);
		try {
			items_data_source.open();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (difficulty.equalsIgnoreCase("easy")) {
			items = items_data_source.getItems(3);
			
		} else if (difficulty.equalsIgnoreCase("medium")) {
			items = items_data_source.getItems(6);
			
		} else if (difficulty.equalsIgnoreCase("hard")) {
			items = items_data_source.getItems(9);

		}
		
		items_data_source.close();
		
		return items;
	}

}

