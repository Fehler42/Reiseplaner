package reise;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Auto_mieten extends JPanel {

	public static final String PAGE_AUTO = "AUTO";
	private static final long serialVersionUID = -3074338466012820576L;

	public Auto_mieten(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> carNames = new ArrayList<>(Arrays.asList("Billiges Auto", "Nicht so billiges Auto",
				"Teures Auto", "Super-Mega-Hammer-Ultra-Deluxe Auto"));
		ArrayList<Integer> carPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		@SuppressWarnings("unused")
		CarPanel carp = new CarPanel(win);

		final String panelKey = CarPanel.PAGE_CAR;

		ItemList list = new ItemList(win, carNames, carPrices, panelKey);

		this.add(list, BorderLayout.NORTH);
	}
}
