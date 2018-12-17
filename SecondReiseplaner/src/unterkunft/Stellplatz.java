package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Stellplatz extends JPanel {

	public static final String PAGE_STELLPLATZ = "STELLPLATZ";
	private static final long serialVersionUID = -3074338466012820576L;

	public Stellplatz(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> stellplatzNames = new ArrayList<>(
				Arrays.asList("Billiger Stellplatz", "Nicht so billiger Stellplatz", "teurer Stellplatz",
						"Super-Mega-Hammer-Ultra-Deluxe Stellplatz"));
		ArrayList<Integer> stellplatzPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, stellplatzNames, stellplatzPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
