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

public class UnterkunftPanel extends JPanel {

	public static final String PAGE_UNTERKUNFT = "UNTERKUNFT";
	private static final long serialVersionUID = 414204438797662715L;
	
	private ReisePlaner window;
	public UnterkunftPanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());
		
		//Start new Panel page here
		JPanel resorts = new JPanel(new FlowLayout());
		this.add(resorts, BorderLayout.CENTER);
		
		window.addPanel(this, PAGE_UNTERKUNFT);

		//TODO: XML stuff for Hotel, Ferienhaus and co.
		
	}
}
