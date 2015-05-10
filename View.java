package Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

public class View {

	private ArrayList<RajzolAble> rajzolAbles;
	protected JPanel panel;

	/**
	 * Kirajzolja aj�t�k elemeit. Mez�ket, robototkat, stb.
	 */
	public void rajzolAll() {
		for (RajzolAble item : rajzolAbles) {
			item.rajzol();
		}
	}

}