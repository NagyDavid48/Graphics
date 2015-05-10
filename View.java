package Graphics;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel {

	private ArrayList<RajzolAble> rajzolAbles;

	/**
	 * Kirajzolja ajáték elemeit. Mezõket, robototkat, stb.
	 */
	public void rajzolAll(Graphics g) {
		for (RajzolAble item : rajzolAbles) {
			item.rajzol(g);
		}
	}
	
	protected void paintComponent(Graphics g){
		GRobot r;
		try {
			r = new GRobot();
			r.rajzol(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}