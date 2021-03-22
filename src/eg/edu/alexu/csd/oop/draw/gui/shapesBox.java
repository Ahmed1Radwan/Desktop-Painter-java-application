package eg.edu.alexu.csd.oop.draw.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class shapesBox extends JButton{
	
	// constructor
	public shapesBox(String shapeName) {
		super();
		this.setName(shapeName+"CreationBtn");
		this.setForeground(new Color(0,0,0));
		this.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	  	this.setForeground(Color.BLACK);
	  	this.setBackground(new Color(245, 246, 247));
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		
		try {
	  		this.setText(shapeName);
		} catch (Exception e) {
			this.setText("unKnown");
		}
		
		this.setToolTipText(shapeName);
	  	this.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	setBackground(new Color(232, 239, 247));
		    	setBorderPainted(true);
		    }

		    @Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
		    	setBackground(new Color(245, 246, 247));
		    	setBorderPainted(false);
		    }
		});
	}
	
	public void addShapeCreationListner(ActionListener listenForshapesBox){
		
		this.addActionListener(listenForshapesBox);
	
	}
	
}
