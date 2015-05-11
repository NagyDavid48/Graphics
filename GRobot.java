package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRobot implements RajzolAble , Runnable{

	protected Image kep;
	protected Image kep2;
	protected int x;
	protected int y;
	protected Robot robot;
	protected Graphics gr = null;
	protected int i;
	protected View v;

	GRobot(View v) throws IOException{
		kep = ImageIO.read(new File("Kepek/robot.gif"));
		kep2 = ImageIO.read(new File("Kepek/Normal.gif"));
		//x = robot.getMezo().getPoziciovektor().getX();
		//y = robot.getMezo().getPoziciovektor().getY();
		this.v = v;
	}
	
	public void rajzol(Graphics g) {
	
		/*for(int i=0; i<200; i+=50){
			g.drawImage(kep, i, 50, null);
			try {Thread.sleep(80);} catch (InterruptedException e) {}//Így is lehet. Mást nem módosítottam.
	}
		*/
		
		g.drawImage(kep, 0, i, null);
		g.drawImage(kep2, 0, i-40, null);
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GRobot.compareTo
		throw new UnsupportedOperationException();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			for(i=0; i<320; i+=40){
				rajzol(v.getGraphics());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}