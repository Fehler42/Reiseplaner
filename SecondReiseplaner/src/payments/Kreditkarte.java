package payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.ReisePlaner;

public class Kreditkarte extends JPanel {

	private static final long serialVersionUID = 2969876350064524808L;

	private ReisePlaner window;

	public Kreditkarte(ReisePlaner win) {
		window = win;
		JButton btnKreditkarte = new JButton("Bezahlen mit Kreditkarte");
		// Button click switches Panel
		btnKreditkarte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				window.changeWindow(ReisePlaner.PAGE_MAIN);
			}
		});
	}
}
