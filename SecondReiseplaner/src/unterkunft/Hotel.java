package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Hotel extends JPanel {

	public static final String PAGE_HOTELS = "HOTELS";
	private static final long serialVersionUID = -3074338466012820576L;
	
	public Hotel(ReisePlaner win) {
		
		this.setLayout(new BorderLayout());
	
		ArrayList<String> hotelNames = 
				new ArrayList<>(Arrays.asList(
						"Billiges Hotel",
						"Nicht so billiges Hotel",
						"teures Hotel",
						"Super-Mega-Hammer-Ultra-Deluxe Hotel"));
		ArrayList<Integer> hotelPrices =
				new ArrayList<>(Arrays.asList(30, 50, 100, 500));
		
		ItemList list = new ItemList(win, hotelNames, hotelPrices);
		
		this.add(list, BorderLayout.NORTH);
	}
}
