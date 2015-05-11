package Graphics;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public class Palya_Menedzser extends MouseInputAdapter{

	private int kor = 10;//Ennyi a max korok szama
	private int olajkeszlet = 0;//Ennyi olaja lesz egy robotnak
	private int ragacskeszlet = 0;//Ennyi ragacsa lesz egy robotnak
	public Palya palya;//A keret el tudja hívni a pálya fv-it.
	private int robotszam = 0;//Ennyi robot lesz a pályán
	private int robocntr=0; //Ennyi robot lepett a körben
	private int[] cntr;//Ez számolja hanyszor volt cp kioszt vagy hoztak letre robotot
	
	private View view;

	private boolean isVege = false;

	/**
	 * PM Letrehozasa.
	 * @param szelesseg - Ekkora legyen a palya szelessege.
	 * @param magassag - Ekkora legyen a palya magassaga.
	 * @param robotszam - Ennyi jatekos legyen.
	 * @param kor - Ennyi korig menjen a jatek.
	 * @param ragacs - Ennyi ragacsa legyen a robotoknak.
	 * @param olaj - Ennyi olaja legyen a robotoknak.
	 */
	public Palya_Menedzser(int magassag, int szelesseg, int robotszam, int kor, int ragacs, int olaj) {
		this.kor = kor;
		this.ragacskeszlet = ragacs;
		this.olajkeszlet = olaj;
		this.robotszam = robotszam;
		this.robocntr = 0;
		this.cntr = new int[]{0, 0};//0. a cp. 1. kisrobot
		this.palya = palyaLetreHoz(magassag, szelesseg);
		this.view = new View();
		
	}
	
	public Palya_Menedzser(){}
	
	public Palya palyaLetreHoz(int magassag, int szelesseg){
		return new Palya(magassag, szelesseg, robotszam, olajkeszlet, ragacskeszlet);
	}
	
	//Valahogy meg kell oldani az inputok feldolgozasat. - Megbeszeles.
	
	/**
	 * Szamolja a koroket, ha letelt vege a jateknak. Egy kor akkor telik le, ha minden robot lepett egyet.
	 * Ha neggyel oszthato, akkor kiosztja a CP-ket.
	 * Minden kor vegen oregiti az olajfoltokat.
	 * Ha 0 vagy kissebb a korszam, akkor kivalasztja a gyoztest.
	 * Minden esetben a palya egy fv-jét hívja meg.
	 */
	public void korSzamol() {
		if(!isVege){//Ha nincs vege a jateknak.
			if (robotszam != 0)
				robocntr++;
			if (robocntr == robotszam) // ha minden robot lépett
			{
				kor--;
				for(int i = 0; i<cntr.length; ++i)
					cntr[i]++;
				if(kor>0){//Megy a jatek
					if(cntr[0] == 4){//Minden negyedik kor vegen kiosztjuk a cp-ket.
						palya.cpKioszt();
						cntr[0] = 0;
				}
					if(cntr[1] == 5){//Lasd szekvencia
						palya.kisrobotLetrehoz();//Release the MiniRobots!
						cntr[1] = 0;
				}
				palya.oregit();//Olaj szaradasa
				view.repaint();
				}else{//Itt van vege a jateknak.
					palya.gyoztesValaszt();
					isVege = true;
				}
			}
		}
		palya.oregit();
	}
	
	/**
	 * A pályán kattintanak.
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.paramString().equals("ROBOT_LEP")){
			Vektor egerPoz = new Vektor(e.getX(), e.getY());//Csak robot léptetéskor kattintunk.
			palya.vektorFeldolgoz(egerPoz);
			view.repaint();
		}
	}

	/**
	 * Ha egy robot lépne, akkor egy egység vektor rajzolódik ki és az megy kõrbe a robot körül.
	 */
	public void mouseDragged(MouseEvent e) {
		Vektor egerPoz = new Vektor(e.getX(), e.getY());//Egér jelenleg hol van
		Vektor[] mozgo = new Vektor[]{//Lehet, tagváltozónak jobb lenne.
				new Vektor(), //teteje
				new Vektor()  //alja
				};//Ez mozog a robot körül
		Vektor innen = this.palya.robotok.get(robocntr).getMezo().getPoziciovektor();//A this csak ráadás. :D It's so wrong! :D
		mozgo[1].setVektor(innen);
		
		int x = checkKoordinates(egerPoz, innen);
		
		if(x == 0){//Minden ok, pozicionálunk.
			mozgo[0].setVektor(egerPoz);
		}else{
			switch(x){
			case 1:
				mozgo[0].setY(egerPoz.getY());
				mozgo[0].setX(innen.getX()+10);
				break;
			case 2:
				mozgo[0].setX(egerPoz.getX());
				mozgo[0].setY(innen.getY()+10);
				break;
			case 3:
				mozgo[0].setY(innen.getY()+10);
				mozgo[0].setX(innen.getX()+10);
				break;
			case 4:
				mozgo[0].setY(egerPoz.getY());
				mozgo[0].setX(innen.getX()-10);
				break;
			case 5:
				mozgo[0].setX(egerPoz.getX());
				mozgo[0].setY(innen.getY()-10);
				break;
			default://6
				mozgo[0].setY(innen.getY()-10);
				mozgo[0].setX(innen.getX()-10);
				break;
			}
		}
	}
	
	/**
	 * Ellenõrzi a két vektor arányait. Melyik miben tér el.
	 * A poz. vektor közép pontja körül van egy 10 pixel sugarú kõr. (r = 10)
	 * Ha ezen belül van a koordináta, akkor minden ok. Ha nem, akkor megvizsgálja mi a gond.
	 * @param poz - Ezt veti össze...
	 * @param kozep - ... ezzel.
	 * @return
	 * Ha poz.x > kozep.x+10    --> 1
	 * Ha poz.y > kozep.y+10    --> 2
	 * Ha mind a kettõ nagyobb  --> 3
	 * Ha poz.x < kozep.x-10    --> 4
	 * Ha poz.y < kozep.y-10    --> 5
	 * Ha mind a kettõ kisebb   --> 6
	 * Ha ok, 			        --> 0
	 */
	private int checkKoordinates(Vektor poz, Vektor kozep){
		if(poz.getX() > kozep.getX()+10 && (poz.getY() >= kozep.getY()+10 || poz.getY() <= kozep.getY()-10) )
			return 1;// x túl nagy, de y ok
		if(poz.getY() > kozep.getY()+10 && (poz.getX() >= kozep.getX()+10 || poz.getX() <= kozep.getX()-10))
			return 2;// y túl nagy, de x ok
		if((poz.getX() > kozep.getX()+10) && (poz.getY() > kozep.getY()+10))
			return 3;//Minden túl nagy
		
		if(poz.getX() < kozep.getX()-10 && (poz.getY() >= kozep.getY()+10 || poz.getY() <= kozep.getY()-10) )
			return 4;// x túl kicsi, de y ok
		if(poz.getY() < kozep.getY()-10 && (poz.getX() >= kozep.getX()+10 || poz.getX() <= kozep.getX()-10))
			return 5;// y túl kicsi, de x ok
		if((poz.getX() < kozep.getX()-10) && (poz.getY() > kozep.getY()-10))
			return 6;//Minden túl kicsi
		
		return 0;//minden ok
	}

	/**
	 * Vissza adja a korok szamat.
	 * @return - Ennyi kor van meg.
	 */
	public int getKor() {
		return this.kor;
	}

	/**
	 *  Beallit egy kor hatart.
	 * @param kor - Eddig mehet.
	 */
	public void setKor(int kor) {
		this.kor = kor;
	}

	/**
	 * Ennyi olaja lesz a robotnak.
	 * @param olajkeszlet - Olaj szam.
	 */
	public void setOlajkeszlet(int olajkeszlet) {
		this.olajkeszlet = olajkeszlet;
	}

	/**
	 * Ennyi ragacsa lesz a robotnak.
	 * @param ragacskeszlet - Ragacs szam.
	 */
	public void setRagacskeszlet(int ragacskeszlet) {
		this.ragacskeszlet = ragacskeszlet;
	}

	/**
	 * Ennyi robot lesz a pályán
	 * @param robotszam - Robot szam.
	 */
	public void setRobotszam(int robotszam) {
		this.robotszam = robotszam;
	}
	
	/**
	 * Vissza adja a jatekban resztvevo robotok szamat.
	 * Kis robotok szamat nem adja vissza.
	 * @return - Robotok szama
	 */
	public int getRobotszam() {
		return robotszam;
	}
}