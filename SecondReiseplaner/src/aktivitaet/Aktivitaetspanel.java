package aktivitaet;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import featureGUI.ItemList;
import featureGUI.ReisePlaner;

public class Aktivitaetspanel extends JPanel {

	private static final long serialVersionUID = 1959729971599377097L;
	public static final String PAGE_AKTIVITAET = "AKTIVITAET";

	@SuppressWarnings({ "unused" })
	private ReisePlaner window;

	public Aktivitaetspanel(ReisePlaner win) {
		window = win;

		this.setLayout(new BorderLayout());

		ArrayList<String> aktivitaetsNames = new ArrayList<>(Arrays.asList("Billige Aktivitaet",
				"Nicht so billige Aktivitaet", "Teure Aktivitaet", "Jochen-Schweizer Aktivitaet"));
		ArrayList<Integer> aktivitaetsPrices = new ArrayList<>(Arrays.asList(30, 50, 100, 5000));

		ItemList list = new ItemList(win, aktivitaetsNames, aktivitaetsPrices);

		this.add(list, BorderLayout.NORTH);
	}
}
