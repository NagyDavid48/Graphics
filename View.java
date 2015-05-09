package Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

public class View {

	private ArrayList<RajzolAble> rajzolAbles;
	protected JPanel panel;

	public void rajzolAll() {
		for (RajzolAble item : rajzolAbles) {
			item.rajzol();
		}
	}

}