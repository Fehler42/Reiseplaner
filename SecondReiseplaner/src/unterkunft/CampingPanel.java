package unterkunft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.ReisePlaner;
import start.Main;

public class CampingPanel extends JPanel {

	private static final long serialVersionUID = 7467826917297513583L;

	public static final String PAGE_CAMPINGSTYLE = "CAMPINGPLATZ_OBERSEITE";
	private ReisePlaner window;

	public CampingPanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());

		window.addPanel(this, PAGE_CAMPINGSTYLE);

		// Start new Panel page here
		JPanel resorts = new JPanel(new FlowLayout());
		this.add(resorts, BorderLayout.CENTER);

		// XML Bungalow
		if (Main.features.get(5).toString().equals("1")) {
			JButton bungalowBtn = new JButton("Bungalow buchen");
			bungalowBtn.setPreferredSize(new Dimension(200, 300));

			resorts.add(bungalowBtn);
			window.addPanel(new Bungalow(window), Bungalow.PAGE_BUNGALOW);

			bungalowBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Bungalow.PAGE_BUNGALOW);

				}
			});
		}
		
		//XML Stellplatz
		if (Main.features.get(6).toString().equals("1")) {
			JButton stellplatzBtn = new JButton("Stellplatz buchen");
			stellplatzBtn.setPreferredSize(new Dimension(200, 300));

			resorts.add(stellplatzBtn);
			window.addPanel(new Stellplatz(window), Stellplatz.PAGE_STELLPLATZ);

			stellplatzBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Stellplatz.PAGE_STELLPLATZ);

				}
			});
		}
		
		
	}
}
