package featureGUI;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import payments.GiroPay;
import payments.Kreditkarte;
import payments.PayPal;

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
		
		//TODO: XML for PayPal feature
		if(true) {
			lowerPage.add(new PayPal(win));
		}
		
		//TODO: XML GiroPay
		else if(true) {
			lowerPage.add(new GiroPay(win));
		}
		
		//TODO: XML Kreditkarte
		else if(true) {
			lowerPage.add(new Kreditkarte(win));
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
