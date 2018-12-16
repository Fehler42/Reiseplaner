package reise;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.ReisePlaner;
import start.Main;

public class ReisePanel extends JPanel {

	public static final String PAGE_REISE = "REISE";
	private static final long serialVersionUID = 414204438797662715L;

	private ReisePlaner window;

	public ReisePanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());

		// Start new Panel page here
		JPanel travel = new JPanel(new FlowLayout());
		this.add(travel, BorderLayout.CENTER);

		window.addPanel(this, PAGE_REISE);

		// XML Bus
		if (Main.features.get(7).toString().equals("1")) {
			JButton busBtn = new JButton("Bus buchen");
			busBtn.setPreferredSize(new Dimension(200, 300));

			travel.add(busBtn);
			window.addPanel(new Bus(window), Bus.PAGE_BUS);

			busBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Bus.PAGE_BUS);

				}

			});
		}
		// XML AUTO_MIETEN
		if (Main.features.get(8).toString().equals("1")) {
			JButton carBtn = new JButton("Auto mieten");
			carBtn.setPreferredSize(new Dimension(200, 300));

			travel.add(carBtn);
			window.addPanel(new Kreuzfahrt(window), Auto_mieten.PAGE_AUTO);

			carBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Auto_mieten.PAGE_AUTO);

				}

			});
		}

		// XML FLUG
		if (Main.features.get(10).toString().equals("1")) {
			JButton flugBtn = new JButton("Flug buchen");
			flugBtn.setPreferredSize(new Dimension(200, 300));

			travel.add(flugBtn);
			window.addPanel(new Flug(window), Flug.PAGE_FLUG);

			flugBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Flug.PAGE_FLUG);

				}

			});
		}
		// XML Kreuzfahrt
		if (Main.features.get(11).toString().equals("1")) {
			JButton kreuzfahrtBtn = new JButton("Kreuzfahrt buchen");
			kreuzfahrtBtn.setPreferredSize(new Dimension(200, 300));

			travel.add(kreuzfahrtBtn);
			window.addPanel(new Kreuzfahrt(window), Kreuzfahrt.PAGE_Kreuzfahrt);

			kreuzfahrtBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Kreuzfahrt.PAGE_Kreuzfahrt);

				}

			});
		}
	}
}
