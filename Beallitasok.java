package Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Beallitasok {

	protected JPanel panel;
	private int robotszam = 2;
	private int olajszam = 3;
	private int ragacsszam = 3;
	private int korszam = 10;
	
	JFrame f;
	
	JComboBox c_rob;
	JComboBox c_ol;
	JComboBox c_rag;
	JComboBox c_kor;
	
	JButton ok;
	
	public Beallitasok(){
		f = new JFrame("Beállítások");
		JLabel rob = new JLabel("Robotszám");
		JLabel ol = new JLabel("Olajszám");
		JLabel rag = new JLabel("Ragacsszám");
		JLabel kor = new JLabel("Körszám");
		String[] list1 = new String[]{"1", "2", "3", "4"};
		String[] korlist = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
		c_rob = new JComboBox(list1);
		c_ol = new JComboBox(list1);
		c_rag = new JComboBox(list1);
		c_kor = new JComboBox(korlist);
		c_rob.setSelectedIndex(robotszam-1);
		c_ol.setSelectedIndex(olajszam-1);
		c_rag.setSelectedIndex(ragacsszam-1);
		c_kor.setSelectedIndex(korszam-1);
		ok = new JButton("OK");
		ok.setActionCommand("ok");
		ok.addActionListener(new OkGombListener());
		c_rob.setActionCommand("c_rob");
		c_ol.setActionCommand("c_ol");
		c_rag.setActionCommand("c_rag");
		c_kor.setActionCommand("c_kor");

		GroupLayout layout = new GroupLayout(f.getContentPane());
		f.getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
	        layout.setAutoCreateContainerGaps(true);
	        layout.setHorizontalGroup(
	    			layout.createSequentialGroup()
	    			.addGap(100)
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(rob)
	    				.addComponent(ol)
	    				.addComponent(rag)
	    				.addComponent(kor))
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    				.addComponent(c_rob)
	    				.addComponent(c_ol)
	    				.addComponent(c_rag)
	    				.addComponent(c_kor))
	    			.addGroup(layout.createSequentialGroup()
	    				.addGap(250)
	    				.addComponent(ok))
	    		);
	    	layout.setVerticalGroup(
	    			layout.createSequentialGroup()
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(rob)
	    				.addComponent(c_rob))
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(ol)
	    				.addComponent(c_ol))
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(rag)
	    				.addComponent(c_rag))
	    			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	    				.addComponent(kor)
	    				.addComponent(c_kor))
	    			.addGroup(layout.createSequentialGroup()
	    				.addGap(10)
	    				.addComponent(ok))
	    		);
	    	JPanel p = new JPanel();
	    	p.add(ok);
	    	c_rob.setMaximumSize(new Dimension(50,10));
	    	c_ol.setMaximumSize(new Dimension(50,10));
	    	c_rag.setMaximumSize(new Dimension(50,10));
	    	c_kor.setMaximumSize(new Dimension(50,10));
	    	layout.linkSize(c_rob, c_ol, c_rag, c_kor);
	    	f.add(rag);
	    	f.add(ol);
	    	f.add(rob);
	    	f.add(kor);
	    	f.add(c_rob);
	    	f.add(c_ol);
	    	f.add(c_rag);
	    	f.add(c_kor);
	    	f.pack();
	    	f.setVisible(true);
	}

	public void beallitas() {
		robotszam = Integer.parseInt((String)c_rob.getSelectedItem());
		olajszam = Integer.parseInt((String)c_ol.getSelectedItem());
		ragacsszam = Integer.parseInt((String)c_rag.getSelectedItem());
		korszam = Integer.parseInt((String)c_kor.getSelectedItem());
	}

	public int getRobotszam() {
		return this.robotszam;
	}

	public int getOlajszam() {
		return this.olajszam;
	}

	public int getRagacsszam() {
		return this.ragacsszam;
	}

	public int getKorszam() {
		return this.korszam;
	}
	
	private class OkGombListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg) {
			if(arg.getActionCommand().equals("ok")){
				beallitas();
				f.setVisible(false);
			}
		}
		
	}

}