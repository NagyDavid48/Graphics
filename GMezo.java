package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GMezo implements RajzolAble{

	protected Image kep;
	protected Mezo mezo;

	GMezo(){
	}

	@Override
	public void rajzol(Graphics g) {
		if(mezo.getCheckpoint()){
			try {
				if(kep == null)
				kep=ImageIO.read(new File("Kepek/checkpoint.gif"));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Hiba történt a kép beolvasása folyamán"+e.toString());
			}
			g.drawImage(kep, mezo.getPoziciovektor().getY()-20, mezo.getPoziciovektor().getX()-20, null);
		}
		else if(mezo.getPalyaszakasz()){
				try {
					if(kep == null)
					kep = ImageIO.read(new File("Kepek/Normal.gif"));
//					g.drawImage(kep, 200, 200, null);
					g.drawImage(kep, mezo.getPoziciovektor().getY()-20, mezo.getPoziciovektor().getX()-20, null);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Hiba történt a kép beolvasása folyamán"+e.toString());
				}
			}else{
				try {
					if(kep == null)
					kep = ImageIO.read(new File("Kepek/hole.gif"));
//					g.drawImage(kep, 200, 200, null);
					g.drawImage(kep, mezo.getPoziciovektor().getY()-20, mezo.getPoziciovektor().getX()-20, null);
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