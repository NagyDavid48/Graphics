package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GOlaj implements RajzolAble {

	protected Image kep;
	protected int z;
	protected Olajfolt olaj;

	
	GOlaj() throws IOException{
		kep = ImageIO.read(new File("Kepek/oil.jpg"));
	}
	
	public void rajzol(Graphics g) {
		// TODO - implement GOlaj.rajzol
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GOlaj.compareTo
		throw new UnsupportedOperationException();
	}

}