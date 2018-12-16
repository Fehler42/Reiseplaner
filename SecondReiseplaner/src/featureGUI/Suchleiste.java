package featureGUI;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Suchleiste extends JPanel {

	private static final long serialVersionUID = 4436319105302505714L;

	public Suchleiste() {
		// textfield description and action button
		JButton btnSearch = new JButton("Suche"); // TODO: display ((((Search Results, when button is clicked))))

		// crete a sort of box for textfield + button to be able to search stuff
		JTextField suchfeld = new JTextField("");

		// Hokus Pokus, just hope that our panel here got added first ...
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		// filler content
		Dimension minSize = new Dimension(50, 30);
		Dimension prefSize = new Dimension(400, 30);
		Dimension maxSize = new Dimension(600, 30);

		// add everything to the grid layout
		this.add(new Box.Filler(minSize, prefSize, maxSize));
		this.add(btnSearch);
		this.add(suchfeld);
	}
}
