package reise;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Kreuzfahrt extends JPanel {

	public static final String PAGE_KREUZFAHRT = "KREUZFAHRT";
	private static final long serialVersionUID = -3074338466012820576L;

	public Kreuzfahrt(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> kreuzfahrtNames = new ArrayList<>(Arrays.asList("Billige Kreuzfahrt",
				"Nicht so billige Kreuzfahrt", "teure Kreuzfahrt", "Super-Mega-Hammer-Ultra-Deluxe Kreuzfahrt"));
		ArrayList<Integer> kreuzfahrtPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, kreuzfahrtNames, kreuzfahrtPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
