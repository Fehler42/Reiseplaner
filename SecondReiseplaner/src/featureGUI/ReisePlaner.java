package featureGUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import featureList.CheckList;


public class ReisePlaner extends JFrame {

	private static final long serialVersionUID = 1L;

	// GUI design stuff
	public JPanel masterPanel;
	public JPanel mainPage;
	public PayPanel payPage;
	public CardLayout cardLayout;
	public boolean isRoute = false;

	// CardLayout page names
	public static final String PAGE_MAIN = "MAIN";
	public static final String PAGE_PAY = "PAY";

	public ReisePlaner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// startpositions x, y && window width, height
		setBounds(100, 100, 800, 600);
		masterPanel = new JPanel();
		cardLayout = new CardLayout();
		masterPanel.setLayout(cardLayout);

		// debug stuff
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		masterPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

		// finish masterPanel here
		setContentPane(masterPanel);

		designMainPage();
		setVisible(!CheckList.showWarning);
	}

	/**
	 * Idea: Each base feature creates their own card page and the refining features
	 * add to those cards
	 */
	public void designMainPage() {
		mainPage = new MainPanel(this);
		payPage = new PayPanel(this);

		masterPanel.add(mainPage, PAGE_MAIN);
		masterPanel.add(payPage, PAGE_PAY);

		cardLayout.show(masterPanel, PAGE_MAIN);

	}

	public void changeWindow(final String PAGE) {
		cardLayout.show(masterPanel, PAGE);
	}

	public void addPanel(JPanel subPanel, String key) {
		masterPanel.add(subPanel, key);
	}

	public void updateText(Integer price) {
		payPage.updateDescription("Das kostet " + price);
	}

//	public void updatePrice() {
//		JPanel upperArea = (JPanel) payPage.getComponent(0);
//		JLabel text = (JLabel) upperArea.getComponent(0);
//		text.setText("Das kostet " + priceToPay);	
//		text.setHorizontalTextPosition(JLabel.CENTER);
//	}

}
