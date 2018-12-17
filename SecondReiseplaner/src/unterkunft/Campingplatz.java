package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;
import start.Main;

public class Campingplatz extends JPanel {

	public static final String PAGE_CAMPINGPLATZ = "CAMPINGPLATZ";
	private static final long serialVersionUID = -3074338466012820576L;

	public Campingplatz(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> campingplatzNames = new ArrayList<>(
				Arrays.asList("Billiger Campingplatz", "Nicht so billiger Campingplatz", "teurer Campingplatz",
						"Super-Mega-Hammer-Ultra-Deluxe Campingplatz"));
		ArrayList<Integer> campingPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		//XML BUUNGALOW
		if (Main.features.get(4).toString().equals("1")) {

		}

		//XML STELLPLATZ
		if (Main.features.get(5).toString().equals("1")) {

		}

		ItemList list = new ItemList(win, campingplatzNames, campingPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
