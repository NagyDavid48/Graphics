package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRobot implements RajzolAble {

	protected Image kep;
	protected int x;
	protected int y;
	protected Robot robot;

	GRobot() throws IOException{
		kep = ImageIO.read(new File("Kepek/robot.jpg"));
		//x = robot.getMezo().getPoziciovektor().getX();
		//y = robot.getMezo().getPoziciovektor().getY();
	}
	
	public void rajzol(Graphics g) {
	
		for(int i=0; i<200; i+=50){
			g.drawImage(kep, i, 50, null);
			try {Thread.sleep(80);} catch (InterruptedException e) {}//Így is lehet. Mást nem módosítottam.
	}
		g.drawImage(kep, 200,200, null);
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GRobot.compareTo
		throw new UnsupportedOperationException();
	}

}