package Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GRagacs implements RajzolAble {

	protected Image kep;
	protected int z;
	protected Ragacs ragacs;

	
	GRagacs() throws IOException{
		kep = ImageIO.read(new File("Kepek/glue.jpg"));
	}
	
	public void rajzol() {
		// TODO - implement GRagacs.rajzol
		throw new UnsupportedOperationException();
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