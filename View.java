package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel {

	private ArrayList<RajzolAble> rajzolAbles;
	private int[] line;

	public View(){
		rajzolAbles = new ArrayList<RajzolAble>();
	}
	
	public void addElment(RajzolAble element){
		rajzolAbles.add(element);
	}
	
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
			g.clearRect(0, 0, 900, 600);
			r = new GRobot();
			r.rajzol(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		g.clearRect(0, 0, 900, 600);
		if (line != null)
			g.setColor(Color.RED);
			g.drawLine(line[0], line[1], line[2], line[3]);
	}

	public void proba(int x, int y, Graphics g){
		g.drawRect(x, y, 30, 30);
	}
	
	public void eger(int x, int y, Graphics g){
//		g.drawLine(200, 200, x, y);
		setline(219, 219, x, y);
	}

	private void setline(int i, int j, int x, int y) {
		double angle=Math.atan2(y-j, x-i);
		line=new int[]{i, j, (int) Math.floor(i+Math.cos(angle)*40), (int) Math.floor(j+Math.sin(angle)*40)};
	}

}