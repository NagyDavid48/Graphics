package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRagacs implements RajzolAble {

	protected Image kep;
	protected int z;
	protected Ragacs ragacs;
	
	private Graphics g;

	
	GRagacs() throws IOException{
		kep = ImageIO.read(new File("glue.jpg"));
	}
	
	public void rajzol() {
		// TODO - implement GRagacs.rajzol
		if(ragacs.getElet()==0)
			return;
		else{
			g.drawImage(kep, 0, 0, null);
		}
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