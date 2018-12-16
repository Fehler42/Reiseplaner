package payments;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PayPal extends JPanel {

	public PayPal() {
		JPanel upperPage = new JPanel(new BorderLayout());
		JPanel lowerPage = new JPanel(new BorderLayout());
		
		//TODO: may need to change this to correct class
		this.add(upperPage);
		this.add(lowerPage);

		JLabel description = new JLabel("Das kostet ");

		description.setAlignmentX(CENTER_ALIGNMENT);
		description.setAlignmentY(CENTER_ALIGNMENT);
		upperPage.add(description, BorderLayout.SOUTH);
		
		JButton btnPayPal = new JButton("Bezahlen mit Paypal");
		
		//Button click switches Panel
		btnPayPal.addActionListener(new ActionListener() {
		    public void actionPerformed (ActionEvent event) {
		    	cardLayout.show(masterPanel, PAGE_MAIN);
		    }
		} );
		
	}
}
