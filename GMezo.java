package Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GMezo {

	protected Image kep;
	protected int z;
	protected Mezo mezo;

	GMezo(){
	}
	
	public void rajzol() {
		if(mezo.getPalyaszakasz()){
			try {
			    kep = ImageIO.read(new File("Normal.jpg"));
			} catch (IOException e) {
				
			}
		}else{
			try {
			    kep = ImageIO.read(new File("hole.jpg"));
			} catch (IOException e) {
				
			}
		}
			
	}
	
	public Mezo getMezo() {
		return mezo;
	}

	public void setMezo(Mezo mezo) {
		this.mezo = mezo;
	}

	/**
	 * 
	 * @param d
	 */
	public void compareTo(RajzolAble d) {
		// TODO - implement GMezo.compareTo
		throw new UnsupportedOperationException();
	}

}