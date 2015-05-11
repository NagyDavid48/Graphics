package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel {

	private ArrayList<RajzolAble> rajzolAbles;
	private int[] line;
	private int[] vektor;

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
//		for (RajzolAble item : rajzolAbles) {
//			item.rajzol(g);
//		}
		for (Mezo mt[] : Tarolo.getMezok()){
			for (Mezo m : mt){
				GMezo gm = new GMezo();
				gm.mezo = m;
				gm.rajzol(g);
			}
		}
		for (RajzolAble item : rajzolAbles) {
			item.rajzol(g);
		}
	}
	
	protected void paintComponent(Graphics g){
		GRobot r;
//		try {
//			g.clearRect(0, 0, 900, 600);
//			r = new GRobot();
//			r.rajzol(g);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		g.clearRect(0, 0, 900, 600);
		rajzolAll(g);
		if (line != null){
			g.setColor(Color.RED);
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
		if (vektor != null){
			g.setColor(Color.GREEN);
			g.drawLine(vektor[0], vektor[1], vektor[2], vektor[3]);
		}
	}

	public void proba(int x, int y, Graphics g){
		g.drawRect(x, y, 30, 30);
	}
	
	public void eger(int i, int j, int x, int y, Graphics g){
//		g.drawLine(200, 200, x, y);
		setline(i, j, x, y);
	}

	private void setline(int i, int j, int x, int y) {
		line=new int[]{i, j, x, y};
	}
	public Vektor getVektor(int i, int j, int x, int y) {
		return new Vektor((y-j)/2, (x-i)/2);
	}
	public void setvektor(int i, int j, int x, int y) {
		vektor = new int[]{i, j, x, y};
	}

}