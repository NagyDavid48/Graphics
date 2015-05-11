package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GOlaj implements RajzolAble {

	protected Image kep;
	int x;
	int y;
	protected Olajfolt olaj;

	
	GOlaj(int x, int y) throws IOException{
		kep = ImageIO.read(new File("Kepek/oil.gif"));
		this.x=x;
		this.y=y;
	}
	
	public void rajzol(Graphics g) {
		// TODO - implement GOlaj.rajzol
		if(olaj.getElet()!=0)
			g.drawImage(kep, x-20, y-20, null);
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