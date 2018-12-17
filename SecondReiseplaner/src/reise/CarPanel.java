package reise;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import featureGUI.PayPanel;
import featureGUI.ReisePlaner;
import start.Main;

public class CarPanel extends JPanel {
	private static final long serialVersionUID = 7467826917297513583L;

	public static final String PAGE_CAR = "CAR_OBERSEITE";
	private ReisePlaner window;

	public CarPanel(ReisePlaner win) {
		window = win;
		this.setLayout(new BorderLayout());

		window.addPanel(this, PAGE_CAR);

		// Start new Panel page here
		JPanel resorts = new JPanel(new FlowLayout());
		this.add(resorts, BorderLayout.CENTER);
		
		if (Main.features.get(9).toString().equals("1")) {
			JButton routeBtn = new JButton("Route planen");
			routeBtn.setPreferredSize(new Dimension(200, 300));

			resorts.add(routeBtn);
			window.addPanel(new Route_planen(window),Route_planen.PAGE_ROUTE);

			routeBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.changeWindow(Route_planen.PAGE_ROUTE);

				}
			});
		}
		JButton noRouteBtn = new JButton("ohne Route fortfahren");
		noRouteBtn.setPreferredSize(new Dimension(200, 300));

		resorts.add(noRouteBtn);
		window.addPanel(new Route_planen(window),Route_planen.PAGE_ROUTE);

		noRouteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.changeWindow(PayPanel.PAGE_PAYPANEL);
			}
		});
	}
}
