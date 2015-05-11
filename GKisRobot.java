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
						   kisRobot.getMezo().getPoziciovektor().getY());//itt m�g a jelenlegi pozici�val egyenl�
	}
	
	/**
	 * Mozgat�st az egyenes ir�ny vektoros egyenlet�vel oldom meg.
	 * Uj(x1, y1)
	 * Elozo(x0, y0)
	 * Irany(x1-x0, y1-y0)
	 * Amelyik pont az egyenesre illeszkedik, arra megy.
	 */
	public void rajzol(Graphics g) {
		
		Vektor uj = new Vektor(kisRobot.getMezo().getPoziciovektor().getX(),
							   kisRobot.getMezo().getPoziciovektor().getY());//Megv�ltozott pozici�
		if(uj.getX()!=elozo.getX() || uj.getY()!=elozo.getY()){//ha v�ltoz�s van, akkor kirajzoljuk a mozg�st
			Vektor iranyVektor = new Vektor(uj.getX()-elozo.getX(), uj.getY()-elozo.getY());
			
			Vektor egyenletBal = new Vektor(iranyVektor.getY(), iranyVektor.getX());//v2*x-v1*y
			int egyenletJobb = iranyVektor.getY()*elozo.getX()-iranyVektor.getY()*elozo.getY();//a konstans
			
			int i = 1;
			while(elozo.getX()==uj.getX() && elozo.getY()==uj.getY()){
				if(egyenletJobb == (egyenletBal.getY()*i-egyenletBal.getX()*i)){//Ha megegyezik a konstanssal
					elozo.addVektor(new Vektor());//Ezt nem v�gom m�g
					g.drawImage(img, elozo.getX(), elozo.getY(), null);
					try {Thread.sleep(210);} catch (InterruptedException e) {}
				}
				i++;
			}
			
			elozo.setVektor(uj);
		}//Ha nincs, akkor kihagyjuk a fenti r�szt
		g.drawImage(img, elozo.getX(), elozo.getY(), null);//Rajzoljuk a hely�re
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