package Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

public class View {

	private ArrayList<RajzolAble> rajzolAbles;
	protected JPanel panel;

	/**
	 * Kirajzolja ajáték elemeit. Mezõket, robototkat, stb.
	 */
	public void rajzolAll() {
		for (RajzolAble item : rajzolAbles) {
			item.rajzol();
		}
	}

}