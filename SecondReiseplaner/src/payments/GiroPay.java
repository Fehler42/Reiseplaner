package payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.ReisePlaner;
import start.Main;

public class GiroPay extends JPanel {

	private static final long serialVersionUID = -3838927946898700250L;

	private ReisePlaner window;

	public GiroPay(ReisePlaner win) {
		window = win;

		JButton btnGiroPay = new JButton("Bezahlen mit GiroPay");

		// Button click switches Panel
		btnGiroPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				window.changeWindow(ReisePlaner.PAGE_MAIN);
			}
		});
	}
}
