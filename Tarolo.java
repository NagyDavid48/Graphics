package Graphics;

public class Tarolo {

	public static Mezo[][] mezok;

	/**
	 * 
	 * @param szelesseg
	 * @param magassag
	 */
	public Tarolo(int magassag, int szelesseg) {
		Mezo[][] tmp = new Mezo [magassag][szelesseg];
		
		for(int i = 0 ; i<magassag; i++)
			for(int j = 0 ; j<szelesseg; j++){
				int koordX = (i*2+1)*10;															// ha 20 széles a mezõ
				int koordY = (j*2+1)*10;
				tmp[i][j] = new Mezo(false, true, null, null, new Vektor(koordX, koordY));	
			}
		
		///Szakadékok beállítása több darabban, hogy kényelmes legyen
		for(int i=1; i<9; i++){
			for(int j=1; j<4 ; j++){
				tmp[i][j].setPalyaszakasz(false);
				tmp[i][szelesseg-j-1].setPalyaszakasz(false);
			}	
		}
		
		for(int i=3; i<7; i++){
			tmp[i][4].setPalyaszakasz(false);
			tmp[i][szelesseg-4-1].setPalyaszakasz(false);
			tmp[i][szelesseg-7-1].setPalyaszakasz(false);
			tmp[i][szelesseg-8-1].setPalyaszakasz(false);
		}
		
		for(int j=6; j<10; j++){
			tmp[1][j].setPalyaszakasz(false);
			tmp[4][j].setPalyaszakasz(false);
			tmp[5][j].setPalyaszakasz(false);
			tmp[8][j].setPalyaszakasz(false);
		}
		
		mezok = tmp;
	}

	public static Mezo[][] getMezok() {
		return mezok;
	}

	/**
	 * 
	 * @param koordinata
	 */
	public static Mezo getMezo(int[] koordinata) {
		return mezok[koordinata[0]][koordinata[1]];
	}
		

}
