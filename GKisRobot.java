package Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GKisRobot implements RajzolAble {

	protected Image img;
	protected int z;
	protected KisRobot kisRobot;

	
	GKisRobot() throws IOException{
		img = ImageIO.read(new File("Kepek/Cleaner_robot.jpg"));
	}
	
	public void rajzol() {
		// TODO - implement GKisRobot.rajzol
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GKisRobot.compareTo
		throw new UnsupportedOperationException();
	}

}