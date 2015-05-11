package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRagacs implements RajzolAble {

	protected Image kep;
	protected Ragacs ragacs;
	int x;
	int y;
	
	GRagacs(int x, int y) throws IOException{
		kep = ImageIO.read(new File("Kepek/glue.gif"));
		this.x=x;
		this.y=y;
	}
	
	public void rajzol(Graphics g) {
		// TODO - implement GRagacs.rajzol
		if(ragacs.getElet()!=0)
			g.drawImage(kep, x-20, y-20, null);
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GRagacs.compareTo
		throw new UnsupportedOperationException();
	}

}