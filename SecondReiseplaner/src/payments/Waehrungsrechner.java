package payments;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Waehrungsrechner extends JPanel {

	private static final long serialVersionUID = -2494227832097428854L;

	private JTextField entryEuro;
	private JLabel dollarEntry;
	
	public Waehrungsrechner() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel calcStuff = new JPanel(new GridLayout(2,2));
		
		JLabel euro = new JLabel("Euro: ");
		euro.setHorizontalAlignment(JLabel.RIGHT);
		JLabel dollar = new JLabel("Dollar: ");
		dollar.setHorizontalAlignment(JLabel.RIGHT);
		
		entryEuro = new JTextField("1.00");
		dollarEntry = new JLabel("1.14");
		
		calcStuff.add(euro);
		calcStuff.add(entryEuro);
		calcStuff.add(dollar);
		calcStuff.add(dollarEntry);
		this.add(calcStuff);
		
		JButton umrechnen = new JButton("Umrechnung");
		
		umrechnen.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				double euroInput;
				try {
					euroInput = Double.parseDouble(entryEuro.getText().replace(',', '.').trim());
					String bla = String.valueOf(euroInput * 1.14);
					dollarEntry.setText(bla);
				}
				catch(Exception e) {
					dollarEntry.setText("Ungueltige Angabe");
				}
		    }
		});
		umrechnen.setHorizontalAlignment(JButton.CENTER);
		this.add(umrechnen);
	}

}
