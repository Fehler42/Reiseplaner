package featureGUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import payments.PayPal;

public class PayPanel extends JPanel {

	private static final long serialVersionUID = -3256227552006190720L;

	public PayPanel() {

		this.setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//TODO: XML for PayPal feature
		if(true) {
			this.add(new PayPal());
		}

		/*
		 * IF XML DEFINES THIS AS FEATURE
		 */

		// TODO: create Waehrungsrechner here
		if (true) {
			JPanel waehrungsrechner = new JPanel();
			waehrungsrechner.setLayout(new BoxLayout(waehrungsrechner, BoxLayout.Y_AXIS));

			this.add(waehrungsrechner);
		}
	}
}
