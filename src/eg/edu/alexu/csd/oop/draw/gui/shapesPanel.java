package eg.edu.alexu.csd.oop.draw.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.LineBorder;

import eg.edu.alexu.csd.oop.draw.Shape;

public class shapesPanel extends JPanel{
	
	private ArrayList<shapesBox> buttons = new ArrayList();
	//constructor
	public shapesPanel(List<Class<? extends Shape>> shapeslist) {
		super();
		this.setName("shapesPanel");
		this.setBackground(new Color(245, 246, 247));
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		ParallelGroup parallel = layout.createParallelGroup();
	    layout.setHorizontalGroup(parallel);
	    SequentialGroup sequential = layout.createSequentialGroup();
	    layout.setVerticalGroup(sequential);
	    
	    for(Class i : shapeslist){
			shapesBox creationBtn = new shapesBox(i.getSimpleName());
			parallel.addComponent(creationBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			sequential.addComponent(creationBtn);
			
			buttons.add(creationBtn);
			this.add(creationBtn);
		}
		
	}
	
	public void updateShapesPanel(List<Class<? extends Shape>> shapeslist){
		this.removeAll();
		this.revalidate();
		this.repaint();
		buttons.clear();
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
	    ParallelGroup parallel = layout.createParallelGroup();
	    layout.setHorizontalGroup(parallel);
	    SequentialGroup sequential = layout.createSequentialGroup();
	    layout.setVerticalGroup(sequential);
	    
		for(Class i : shapeslist){
			shapesBox creationBtn = new shapesBox(i.getSimpleName());
			parallel.addComponent(creationBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			 sequential.addComponent(creationBtn);
			
			buttons.add(creationBtn);
			this.add(creationBtn);
		}
		
	}
	
	public void addButtonsListeners(ActionListener listener){
		for(shapesBox i : buttons){
			i.addActionListener(listener);
		}
	}
	
}
