package featureGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReisePlaner extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//GUI design stuff
	public JPanel masterPanel;
	public JPanel mainPage;
	public JPanel payPage;
	CardLayout cardLayout;
	public boolean isRoute = false;
	
	//CardLayout page names
	public static final String PAGE_MAIN = "MAIN";
	public static final String PAGE_PAY = "PAY";
	
	public ReisePlaner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//startpositions x, y && window width, height
		setBounds(100, 100, 800, 600);
		masterPanel = new JPanel();
		cardLayout = new CardLayout();
		masterPanel.setLayout(cardLayout);
		
		//debug stuff
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		masterPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		//finish masterPanel here
		setContentPane(masterPanel);
		
		designMainPage();
	}
	
	/**
	 * Idea: Each base feature creates their own card page and the refining features add to those cards
	 */
	public void designMainPage() {
		mainPage = new MainPanel();
		payPage = new PayPanel();
		
		masterPanel.add(mainPage, PAGE_MAIN);
		masterPanel.add(payPage, PAGE_PAY);
		
		cardLayout.show(masterPanel, PAGE_MAIN);
		
	}
	
//	public void updatePrice() {
//		JPanel upperArea = (JPanel) payPage.getComponent(0);
//		JLabel text = (JLabel) upperArea.getComponent(0);
//		text.setText("Das kostet " + priceToPay);	
//		text.setHorizontalTextPosition(JLabel.CENTER);
//	}
	
}
