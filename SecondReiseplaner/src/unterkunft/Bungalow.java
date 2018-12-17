package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Bungalow extends JPanel {

	public static final String PAGE_BUNGALOW = "BUNGALOW";
	private static final long serialVersionUID = -3074338466012820576L;

	public Bungalow(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> bungalowNames = new ArrayList<>(
				Arrays.asList("Billiger Bungalow", "Nicht so billiger Bungalow", "teurer Bungalow",
						"Super-Mega-Hammer-Ultra-Deluxe Bungalow"));
		ArrayList<Integer> bungalowPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, bungalowNames, bungalowPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
