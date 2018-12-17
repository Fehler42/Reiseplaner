package featureGUI;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("rawtypes")
public class ItemList extends JList {

	private static final long serialVersionUID = 7435490687240344649L;

	private HashMap<String, Integer> set;
	private ArrayList<String> itemList;
	private ReisePlaner window;

	private final String destinationWindow;
	
	/**
	 * Creates a list of items that if item is clicked changes the panel to the corresponding destination
	 * @param win the Window
	 * @param items the list of items offered
	 * @param prices the prices attached to the items
	 * @param destination the destination panel
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	public ItemList(ReisePlaner win, ArrayList<String> items, ArrayList<Integer> prices, final String destination) {
		destinationWindow = destination;
		window = win;

		// TODO: Assert that both list are same length ...
		itemList = items;
		set = new HashMap<String, Integer>();
		for (int i = 0; i < items.size(); ++i) {
			set.put(items.get(i), prices.get(i));
		}

		this.setModel(new AbstractListModel() {

			@Override
			public int getSize() {
				return set.size();
			}

			@Override
			public Object getElementAt(int i) {
				return itemList.get(i);
			}
		});

		this.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent evt) {
				listValueChanged(evt);
			}
		});
	}
	
	/**
	 * creates a list that if item selected changes Window to PayPanel
	 * @param win the window
	 * @param items the list of items offered
	 * @param prices the prices for the items
	 */
	public ItemList(ReisePlaner win, ArrayList<String> items, ArrayList<Integer> prices) {
		this(win, items, prices, ReisePlaner.PAGE_PAY);
	}

	private void listValueChanged(ListSelectionEvent evt) {
		final String s = (String) this.getSelectedValue();

		window.updateText(set.get(s));

		window.changeWindow(destinationWindow);

	}
}
