package unterkunft;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Ferienhaus extends JPanel {

	public static final String PAGE_FERIENHAUS = "FERIENHAUS";
	private static final long serialVersionUID = -3074338466012820576L;

	public Ferienhaus(ReisePlaner win) {

		this.setLayout(new BorderLayout());

		ArrayList<String> ferienhausNames = new ArrayList<>(Arrays.asList("Billiges Ferienhaus",
				"Nicht so billiges Ferienhaus", "teures Ferienhaus", "Super-Mega-Hammer-Ultra-Deluxe Ferienhaus"));
		ArrayList<Integer> ferienhausPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 500));

		ItemList list = new ItemList(win, ferienhausNames, ferienhausPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
