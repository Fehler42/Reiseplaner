package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;
import start.Main;

public class Campingplatz extends JPanel {

	public static final String PAGE_CAMPINGPLATZ = "CAMPINGPLATZ_OPTION";
	private static final long serialVersionUID = -3074338466012820576L;

	public Campingplatz(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> campingplatzNames = new ArrayList<>(
				Arrays.asList("Billiger Campingplatz", "Nicht so billiger Campingplatz", "teurer Campingplatz",
						"Super-Mega-Hammer-Ultra-Deluxe Campingplatz"));
		ArrayList<Integer> campingPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		CampingPanel camps = new CampingPanel(win);
		
		final String panelKey = CampingPanel.PAGE_CAMPINGSTYLE;
		
		win.addPanel(camps, panelKey);
		ItemList list = new ItemList(win, campingplatzNames, campingPrices, panelKey);

		this.add(list, BorderLayout.NORTH);
	}
}
