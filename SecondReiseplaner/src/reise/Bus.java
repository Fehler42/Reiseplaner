package reise;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Bus extends JPanel {

	public static final String PAGE_BUS = "BUS";
	private static final long serialVersionUID = -3074338466012820576L;

	public Bus(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> busNames = new ArrayList<>(Arrays.asList("Billiger Bus", "Nicht so billiger Bus",
				"Teurer Bus", "Super-Mega-Hammer-Ultra-Deluxe Bus"));
		ArrayList<Integer> busPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, busNames, busPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
