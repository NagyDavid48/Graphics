package Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.*;

public class Window extends JFrame {

	protected View view;
	private Palya_Menedzser palya_Menedzser;
	private Menu menu;
	
	Window(){
		view=new View();
		palya_Menedzser=new Palya_Menedzser();
		menu = new Menu();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Phoebe");
		setSize(400, 300);
		setResizable(false);
		
		JButton ujJatekGomb = new JButton("Új játék");
		JButton beallitasokGomb = new JButton("Beállítások");
		JButton kilepesGomb = new JButton("Kilépés");
		
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();	
		
		this.setLayout(new BorderLayout(10,100));

		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		
		centerPanel.add(ujJatekGomb);
		centerPanel.add(beallitasokGomb);
		centerPanel.add(kilepesGomb);
		
		
		ujJatekGomb.setPreferredSize(new Dimension(80, 25));
		beallitasokGomb.setPreferredSize(new Dimension(100, 25));
		kilepesGomb.setPreferredSize(new Dimension(80, 25));
		
		ujJatekGomb.addActionListener(new MenuGombListener());
		beallitasokGomb.addActionListener(new MenuGombListener());
		kilepesGomb.addActionListener(new MenuGombListener());

		ujJatekGomb.setActionCommand("newgame");
		beallitasokGomb.setActionCommand("options");
		kilepesGomb.setActionCommand("exit");
		
		//this.pack();
	}

	public void megjelenites() {
		// TODO - implement Window.megjelenites
		throw new UnsupportedOperationException();
	}

	private class MenuGombListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg) {
			// TODO Auto-generated method stub
			if(arg.getActionCommand().equals("newgame"))
				menu.ujJatek();
			else if(arg.getActionCommand().equals("options"))
				menu.beallítasok();
			else if(arg.getActionCommand().equals("exit"))
				menu.kilepes();
		}
		
	}
	
}