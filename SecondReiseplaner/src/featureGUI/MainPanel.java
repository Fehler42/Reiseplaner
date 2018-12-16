package featureGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import start.Main;
import unterkunft.UnterkunftPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -1672666201944716784L;

	private ReisePlaner window;
	public MainPanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());

		// TODO: Suchleiste schreiben
		JPanel suchleiste = new JPanel();
		suchleiste.setLayout(new BoxLayout(suchleiste, BoxLayout.X_AXIS)); // so far this gives the least headache
		this.add(suchleiste, BorderLayout.NORTH);

		// centerPanel contains buttons to book stuff
		JPanel centerPanel = new JPanel(new FlowLayout()); // dynamic layout
		
		if(Main.features.get(0).toString().equals("1")) {
			JButton btnBookResort = new JButton("Eine Unterkunft buchen");
			btnBookResort.setPreferredSize(new Dimension(200, 300));
			
			centerPanel.add(btnBookResort);
			
			window.addPanel(new UnterkunftPanel(window), UnterkunftPanel.PAGE_UNTERKUNFT);
			
			//Button click switches Panel
			btnBookResort.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent event) {
			    	window.changeWindow(UnterkunftPanel.PAGE_UNTERKUNFT);
			    }
			} );
		}
		this.add(centerPanel, BorderLayout.CENTER);

	}
}
