package reise;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Flug extends JPanel {

	public static final String PAGE_FLUG = "FLUG";
	private static final long serialVersionUID = -3074338466012820576L;

	public Flug(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> flugNames = new ArrayList<>(Arrays.asList("Billiger Flug", "Nicht so billiger Flug",
				"teures Flug", "Super-Mega-Hammer-Ultra-Deluxe Flug"));
		ArrayList<Integer> flugPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, flugNames, flugPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
