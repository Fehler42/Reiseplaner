package reise;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Route_planen extends JPanel {

	public static final String PAGE_ROUTE = "ROUTE";
	private static final long serialVersionUID = -3074338466012820576L;

	public Route_planen(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> routeNames = new ArrayList<>(Arrays.asList("Schnellste Route", "Kürzeste Route",
				"Schönste Route", "Keine Autobahn"));
		ArrayList<Integer> routePrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, routeNames, routePrices);

		this.add(list, BorderLayout.NORTH);
	}
}
