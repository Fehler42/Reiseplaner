package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Campingplatz extends JPanel {

	public static final String PAGE_CAMPINGPLATZ = "CAMPINGPLATZ";
	private static final long serialVersionUID = -3074338466012820576L;

	public Campingplatz(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> campingplatzNames = new ArrayList<>(
				Arrays.asList("Billiger Campingplatz", "Nicht so billiger Campingplatz", "teures Campingplatz",
						"Super-Mega-Hammer-Ultra-Deluxe Campingplatz"));
		ArrayList<Integer> ferienhausPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, campingplatzNames, ferienhausPrices);

		this.add(list, BorderLayout.NORTH);
	}
}