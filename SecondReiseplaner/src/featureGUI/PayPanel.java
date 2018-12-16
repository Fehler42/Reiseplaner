package featureGUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import payments.GiroPay;
import payments.Kreditkarte;
import payments.PayPal;
import payments.Waehrungsrechner;
import start.Main;

public class PayPanel extends JPanel {

	private static final long serialVersionUID = -3256227552006190720L;

	private JLabel description;

	public PayPanel(ReisePlaner win) {

		this.setLayout((LayoutManager) new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel upperPage = new JPanel(new BorderLayout());
		JPanel lowerPage = new JPanel(new BorderLayout());

		this.add(upperPage);
		this.add(lowerPage);

		description = new JLabel("Das kostet ");

		description.setAlignmentX(CENTER_ALIGNMENT);
		description.setAlignmentY(CENTER_ALIGNMENT);

		upperPage.add(description, BorderLayout.SOUTH);

		if (Main.features.get(13).toString().equals("1")) {
			lowerPage.add(new PayPal(win));
		}

		else if (Main.features.get(14).toString().equals("1")) {
			lowerPage.add(new GiroPay(win));
		}

		else if (Main.features.get(12).toString().equals("1")) {
			lowerPage.add(new Kreditkarte(win));
		}

		/*
		 * IF XML DEFINES THIS AS FEATURE
		 */

		if (Main.features.get(15).toString().equals("1")) {
			JPanel waehrungsrechner = new Waehrungsrechner();
			this.add(waehrungsrechner);
		}
	}

	public void updateDescription(String descr) {
		description.setText(descr);
	}
}
