package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {

	protected JPanel panel;
	protected Beallitasok beallit;
	protected JPanel szoveg;
	
	public Menu(){
		panel = new View();
		panel.setSize(new Dimension(900, 600));
		panel.setPreferredSize(new Dimension(900, 600));
		panel.setMaximumSize(new Dimension(900, 600));
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void ujJatek() {
		JFrame frame = new JFrame();
		frame.setTitle("Phoebe");
		frame.setSize(740,428);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel palya = new JPanel();
		if(beallit == null){
			beallit=new Beallitasok();
			beallit.f.setVisible(false);
		}
			
		
		JPanel oldalsav = new JPanel();
		oldalsav.setSize(new Dimension(100, 600));
		oldalsav.setPreferredSize(new Dimension(100, 600));
		oldalsav.setMaximumSize(new Dimension(100, 600));
		
		szoveg = new JPanel();
		szoveg.setSize(new Dimension(100, 500));
		szoveg.setPreferredSize(new Dimension(100, 520));
		szoveg.setMaximumSize(new Dimension(100, 520));
		
		JPanel gombok = new JPanel();
		gombok.setSize(new Dimension(100, 100));
		gombok.setPreferredSize(new Dimension(100, 80));
		gombok.setMaximumSize(new Dimension(100, 80));

		JButton olaj = new JButton("Olaj");
		JButton ragacs = new JButton("Ragacs");
		olaj.setAlignmentX(Component.CENTER_ALIGNMENT);
		ragacs.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		gombok.setLayout(new BoxLayout(gombok, BoxLayout.Y_AXIS));
		gombok.add(olaj);
		gombok.add(Box.createRigidArea(new Dimension(0,5)));
		gombok.add(ragacs);
		
		oldalsav.setLayout(new BoxLayout(oldalsav, BoxLayout.Y_AXIS));
		oldalsav.add(szoveg);
		oldalsav.add(Box.createRigidArea(new Dimension(0,5)));
		oldalsav.add(gombok);
		
		palya.setSize(1000, 600);
		palya.setLayout(new BoxLayout(palya, BoxLayout.X_AXIS));
		palya.add(panel);
		palya.add(oldalsav);
		
		frame.add(palya);
		frame.repaint();
		frame.setVisible(true);
		Palya_Menedzser pm = new Palya_Menedzser(10, 16, beallit.getRobotszam(), beallit.getKorszam(), beallit.getRagacsszam(), beallit.getOlajszam(), (View)panel);
		panel.addMouseListener(pm);
		panel.addMouseMotionListener(pm);
		panel.repaint();
		
	}

	public void beallítasok() {
		beallit = new Beallitasok();
	}

	public void kilepes() {
		System.exit(0);
	}

}