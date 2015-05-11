package Graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GKisRobot implements RajzolAble {

	protected Image img;
	protected int  z;
	protected Vektor elozo;
	protected KisRobot kisRobot;

	
	GKisRobot() throws IOException{
		img = ImageIO.read(new File("Kepek/Cleaner_robot.jpg"));
		elozo = new Vektor(kisRobot.getMezo().getPoziciovektor().getX(), 
						   kisRobot.getMezo().getPoziciovektor().getY());//itt még a jelenlegi pozicióval egyenlő
	}
	
	public void rajzol(Graphics g) {
		Vektor uj = new Vektor(kisRobot.getMezo().getPoziciovektor().getX(),
							   kisRobot.getMezo().getPoziciovektor().getY());//Megváltozott pozició
		if(uj.getX()!=elozo.getX() || uj.getY()!=elozo.getY()){//ha változás van, akkor kirajzoljuk a mozgást
			Vektor kulonbseg = uj.addVektor2(elozo);
			//kulonbseg.skalarOszt(2);
			while(elozo.getX() == uj.getX() && elozo.getY() == uj.getY()) {
				elozo.addVektor(kulonbseg);
				g.drawImage(img, kulonbseg.getX(), kulonbseg.getY(), null);
			}
			elozo.setVektor(uj);
		}//Ha nincs, akkor kihagyjuk a fenti részt
		g.drawImage(img, elozo.getX(), elozo.getY(), null);//Rajzoljuk a helyére
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
