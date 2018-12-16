package start;

import java.util.ArrayList;
import java.util.List;

import featureGUI.ReisePlaner;
import featureList.CheckList;

public class Main {

	public static ReisePlaner window;
	public static List<String> features;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				window = new ReisePlaner();
				features = new ArrayList<String>();
				CheckList.fillList();
			}
		});
	}
}
