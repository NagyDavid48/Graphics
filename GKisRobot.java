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
		img = ImageIO.read(new File("Kepek/Cleaner_robot.gif"));

//		elozo = new Vektor(kisRobot.getMezo().getPoziciovektor().getX(), 
//						   kisRobot.getMezo().getPoziciovektor().getY());//itt mÃ©g a jelenlegi poziciÃ³val egyenlÅ‘

	}
	
	public void rajzol(Graphics g) {
//		Vektor uj = new Vektor(kisRobot.getMezo().getPoziciovektor().getX(),
//							   kisRobot.getMezo().getPoziciovektor().getY());//Megváltozott poziciÃ³
//		
//		if(uj.getX()!=elozo.getX() || uj.getY()!=elozo.getY()){//ha változás van, akkor kirajzoljuk a mozgást
//			Vektor kulonbseg = uj.addVektor2(elozo);//Vesszük a különbséget
//			//kulonbseg.skalarOszt(2);
//			while(elozo.getX() == uj.getX() && elozo.getY() == uj.getY()) {
//				elozo.addVektor(kulonbseg);
//				g.drawImage(img, elozo.getX(), elozo.getY(), null);
//			}
//			elozo.setVektor(uj);
//		}//Ha nincs, akkor kihagyjuk a fenti rÃ©szt
		if(!this.kisRobot.getKiesett()){
			int x = kisRobot.getMezo().getPoziciovektor().getY()*2-20;
			int y = kisRobot.getMezo().getPoziciovektor().getX()*2-20;
	//		System.out.println(kisRobot.toString()+" : "+kisRobot.getMezo().toString()+" vekvek "+ x+" "+y);
			g.drawImage(img, x, y, null);
		}
		
//		g.drawImage(img, elozo.getX(), elozo.getY(), null);//Rajzoljuk a helyÃ©re
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
