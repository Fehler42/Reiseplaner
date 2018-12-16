package payments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.ReisePlaner;

public class PayPal extends JPanel {

	private static final long serialVersionUID = -7714411273807002393L;
	private ReisePlaner window;

	public PayPal(ReisePlaner win) {
		window = win;
		JButton btnPayPal = new JButton("Bezahlen mit Paypal");

		this.add(btnPayPal);

		// Button click switches Panel
		btnPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				window.changeWindow(ReisePlaner.PAGE_MAIN);
			}
		});

	}
}
