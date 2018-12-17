package featureList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import start.Main;

public class CheckList {

	public static void fillList() {
		Main.features = XMLParser.parse(Main.features);
		checkList(Main.features);
	}
	
	public static boolean showWarning = false;

	public static List<String> checkList(List<String> features) {
		if ((features.get(1).toString().equals("1") || features.get(2).toString().equals("1")
				|| features.get(3).toString().equals("1")) && features.get(0).toString().equals("0")) {
			showWarning = true;
		} else if (features.get(0).toString().equals("1") && (features.get(1).toString().equals("0")
				&& features.get(2).toString().equals("0") && features.get(3).toString().equals("0"))) {
			showWarning = true;
		} else if ((features.get(4).toString().equals("1") || features.get(5).toString().equals("1"))
				&& features.get(3).toString().equals("0")) {
			showWarning = true;
		} else if ((features.get(3).toString().equals("1"))
				&& (features.get(4).toString().equals("0") && features.get(5).toString().equals("0"))) {
			showWarning = true;
		} else if (features.get(0).toString().equals("0") && features.get(6).toString().equals("0")) {
			showWarning = true;
		} else if ((features.get(7).toString().equals("1") || features.get(8).toString().equals("1")
				|| features.get(10).toString().equals("1") || features.get(11).toString().equals("1"))
				&& features.get(6).toString().equals("0")) {
			showWarning = true;
		} else if ((features.get(7).toString().equals("0") || features.get(8).toString().equals("0")
				|| features.get(10).toString().equals("0") || features.get(11).toString().equals("0"))
				&& features.get(6).toString().equals("1")) {
			showWarning = true;
		} else if (features.get(9).toString().equals("1") && features.get(8).toString().equals("0")) {
			showWarning = true;
		} else if (!(features.get(12).toString().equals("1") && features.get(13).toString().equals("0")
				&& features.get(14).toString().equals("0"))
				&& !(features.get(12).toString().equals("0") && features.get(13).toString().equals("1")
						&& Main.features.get(14).toString().equals("0"))
				&& !(features.get(12).toString().equals("0") && features.get(13).toString().equals("0")
						&& features.get(14).toString().equals("1"))) {
			showWarning = true;
		}
		
		if(showWarning) {
			createWarningWindow();
		}
		return features;
	}
	
	private static void createWarningWindow() {
		JFrame warningDialog = new JFrame("Invalide Konfiguration");
		warningDialog.setSize(300, 100);
		warningDialog.setAlwaysOnTop(true);
		warningDialog.setLocationRelativeTo(null);
		warningDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
		warningDialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel warningMasterPanel = new JPanel(new BorderLayout());
		
		JLabel warningText = new JLabel("Die ausgewaehlte Konfiguration ist ungueltig!");
		JButton closeAll = new JButton("OK");
		
		closeAll.setAlignmentX(Component.CENTER_ALIGNMENT);
		closeAll.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JPanel flavourCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
		flavourCenter.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		
		flavourCenter.add(closeAll);
		closeAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
				
			}
			
		});
		
		warningMasterPanel.add(warningText, BorderLayout.NORTH);
		warningMasterPanel.add(flavourCenter, BorderLayout.CENTER);
		warningDialog.add(warningMasterPanel);
		warningDialog.setVisible(true);
	}
}
