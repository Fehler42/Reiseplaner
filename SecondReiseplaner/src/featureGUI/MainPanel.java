package featureGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import aktivitaet.Aktivitaetspanel;
import start.Main;
import unterkunft.UnterkunftPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -1672666201944716784L;

	private ReisePlaner window;

	public MainPanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());

		JPanel suchleiste = new Suchleiste();
		this.add(suchleiste, BorderLayout.NORTH);

		// centerPanel contains buttons to book stuff
		JPanel centerPanel = new JPanel(new FlowLayout()); // dynamic layout

		if (Main.features.get(0).toString().equals("1")) {
			JButton btnBookResort = new JButton("Eine Unterkunft buchen");
			btnBookResort.setPreferredSize(new Dimension(200, 300));

			centerPanel.add(btnBookResort);
			this.add(centerPanel, BorderLayout.CENTER);
			window.addPanel(new UnterkunftPanel(window), UnterkunftPanel.PAGE_UNTERKUNFT);

			// Button click switches Panel
			btnBookResort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					window.changeWindow(UnterkunftPanel.PAGE_UNTERKUNFT);
				}
			});
		}

		//XML Reise
		if(true) {
			
		}
		
		//XML Aktivitaet
		if(Main.features.get(16).toString().equals("1")) {
			JButton btnBookActivity = new JButton("Eine Aktivitaet buchen");
			btnBookActivity.setPreferredSize(new Dimension(200, 300));
			
			centerPanel.add(btnBookActivity);
			this.add(centerPanel, BorderLayout.CENTER);
			window.addPanel(new Aktivitaetspanel(window), Aktivitaetspanel.PAGE_AKTIVITAET);
			
			//Button click switches Panel
			btnBookActivity.addActionListener(new ActionListener() {
			    public void actionPerformed (ActionEvent event) {
			    	window.changeWindow(Aktivitaetspanel.PAGE_AKTIVITAET);
			    }
			} );
		}
		
	}
}
