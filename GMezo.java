package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GMezo implements RajzolAble{

	protected Image kep;
	protected int z;
	protected Mezo mezo;

	GMezo(){
	}

	@Override
	public void rajzol(Graphics g) {
		if(mezo.getPalyaszakasz()){
			try {
				kep = ImageIO.read(new File("Normal.jpg"));
				g.drawImage(kep, 200, 200, null);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Hiba történt a kép beolvasása folyamán"+e.toString());
			}
		}else{
			try {
				kep = ImageIO.read(new File("Normal.jpg"));
				g.drawImage(kep, 200, 200, null);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Hiba történt a kép beolvasása folyamán"+e.toString());
			}
		}
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