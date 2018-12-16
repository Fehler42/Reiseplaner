package start;
import featureGUI.ReisePlaner;

public class Main {

	public static ReisePlaner window;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				window = new ReisePlaner();
				
			}
		});
	}
}
