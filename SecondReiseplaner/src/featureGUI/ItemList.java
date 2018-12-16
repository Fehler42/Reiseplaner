package featureGUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ItemList extends JList {

	private static final long serialVersionUID = 7435490687240344649L;

	private HashMap<String, Integer> set;
	private ArrayList<String> itemList;
	private ReisePlaner window;

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public ItemList(ReisePlaner win, ArrayList<String> items, ArrayList<Integer> prices) {
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

	private void listValueChanged(ListSelectionEvent evt) {
		final String s = (String) this.getSelectedValue();

		window.updateText(set.get(s));

		window.changeWindow(window.PAGE_PAY);

	}
}
