package Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRobot implements RajzolAble {

	protected Image kep;
	protected int z;
	protected Robot robot;

	GRobot() throws IOException{
		kep = ImageIO.read(new File("Kepek/robot.jpg"));
	}
	
	public void rajzol() {
		// TODO - implement GRobot.rajzol
		throw new UnsupportedOperationException();
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