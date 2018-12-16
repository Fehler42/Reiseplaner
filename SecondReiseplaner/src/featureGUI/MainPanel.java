package featureGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -1672666201944716784L;

	public MainPanel() {

		this.setLayout(new BorderLayout());

		// TODO: Suchleiste schreiben Upperwindow contains SuchLeiste
		JPanel upperWindow = new JPanel();
		upperWindow.setLayout(new BoxLayout(upperWindow, BoxLayout.X_AXIS)); // so far this gives the least headache
		this.add(upperWindow, BorderLayout.NORTH);

		// centerPanel contains buttons to book stuff
		JPanel centerPanel = new JPanel(new FlowLayout()); // dynamic layout
		this.add(centerPanel, BorderLayout.CENTER);

	}
}
